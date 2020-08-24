package com.alekslitvinenk.kalahi.model;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class PlayerStateTest {

    @Test
    public void distributesRocksCorrectlyFromPit0() {
        PlayerState playerState = new PlayerState();
        int rocksLeft = playerState.distributeRocksFromPit(0);
        int expectedRocksLeft = 0;
        int[] expectedPits = new int[]{0, 7, 7, 7, 7, 7};
        int expectedInStore = 1;
        int expectedPitIdWhereLastRockLanded = -1;

        Assert.assertEquals(expectedRocksLeft, rocksLeft);
        Assert.assertArrayEquals(expectedPits, playerState.getPits());
        Assert.assertEquals(expectedInStore, playerState.getStore());
        Assert.assertTrue(playerState.isRocksEndedInPlayerStore());
        Assert.assertEquals(expectedPitIdWhereLastRockLanded, playerState.getPitIdWhereLastPlayerRockLanded());
    }

    @Test
    public void distributesRocksCorrectlyFromPit1() {
        PlayerState playerState = new PlayerState();
        playerState.distributeRocksFromPit(0);
        int rocksLeft = playerState.distributeRocksFromPit(1);
        int expectedRocksLeft = 2;
        int[] expectedPits = new int[]{0, 0, 8, 8, 8, 8};
        int expectedInStore = 2;
        int expectedPitIdWhereLastRockLanded = -1;

        Assert.assertEquals(expectedRocksLeft, rocksLeft);
        Assert.assertArrayEquals(expectedPits, playerState.getPits());
        Assert.assertEquals(expectedInStore, playerState.getStore());
        Assert.assertFalse(playerState.isRocksEndedInPlayerStore());
        Assert.assertEquals(expectedPitIdWhereLastRockLanded, playerState.getPitIdWhereLastPlayerRockLanded());
    }

    @Test
    public void distributes2RocksCorrectly() {
        PlayerState playerState = new PlayerState();
        playerState.distributeRocksFromPit(0);
        playerState.distributeRocksFromPit(1);
        int rocksLeft = playerState.distributeRocks(2, true);
        int expectedRocksLeft = 0;
        int[] expectedPits = new int[]{1, 1, 8, 8, 8, 8};
        int expectedInStore = 2;
        int expectedPitIdWhereLastRockLanded = 1;

        Assert.assertEquals(expectedRocksLeft, rocksLeft);
        Assert.assertArrayEquals(expectedPits, playerState.getPits());
        Assert.assertEquals(expectedInStore, playerState.getStore());
        Assert.assertFalse(playerState.isRocksEndedInPlayerStore());
        Assert.assertEquals(expectedPitIdWhereLastRockLanded, playerState.getPitIdWhereLastPlayerRockLanded());
    }
}
