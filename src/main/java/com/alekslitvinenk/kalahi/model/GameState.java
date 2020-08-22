package com.alekslitvinenk.kalahi.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GameState {
    private int gameId;
    private PlayerState playerA;
    private PlayerState playerB;

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
}
