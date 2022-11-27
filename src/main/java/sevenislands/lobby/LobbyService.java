package sevenislands.lobby;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sevenislands.exceptions.NotExistLobbyException;
import sevenislands.user.User;


@Service
public class LobbyService {
    
    private LobbyRepository lobbyRepository;
    private final Integer minPlayers = 0;
    private final Integer maxPlayers = 4;

    @Autowired
    public LobbyService(LobbyRepository lobbyRepository){
        this.lobbyRepository=lobbyRepository;
    }

    /**
     * Crea un código aleatorio para la lobby.
     * @return String
     */
    public String generatorCode() {
        String CHAR_LIST = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Integer RANDOM_STRING_LENGTH = 8;
        StringBuffer randomString = new StringBuffer();
        
        for(int i = 0; i<RANDOM_STRING_LENGTH; i++) {
            Random randomGenerator = new Random();
            char ch = CHAR_LIST.charAt(randomGenerator.nextInt(CHAR_LIST.length()-1));
            randomString.append(ch);
        }
        return randomString.toString();
    }
    
    @Transactional(readOnly = true)
    public Integer numPartidas() {
        return lobbyRepository.getNumOfLobby();
    }

    @Transactional
	public void save(Lobby lobby) {
        lobbyRepository.save(lobby);
	}
    //TODO: eliminar método
    @Transactional 
	public void update(Lobby lobby) {
	    lobbyRepository.updateLobby(lobby, lobby.getId());
	}

    @Transactional(readOnly = true, rollbackFor = NotExistLobbyException.class)
    public Optional<Lobby> findLobbyByCode(String code) throws NotExistLobbyException {
        Optional<Lobby> lobby = lobbyRepository.findByCode(code);
        if(lobby != null){
            return lobby;
        } else {
            throw new NotExistLobbyException();
        }
    }

    @Transactional(rollbackFor = NotExistLobbyException.class)
    public Optional<Lobby> findLobbyByPlayer(Integer user_id) {
        return lobbyRepository.findById(lobbyRepository.findLobbyIdByPlayer(user_id));

    }

    @Transactional
	public Boolean checkLobbyByCode(String code) {
		return lobbyRepository.checkLobby(code);
	}

    @Transactional
	public Boolean checkUserLobbyById(Integer id) {
	    return lobbyRepository.findLobbyIdByPlayer(id)!=null;
	}

    @Transactional
	public Boolean checkUserLobbyByNickname(String name) {
	    return lobbyRepository.findLobbyByNicknamePlayer(name)!=null;
	}

    @Transactional
    public void createLobby(User user) {
		Lobby lobby = new Lobby();
		lobby.setCode(generatorCode());
		lobby.setActive(true);
		lobby.addPlayer(user);
		save(lobby);
    }

    @Transactional
    public void leaveLobby(User user) {
		Optional<Lobby> lobby = findLobbyByPlayer(user.getId());
		if(lobby.isPresent()) {
            Lobby lobby2 = lobby.get();
            List<User> users = lobby2.getPlayerInternal();
		if (users.size() == 1) {
			lobby2.setActive(false);
		}
		users.remove(user);
		lobby2.setUsers(users);
		save(lobby2);
        }
    }

    @Transactional
    public Boolean ejectPlayer(User authUser, User userEjected) {
		Lobby lobby = findLobbyByPlayer(userEjected.getId()).get();
		List<User> users = lobby.getPlayerInternal();
		if (userEjected.getNickname().equals(authUser.getNickname())) {
            leaveLobby(authUser);
			return false;
		} else {
			users.remove(userEjected);
			lobby.setUsers(users);
			save(lobby);
			return true;
		}
    }

    @Transactional
    public Boolean validateJoin(String code, User user) throws NotExistLobbyException {
        code = code.trim();
        Optional<Lobby> lobby = findLobbyByCode(code);
        Integer userNumber = lobby.get().getUsers().size();
		if (lobby.isPresent() && lobby.get().isActive() && userNumber != null && userNumber > minPlayers && userNumber < maxPlayers) {
			lobby.get().addPlayer(user);
			save(lobby.get());
            return true;
		} else return false;
    }

    @Transactional
    public List<String> checkLobbyErrors(String code) throws NotExistLobbyException {
        List<String> errors = new ArrayList<>();
		Optional<Lobby> lobby = findLobbyByCode(code);
        if(lobby.isPresent()) {
            Integer userNumber = lobby.get().getUsers().size();
		    if(!lobby.get().isActive()) errors.add("La partida ya ha empezado o ha finalizado");
		    if(userNumber == maxPlayers) errors.add("La lobby está llena");
        }
        errors.add("No existe ninguna partida con ese código");
        return errors;
    }
}