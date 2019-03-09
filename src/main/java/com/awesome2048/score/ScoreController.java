package com.awesome2048.score;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

import org.springframework.web.client.RestTemplate;


@RestController
public class ScoreController {

    @Autowired
    ScoreRepository repository;

    @GetMapping("/scores")
    public List<Score> fetchScores(@RequestParam(value = "limit", required = false) Integer limit) {
        if (limit == null) {
            return (List<Score>) repository.findAll();
        } else {
            return repository.findNBest(limit);
        }
    }

    @PostMapping("/scores")
    public Score newScore(@RequestBody Score newScore, HttpServletRequest request) throws IOException {
        String query = "http://api.ipinfodb.com/v3/ip-country/?key=62ee2a10303261af0cf55d6eb2c807c8db5e6fa539fe5ba843c341f4062bfaea&format=json&ip=" + request.getRemoteAddr();
        String userInfo = new RestTemplate().getForObject(query, String.class);
        String countryCode = ExternalService.readField(userInfo, "countryCode");
        newScore.setCountryCode(countryCode);
        repository.save(newScore);
        return newScore;
    }
}
