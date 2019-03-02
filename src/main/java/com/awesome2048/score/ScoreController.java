package com.awesome2048.score;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class ScoreController {

    @Autowired
    ScoreRepository repository;

    @GetMapping("/scores")
    public String fetchScores() throws JsonProcessingException {
        List<Score> scores = (List<Score>) repository.findAll();

        ObjectMapper mapper = new ObjectMapper();
        SimpleModule module = new SimpleModule("ScoreSerializer");
        module.addSerializer(Score.class, new ScoreSerializer());
        mapper.registerModule(module);
        return mapper.writeValueAsString(scores);
    }
}
