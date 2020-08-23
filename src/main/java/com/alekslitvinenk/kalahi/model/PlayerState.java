package com.alekslitvinenk.kalahi.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class PlayerState {
    private int[] pits = new int[]{6, 6, 6, 6, 6, 6};
    private int store = 0;

    public int getRocksInPit(int pitId) {
        return pits[pitId];
    }

    public int distributeRocksFromPit(int pitId) {
        int rocks = pits[pitId];
        pits[pitId] = 0;

        for (int i = pitId + 1; i < pits.length - 1; i++) {
            if (rocks-- > 0) {
                pits[i]++;
            } else {
                break;
            }
        }

        if (rocks > 0) {
            rocks--;
            store++;
        }

        return rocks;
    }

    public int distributeRocks(int rocks, boolean useStore) {
        for (int i = 0; i < pits.length - 1; i++) {
            if (rocks-- > 0) {
                pits[i]++;
            } else {
                break;
            }
        }

        if (useStore && rocks > 0) {
            rocks--;
            store++;
        }

        return rocks;
    }
}
