package com.dlinkddns.mpolonio.lottolandroshambo.service;

import com.dlinkddns.mpolonio.lottolandroshambo.model.Game;
import com.dlinkddns.mpolonio.lottolandroshambo.model.Player;
import com.dlinkddns.mpolonio.lottolandroshambo.repository.GameRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class GameService {

    private GameRepository gameRepository;

    @Autowired
    public GameService(GameRepository gameRepository){
        this.gameRepository = gameRepository;
    }

    public void game(int gameId, Player firstPlayer, Player secondPlayer) {
        if (firstPlayer == null || secondPlayer == null) {
            String msg = String
                    .format("Players cannot be null (First Player: %s, Second Player: %s)!",
                            firstPlayer, secondPlayer);
            throw new IllegalArgumentException(msg);
        }

        Game game = new Game(gameId, firstPlayer, secondPlayer);
        gameRepository.save(game);

    }
}

