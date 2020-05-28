package com.dlinkddns.mpolonio.lottolandroshambo.service;

import com.dlinkddns.mpolonio.lottolandroshambo.model.Player;
import com.dlinkddns.mpolonio.lottolandroshambo.model.GameResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class GameService {

    public void game(Player firstPlayer, Player secondPlayer) {
        if (firstPlayer == null || secondPlayer == null) {
            String msg = String
                    .format("Players cannot be null (First Player: %s, Second Player: %s)!",
                            firstPlayer, secondPlayer);
            throw new IllegalArgumentException(msg);
        }

        GameResult gameResult = GameResult.DRAW;

        if (firstPlayer.nextMove().beats(secondPlayer.nextMove())) {
            gameResult = GameResult.FIRST_PLAYER;
        } else if (secondPlayer.nextMove().beats(firstPlayer.nextMove())){
            gameResult = GameResult.SECOND_PLAYER;
        }

        log.info("Game result: {}", gameResult);

    }
}

