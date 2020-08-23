package com.alekslitvinenk.kalahi.service;

import com.alekslitvinenk.kalahi.exception.WrongGameStateException;
import com.alekslitvinenk.kalahi.model.GameState;
import com.alekslitvinenk.kalahi.model.PlayerRole;
import com.alekslitvinenk.kalahi.model.PlayerState;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class PlayerRoleServiceTest {

    private final PlayerRoleService service = new PlayerRoleService();
    private final int gameId = 1;

    @Test(expected = WrongGameStateException.class)
    public void throwsWrongGameStateExceptionWhenNoPlayersAssignedToGame() {
        GameState gameState = new GameState(gameId);
        PlayerRole playerRole = service.getPlayerRoleFromGameState(gameState);
        Assert.assertEquals(PlayerRole.PlayerA, playerRole);
    }

    @Test
    public void returnsPlayerAWhenPlayerAAssignedToGame() {
        GameState gameState = new GameState(gameId);
        gameState.setPlayerA(new PlayerState());
        PlayerRole playerRole = service.getPlayerRoleFromGameState(gameState);
        Assert.assertEquals(PlayerRole.PlayerA, playerRole);
    }

    @Test
    public void returnsPlayerBAWhenBothPlayersAssignedToGame() {
        GameState gameState = new GameState(gameId);
        gameState.setPlayerA(new PlayerState());
        gameState.setPlayerB(new PlayerState());
        PlayerRole playerRole = service.getPlayerRoleFromGameState(gameState);
        Assert.assertEquals(PlayerRole.PlayerB, playerRole);
    }
}
