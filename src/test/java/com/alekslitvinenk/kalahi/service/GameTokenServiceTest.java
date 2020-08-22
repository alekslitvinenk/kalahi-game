package com.alekslitvinenk.kalahi.service;

import com.alekslitvinenk.kalahi.model.GameTokenParams;
import com.alekslitvinenk.kalahi.model.PlayerRole;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GameTokenServiceTest {

    @Autowired
    private GameTokenService service;

    private final int gameId = 1;
    private final PlayerRole playerRole = PlayerRole.PlayerA;

    @Test
    public void serializeAndDeserializeToken() {
        String token = service.getTokenForGameIdAndPlayerRole(gameId, playerRole);
        GameTokenParams gameTokenParams = service.getGameParamsFromToken(token);

        Assert.assertEquals(gameId, gameTokenParams.getGameId());
        Assert.assertEquals(playerRole, gameTokenParams.getPlayerRole());
    }
}
