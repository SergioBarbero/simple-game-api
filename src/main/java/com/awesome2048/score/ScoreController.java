package com.awesome2048.score;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ScoreController {

    @GetMapping("/scores")
    public String scores() {
        return "Hello world";
    }
}
