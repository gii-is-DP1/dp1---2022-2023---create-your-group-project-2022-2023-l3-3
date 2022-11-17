package sevenislands.game;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface GameRepository extends CrudRepository<Game, Integer> {

    @Query("SELECT game FROM Game game WHERE game.lobby.id=?1")
    public Optional<Game> findGamebByLobbyId(Integer code);

    @Query("SELECT count(game) FROM Game game")
    public Integer getNumOfGames();
}
