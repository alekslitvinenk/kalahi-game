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
    public InitGameResponse initPlayer() {
        GameState gameState = gameStateService.getNotConcludedOrCreateNewGame();
        PlayerRole playerRole = playerRoleService.getPlayerRoleFromGameState(gameState);

        String gameToken = gameTokenService.getTokenForGameIdAndPlayerRole(gameState.getGameId(), playerRole);
        return new InitGameResponse(gameToken, playerRole, gameState);
    }

    @GetMapping("step")
    public GameState doStep(@RequestParam("gameToken") String gameToken,
                          @RequestParam("pitId") Integer pitId) {
        GameTokenParams gameTokenParams = gameTokenService.getGameParamsFromToken(gameToken);
        return gameStateService.doGameStep(gameTokenParams.getGameId(), gameTokenParams.getPlayerRole(), pitId);
    }
}
