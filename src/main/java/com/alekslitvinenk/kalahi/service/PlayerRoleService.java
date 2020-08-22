package com.alekslitvinenk.kalahi.service;

import com.alekslitvinenk.kalahi.exception.GameConcludedException;
import com.alekslitvinenk.kalahi.model.GameState;
import com.alekslitvinenk.kalahi.model.PlayerRole;
import org.springframework.stereotype.Service;

@Service
public class PlayerRoleService {

    public PlayerRole getPlayerRoleFromGameState(GameState gameState) {
        if (!gameState.hasPlayerA() && !gameState.hasPlayerB()) {
            return PlayerRole.PlayerA;
        } else if (gameState.hasPlayerA() && !gameState.hasPlayerB()) {
            return PlayerRole.PlayerB;
        } else {
            throw new GameConcludedException();
        }
    }
}
