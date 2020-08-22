package com.alekslitvinenk.kalahi.controller;

import com.alekslitvinenk.kalahi.model.*;
import com.alekslitvinenk.kalahi.service.GameStateService;
import com.alekslitvinenk.kalahi.service.GameTokenService;
import com.alekslitvinenk.kalahi.service.PlayerRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GameController {

    @Autowired
    private GameStateService gameStateService;
    @Autowired
    private PlayerRoleService playerRoleService;
    @Autowired
    private GameTokenService gameTokenService;

    @GetMapping("init")
    public InitGameDTO initPlayer() {
        GameState gameState = gameStateService.getNotConcludedOrCreateNewGame();
        PlayerRole playerRole = playerRoleService.getPlayerRoleFromGameState(gameState);

        if (playerRole == PlayerRole.PlayerA) {
            gameState.setPlayerA(new PlayerState());
        } else {
            gameState.setPlayerB(new PlayerState());
        }

        String gameToken = gameTokenService.getTokenForGameIdAndPlayerRole(gameState.getGameId(), playerRole);
        return new InitGameDTO(gameToken, playerRole, gameState);
    }

    @GetMapping("step")
    public StepDTO doStep(@RequestParam("gameToken") String gameToken,
                          @RequestParam("pitId") Integer pitId) {
        return new StepDTO();
    }
}
