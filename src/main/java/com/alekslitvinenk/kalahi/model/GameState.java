package com.alekslitvinenk.kalahi.model;

import lombok.Getter;
import lombok.Setter;

/**
 * Represents game per se as it's fully denoted by its state
 */
@Getter
@Setter
public class GameState {
    private int gameId;
    private PlayerState playerA;
    private PlayerState playerB;
    private PlayerRole nextTurn = PlayerRole.PlayerA;

    public GameState(int gameId) {
        this.gameId = gameId;
    }

    public boolean hasPlayerA() {
        return playerA != null;
    }

    public boolean hasPlayerB() {
        return playerB != null;
    }

    public boolean isTeamConcluded() {
        return  hasPlayerA() && hasPlayerB();
    }

    public void moveRocks(PlayerRole playerRole, int pitId) {
        PlayerState playerState = getPlayerStateByRole(playerRole);
        PlayerState enemyState = getEnemyStateByRole(playerRole);

        int rocks = playerState.distributeRocksFromPit(pitId);
        while (rocks > 0) {
            rocks = enemyState.distributeRocks(rocks, false);
            if (rocks > 0) {
                rocks = playerState.distributeRocks(rocks, true);
            }
        }

        if (playerState.getPitIdWhereLastPlayerRockLanded() != -1) {
            seizeRocksInEnemyPitsInFavourOf(playerRole, playerState.getPitIdWhereLastPlayerRockLanded());
        }

        if (!playerState.isRocksEndedInPlayerStore() && playerState.getPitIdWhereLastPlayerRockLanded() == -1) {
            setNextTurn(togglePlayer(playerRole));
        }
    }

    private void seizeRocksInEnemyPitsInFavourOf(PlayerRole playerRole, int pitId) {
        PlayerState playerState = getPlayerStateByRole(playerRole);
        PlayerState enemyState = getEnemyStateByRole(playerRole);

        int count = playerState.getPits()[pitId];
        playerState.getPits()[pitId] = 0;

        int enemyPitId = 5 - pitId;
        count += enemyState.getPits()[enemyPitId];
        enemyState.getPits()[enemyPitId] = 0;

        int playerStore = playerState.getStore() + count;
        playerState.setStore(playerStore);
    }

    private PlayerState getPlayerStateByRole(PlayerRole playerRole) {
        if (playerRole == PlayerRole.PlayerA) {
            return playerA;
        } else {
            return playerB;
        }
    }

    private PlayerState getEnemyStateByRole(PlayerRole playerRole) {
        if (playerRole == PlayerRole.PlayerA) {
            return playerB;
        } else {
            return playerA;
        }
    }

    private PlayerRole togglePlayer(PlayerRole playerRole) {
        if (playerRole == PlayerRole.PlayerA) {
            return PlayerRole.PlayerB;
        } else {
            return PlayerRole.PlayerA;
        }
    }
}
