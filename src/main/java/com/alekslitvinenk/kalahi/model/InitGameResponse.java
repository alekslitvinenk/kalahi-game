package com.alekslitvinenk.kalahi.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class InitGameResponse {
    private final String gameToken;
    private final PlayerRole playerRole;
    private final GameState gameState;
}
