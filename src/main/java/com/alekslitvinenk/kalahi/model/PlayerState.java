package com.alekslitvinenk.kalahi.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class PlayerState {
    int[] pits = new int[]{6, 6, 6, 6, 6, 6};
    int store = 0;
}
