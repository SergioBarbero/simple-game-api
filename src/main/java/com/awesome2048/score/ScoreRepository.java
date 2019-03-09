package com.awesome2048.score;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ScoreRepository extends CrudRepository<Score, Long> {

    @Query("SELECT * FROM scores ORDER BY score DESC LIMIT :n")
    public List<Score> findNBest(@Param("n") int n);
}
