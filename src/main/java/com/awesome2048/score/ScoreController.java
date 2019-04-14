package com.awesome2048.score;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

@RestController
public class ScoreController {

    @Autowired
    ScoreRepository repository;

    @GetMapping("/scores")
    public List<Score> getScores(@RequestParam(value = "limit", required = false) Integer limit) {
        return (limit == null) ? repository.findAll() : repository.findNBest(limit);
    }

    @PostMapping("/scores")
    public Score postScore(@RequestBody Score newScore, HttpServletRequest request) throws IOException {
        String query = "http://api.ipinfodb.com/v3/ip-country/?key=62ee2a10303261af0cf55d6eb2c807c8db5e6fa539fe5ba843c341f4062bfaea&format=json&ip=" + request.getRemoteAddr();
        String countryCode = ExternalService.readFieldFromGetRequest(query, "countryCode");
        newScore.setCountryCode(countryCode);
        repository.save(newScore);
        return newScore;
    }
}
