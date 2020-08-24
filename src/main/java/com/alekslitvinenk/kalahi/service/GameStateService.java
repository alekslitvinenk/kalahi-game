package com.alekslitvinenk.kalahi.service;

import com.alekslitvinenk.kalahi.exception.WrongTurnException;
import com.alekslitvinenk.kalahi.model.GameState;
import com.alekslitvinenk.kalahi.exception.GameNotExistsException;
import com.alekslitvinenk.kalahi.exception.MaxNumberGamesExceededException;
import com.alekslitvinenk.kalahi.model.PlayerRole;
import com.alekslitvinenk.kalahi.model.PlayerState;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

@Service
public class GameStateService {

    private static final int MAX_CONCURRENT_GAMES = 5;

    private final AtomicInteger gameIdSeqGenerator = new AtomicInteger(0);
    private final Map<Integer, GameState> activeGames = new ConcurrentHashMap<>(MAX_CONCURRENT_GAMES);
    private final AtomicReference<GameState> lastCreatedGameRef = new AtomicReference<>();

    /**
     * Returns existing game if the player team has not been concluded yet and a new game otherwise
     * @return game
     */
    public GameState getNotConcludedOrCreateNewGame() {
        GameState lastCreatedGame = lastCreatedGameRef.get();
        if (lastCreatedGame != null && !lastCreatedGame.isTeamConcluded()) {
            Assert.isTrue(lastCreatedGame.hasPlayerA(), "PlayerA has to be assigned already");
            lastCreatedGame.setPlayerB(new PlayerState());
            return lastCreatedGame;
        } else if (activeGames.size() < MAX_CONCURRENT_GAMES) {
            int gameId = gameIdSeqGenerator.incrementAndGet();
            GameState gameState = new GameState(gameId);
            gameState.setPlayerA(new PlayerState());
            activeGames.putIfAbsent(gameId, gameState);
            lastCreatedGameRef.setPlain(gameState);
            return gameState;
        } else {
            throw new MaxNumberGamesExceededException();
        }
    }

    public GameState doGameStep(int gameId, PlayerRole playerRole, int pitId) {
        GameState gameState = activeGames.get(gameId);
        if (gameState != null) {
            Assert.isTrue(gameId == gameState.getGameId(), "game's gameId mismatch");
            if (gameState.getNextTurn() != playerRole) {
                throw new WrongTurnException();
            } else {
                gameState.moveRocks(playerRole, pitId);
            }
        } else {
            throw new GameNotExistsException();
        }

        return gameState;
    }

    public void finishGame(int gameId) {
        if (activeGames.containsKey(gameId)) {
            activeGames.remove(gameId);
        } else {
            throw new GameNotExistsException();
        }
    }
}
