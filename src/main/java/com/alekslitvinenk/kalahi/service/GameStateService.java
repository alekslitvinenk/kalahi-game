package com.alekslitvinenk.kalahi.service;

import com.alekslitvinenk.kalahi.dto.GameStateDTO;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicInteger;

@Service
public class GameStateService {

    private AtomicInteger gameIdSeqGenerator = new AtomicInteger(0);

    /*public GameStateDTO createNewGame() {

    }*/
}
