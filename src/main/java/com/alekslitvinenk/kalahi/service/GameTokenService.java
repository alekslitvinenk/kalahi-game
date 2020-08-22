package com.alekslitvinenk.kalahi.service;

import com.alekslitvinenk.kalahi.model.GameTokenParams;
import com.alekslitvinenk.kalahi.model.PlayerRole;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.token.KeyBasedPersistenceTokenService;
import org.springframework.security.core.token.Token;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.security.SecureRandom;

@Service
public class GameTokenService {

    @Value("${serverSecret}")
    private String serverSecret;
    @Value("${serverInteger}")
    private Integer serverInteger;

    private final KeyBasedPersistenceTokenService tokenService = new KeyBasedPersistenceTokenService();

    @PostConstruct
    private void init() {
        tokenService.setServerSecret(serverSecret);
        tokenService.setServerInteger(serverInteger);
        tokenService.setSecureRandom(new SecureRandom());
        tokenService.afterPropertiesSet();
    }

    public String getTokenForGameIdAndPlayerRole(int gameId, PlayerRole playerRole) {
        String extendedInfo = gameId + ";" + playerRole.name();
        Token gameToken = tokenService.allocateToken(extendedInfo);
        return gameToken.getKey();
    }

    public GameTokenParams getGameParamsFromToken(String token) {
        Token gameToken = tokenService.verifyToken(token);
        return GameTokenParams.fromTokenExtendedInfo(gameToken.getExtendedInformation());
    }
}
