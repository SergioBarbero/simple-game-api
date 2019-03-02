package com.awesome2048.score;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class ScoreController {

    @Autowired
    ScoreRepository repository;

    @GetMapping("/scores")
    public List<Score> fetchScores() throws JsonProcessingException {
        List<Score> scores = (List<Score>) repository.findAll();
        return scores;
    }

    @PostMapping("/scores")
    public Score newScore(@RequestBody Score newScore, HttpServletRequest request) {
        newScore.setIp(request.getRemoteAddr());
        repository.save(newScore);
        return newScore;
    }
}
