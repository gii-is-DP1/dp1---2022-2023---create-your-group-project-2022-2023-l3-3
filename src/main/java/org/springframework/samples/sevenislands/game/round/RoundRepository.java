package org.springframework.samples.sevenislands.game.round;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface RoundRepository extends CrudRepository<Round, Integer> {

    @Query("SELECT round FROM Round round WHERE round.game.id=?1")
    public List<Round> findRoundByGameId(int id) throws DataAccessException;

    @Modifying
    @Query("UPDATE Round round SET round=?1 WHERE round.id=?2")
    public void updateRound(Round round, Integer round_id);
}
