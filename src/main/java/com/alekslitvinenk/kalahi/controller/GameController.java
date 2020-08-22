package com.alekslitvinenk.kalahi.controller;

import com.alekslitvinenk.kalahi.dto.InitGameDTO;
import com.alekslitvinenk.kalahi.dto.StepDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GameController {

    @GetMapping("hello")
    public String helloWorld() {
        return "Hello World";
    }

    @GetMapping("init")
    public InitGameDTO initPlayer() {
        return new InitGameDTO("");
    }

    @GetMapping("step")
    public StepDTO doStep(@RequestParam("gameSession") String gameSession,
                          @RequestParam("pitId") Integer pitId) {
        return new StepDTO();
    }
}
