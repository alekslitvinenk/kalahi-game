package com.alekslitvinenk.kalahi.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class GameStateDTO {
    private PlayerDTO playerA;
    private PlayerDTO playerB;
}
