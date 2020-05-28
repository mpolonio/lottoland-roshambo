package com.dlinkddns.mpolonio.lottolandroshambo.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
@NoArgsConstructor
public class Game {

    @Id
    private int id;
    private String firstPlayer;
    private String secondPlayer;
    private Move firstPlayerMove;
    private Move secondPlayerMove;
    private GameResult gameResult;

    public Game(int id, Player firstPlayer, Player secondPlayer){
        this.id = id;
        this.firstPlayer = firstPlayer.getName();
        this.secondPlayer = secondPlayer.getName();
        this.firstPlayerMove = firstPlayer.nextMove();
        this.secondPlayerMove = secondPlayer.nextMove();
        this.gameResult = gameSolver(this.firstPlayerMove,this.secondPlayerMove);
    }

    private GameResult gameSolver(Move firstPlayerMove, Move secondPlayerMove) {
        GameResult result = GameResult.DRAW;

        if (firstPlayerMove.beats(secondPlayerMove)) {
            result = GameResult.FIRST_PLAYER;
        } else if (secondPlayerMove.beats(firstPlayerMove)){
            result = GameResult.SECOND_PLAYER;
        }
        return result;
    }
}
