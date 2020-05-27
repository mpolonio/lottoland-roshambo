package com.dlinkddns.mpolonio.lottolandroshambo.service;

import com.dlinkddns.mpolonio.lottolandroshambo.model.Move;
import org.springframework.stereotype.Service;

@Service
public class GameService {

    public void game(Move firstPlayerMove, Move secondPlayerMove) {
        if (firstPlayerMove == null || secondPlayerMove == null) {
            String msg = String
                    .format("Moves cannot be null (First Player move: %s, Second Player move: %s)!",
                            firstPlayerMove, secondPlayerMove);
            throw new IllegalArgumentException(msg);
        }
    }
}

