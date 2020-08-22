package com.alekslitvinenk.kalahi.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class GameTokenParams {
    private int gameId;
    private PlayerRole playerRole;

    public static GameTokenParams fromTokenExtendedInfo(String extendedInfo) {
        String[] components = extendedInfo.split(";");

        return new GameTokenParams(Integer.parseInt(components[0]), PlayerRole.valueOf(components[1]));
    }
}
