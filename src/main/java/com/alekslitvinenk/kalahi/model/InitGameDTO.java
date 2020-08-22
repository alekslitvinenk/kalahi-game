package com.alekslitvinenk.kalahi.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class InitGameDTO {
    private String gameToken;
    private PlayerRole playerRole;
    private GameState gameState;
}
