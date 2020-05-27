package com.dlinkddns.mpolonio.lottolandroshambo.model;

import java.util.Random;

public enum Move {
    ROCK {
        @Override
        public boolean beats(Move move) {
            return SCISSORS.equals(move);
        }
    },
    PAPER {
        @Override
        public boolean beats(Move move) {
            return ROCK.equals(move);
        }
    },
    SCISSORS {
        @Override
        public boolean beats(Move move) {
            return PAPER.equals(move);
        }
    };

    public abstract boolean beats(Move move);

    public static Move randomMove(){
        Random random = new Random();
        int randomInt = random.nextInt(Move.values().length);
        return Move.values()[randomInt];
    }
}

