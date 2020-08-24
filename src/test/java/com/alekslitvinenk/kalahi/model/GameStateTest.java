package com.alekslitvinenk.kalahi.model;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class GameStateTest {

    private final int gameId = 1;

    @Test
    public void movesRocksCorrectlyForPlayerAPit1() {
        GameState gameState = new GameState(gameId);
        gameState.setPlayerA(new PlayerState());
        gameState.setPlayerB(new PlayerState());

        int[] expectedPlayerAPits = new int[]{0, 7, 7, 7, 7, 7};
        int expectedPlayerAStore = 1;

        int[] expectedPlayerBPits = new int[]{6, 6, 6, 6, 6, 6};
        int expectedPlayerBStore = 0;

        gameState.moveRocks(PlayerRole.PlayerA, 0);

        Assert.assertArrayEquals(expectedPlayerAPits, gameState.getPlayerA().getPits());
        Assert.assertEquals(expectedPlayerAStore, gameState.getPlayerA().getStore());
        Assert.assertArrayEquals(expectedPlayerBPits, gameState.getPlayerB().getPits());
        Assert.assertEquals(expectedPlayerBStore, gameState.getPlayerB().getStore());
    }

    @Test
    public void movesRocksCorrectlyForPlayerAPit2() {
        GameState gameState = new GameState(gameId);
        gameState.setPlayerA(new PlayerState());
        gameState.setPlayerB(new PlayerState());

        int[] expectedPlayerAPits = new int[]{0, 0, 8, 8, 8, 8};
        int expectedPlayerAStore = 2;

        int[] expectedPlayerBPits = new int[]{7, 7, 6, 6, 6, 6};
        int expectedPlayerBStore = 0;

        gameState.moveRocks(PlayerRole.PlayerA, 0);
        gameState.moveRocks(PlayerRole.PlayerA, 1);

        Assert.assertArrayEquals(expectedPlayerAPits, gameState.getPlayerA().getPits());
        Assert.assertEquals(expectedPlayerAStore, gameState.getPlayerA().getStore());
        Assert.assertArrayEquals(expectedPlayerBPits, gameState.getPlayerB().getPits());
        Assert.assertEquals(expectedPlayerBStore, gameState.getPlayerB().getStore());
    }

    @Test
    public void movesRocksCorrectlyForPlayerAPit3() {
        GameState gameState = new GameState(gameId);
        gameState.setPlayerA(new PlayerState());
        gameState.setPlayerB(new PlayerState());

        int[] expectedPlayerAPits = new int[]{0, 0, 0, 9, 9, 9};
        int expectedPlayerAStore = 3;

        int[] expectedPlayerBPits = new int[]{8, 8, 7, 7, 6, 6};
        int expectedPlayerBStore = 0;

        gameState.moveRocks(PlayerRole.PlayerA, 0);
        gameState.moveRocks(PlayerRole.PlayerA, 1);
        gameState.moveRocks(PlayerRole.PlayerA, 2);

        Assert.assertArrayEquals(expectedPlayerAPits, gameState.getPlayerA().getPits());
        Assert.assertEquals(expectedPlayerAStore, gameState.getPlayerA().getStore());
        Assert.assertArrayEquals(expectedPlayerBPits, gameState.getPlayerB().getPits());
        Assert.assertEquals(expectedPlayerBStore, gameState.getPlayerB().getStore());
    }

    @Test
    public void movesRocksCorrectlyForPlayerAPit6() {
        GameState gameState = new GameState(gameId);
        gameState.setPlayerA(new PlayerState());
        gameState.setPlayerB(new PlayerState());

        int[] expectedPlayerAPits = new int[]{1, 0, 0, 9, 9, 0};
        int expectedPlayerAStore = 12;

        int[] expectedPlayerBPits = new int[]{9, 9, 8, 8, 0, 7};
        int expectedPlayerBStore = 0;

        gameState.moveRocks(PlayerRole.PlayerA, 0);
        gameState.moveRocks(PlayerRole.PlayerA, 1);
        gameState.moveRocks(PlayerRole.PlayerA, 2);
        gameState.moveRocks(PlayerRole.PlayerA, 5);

        Assert.assertArrayEquals(expectedPlayerAPits, gameState.getPlayerA().getPits());
        Assert.assertEquals(expectedPlayerAStore, gameState.getPlayerA().getStore());
        Assert.assertArrayEquals(expectedPlayerBPits, gameState.getPlayerB().getPits());
        Assert.assertEquals(expectedPlayerBStore, gameState.getPlayerB().getStore());
    }
}
