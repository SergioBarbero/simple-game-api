package com.awesome2048.score;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScoreRepository extends CrudRepository<Score, Long> {

    @Query(value = "SELECT * FROM scores ORDER BY score DESC LIMIT :n", nativeQuery = true)
    public List<Score> findNBest(@Param("n") int n);

    @Override
    @Query(value = "SELECT * FROM scores ORDER BY score DESC", nativeQuery = true)
    public List<Score> findAll();
}
