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
        if (playerRole == PlayerRole.PlayerA) {
            int rocks = playerA.distributeRocksFromPit(pitId);
            while (rocks > 0) {
                rocks = playerB.distributeRocks(rocks, false);
                if (rocks > 0) {
                    rocks = playerA.distributeRocks(rocks, true);
                }
            }
        } else if (playerRole == PlayerRole.PlayerB) {
            int rocks = playerB.distributeRocksFromPit(pitId);
            while (rocks > 0) {
                rocks = playerA.distributeRocks(rocks, false);
                if (rocks > 0) {
                    rocks = playerB.distributeRocks(rocks, true);
                }
            }
        }
    }
}
