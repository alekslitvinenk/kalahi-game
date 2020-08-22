package com.alekslitvinenk.kalahi.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class PlayerDTO {
    List<Integer> pits;
    Integer store;
}
