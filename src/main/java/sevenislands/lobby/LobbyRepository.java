package sevenislands.lobby;

import java.util.Collection;
import java.util.Optional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LobbyRepository extends CrudRepository<Lobby,Integer> {

    @Modifying
    @Query("UPDATE Lobby lobby SET lobby=?1 WHERE lobby.id=?2")
    public void updateLobby(Lobby lobby, Integer lobby_id);

    @Query("SELECT lobby FROM Lobby lobby WHERE lobby.code=?1")
	public Optional<Lobby> findByCode(String code);
    
    @Query(value = "SELECT l.id FROM Lobby l INNER JOIN l.users u WHERE u.id=?1")
    public Integer findLobbyIdByPlayer(Integer player_id);

    @Query(value = "SELECT l.id FROM Lobby l INNER JOIN l.users u WHERE u.nickname=?1 AND l.active=true")
    public Optional<Integer> findLobbyByNicknamePlayer(String nickname);
    
    @Query("SELECT DISTINCT lobby FROM Lobby lobby where lobby.active=true")
    public Collection<Lobby> findAllActiveLobby();
   
    @Query("SELECT count(lobby)=1 FROM Lobby lobby WHERE lobby.code=?1")
    public Boolean checkLobby(String code);
    
    @Query("SELECT count(lobby) FROM Lobby lobby")
    public Integer getNumOfLobby();
}
