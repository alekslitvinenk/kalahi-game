package com.alekslitvinenk.kalahi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class InitGameDTO {
    private String gameSession;
    private PlayerRole playerRole;
}
