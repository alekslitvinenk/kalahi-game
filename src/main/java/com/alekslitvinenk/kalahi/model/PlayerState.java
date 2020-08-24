package com.alekslitvinenk.kalahi.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;

@Getter
@Setter
public class PlayerState {
    private static final int ROCKS_IN_PIT = 6;
    private static final int PITS = 6;
    private int[] pits = new int[PITS];
    private int store = 0;
    private boolean rocksEndedInPlayerStore = false;
    /**
     * Pit Id, where the last rock landed
     * -1 means, player rock did not land in any of his pits
     */
    private int pitIdWhereLastPlayerRockLanded = -1;

    public PlayerState() {
        Arrays.fill(pits, ROCKS_IN_PIT);
    }

    public int distributeRocksFromPit(int pitId) {
        rocksEndedInPlayerStore = false;
        pitIdWhereLastPlayerRockLanded = -1;

        int rocks = pits[pitId];
        pits[pitId] = 0;

        for (int i = pitId + 1; i < pits.length; i++) {
            if (rocks > 0) {
                rocks--;
                pits[i]++;

                if (rocks == 0 && pits[i] == 1) {
                    pitIdWhereLastPlayerRockLanded = i;
                }
            } else {
                break;
            }
        }

        if (rocks > 0) {
            rocks--;
            store++;

            if (rocks == 0) {
                rocksEndedInPlayerStore = true;
            }
        }

        return rocks;
    }

    public int distributeRocks(int rocks, boolean useStore) {
        if (useStore) {
            rocksEndedInPlayerStore = false;
            pitIdWhereLastPlayerRockLanded = -1;
        }

        for (int i = 0; i < pits.length; i++) {
            if (rocks > 0) {
                rocks--;
                pits[i]++;

                if (useStore && rocks == 0 && pits[i] == 1) {
                    pitIdWhereLastPlayerRockLanded = i;
                }
            } else {
                break;
            }
        }

        if (useStore && rocks > 0) {
            rocks--;
            store++;

            if (rocks == 0) {
                rocksEndedInPlayerStore = true;
            }
        }

        return rocks;
    }
}
