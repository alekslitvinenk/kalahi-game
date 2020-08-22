package com.alekslitvinenk.kalahi.service;

import com.alekslitvinenk.kalahi.exception.GameConcludedException;
import com.alekslitvinenk.kalahi.model.GameState;
import com.alekslitvinenk.kalahi.model.PlayerRole;
import com.alekslitvinenk.kalahi.model.PlayerState;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class PlayerRoleServiceTest {

    private PlayerRoleService service = new PlayerRoleService();
    private int gameId = 1;

    @Test
    public void returnsPlayerAWhenNoPlayersAssignedToGame() {
        GameState gameState = new GameState(gameId);
        PlayerRole playerRole = service.getPlayerRoleFromGameState(gameState);
        Assert.assertEquals(PlayerRole.PlayerA, playerRole);
    }

    @Test
    public void returnsPlayerBWhenPlayerAAssignedToGame() {
        GameState gameState = new GameState(gameId);
        gameState.setPlayerA(new PlayerState());
        PlayerRole playerRole = service.getPlayerRoleFromGameState(gameState);
        Assert.assertEquals(PlayerRole.PlayerB, playerRole);
    }

    @Test(expected = GameConcludedException.class)
    public void throwsGameConcludedExceptionWhenBothPlayersAssignedToGame() {
        GameState gameState = new GameState(gameId);
        gameState.setPlayerA(new PlayerState());
        gameState.setPlayerB(new PlayerState());
        service.getPlayerRoleFromGameState(gameState);
    }
}
