package com.awesome2048.score;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.awesome2048.score.ScoreRepository;

import java.util.List;

@RestController
public class ScoreController {

    @Autowired
    ScoreRepository repository;

    @GetMapping("/scores")
    public String fetchScores() {
        String result = "";

        for (Score score: repository.findAll()) {
            result += score.toString();
        }
        return result;
    }
}
