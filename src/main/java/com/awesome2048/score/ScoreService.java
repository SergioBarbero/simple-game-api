package com.awesome2048.score;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScoreService {

    @Autowired
    private ScoreRepository repository;

    public List<Score> getScores() {
        return repository.findAll();
    }

    public List<Score> getScores(int n) {
        return repository.findNBest(n);
    }

    public void addScore(Score score, String countryCode) {
        score.setCountryCode(countryCode);
        repository.save(score);
    }

}
