package com.alekslitvinenk.kalahi.service;

import com.alekslitvinenk.kalahi.model.GameState;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class GameStateServiceTest {

    private GameStateService service;

    @Before
    public void setup() {
        service = new GameStateService();
    }

    @Test
    public void createsNewGame() {
        GameState gameState = service.getNotConcludedOrCreateNewGame();

        Assert.assertNotNull(gameState);
        Assert.assertNotNull(gameState.getPlayerA());
    }

    @Test
    public void returnsExistingGame() {
        GameState gameState1 = service.getNotConcludedOrCreateNewGame();
        GameState gameState2 = service.getNotConcludedOrCreateNewGame();

        Assert.assertEquals(gameState1, gameState2);
        Assert.assertNotNull(gameState2);
        Assert.assertNotNull(gameState2.getPlayerA());
        Assert.assertNotNull(gameState2.getPlayerB());
    }
}
