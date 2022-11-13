package sevenislands.game;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface GameRepository extends CrudRepository<Game, Integer> {
    @Query("SELECT game FROM Game game WHERE game.id=?1")
    public Game findGamebByLobbyId(Integer code);

}
