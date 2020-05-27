package com.dlinkddns.mpolonio.lottolandroshambo.model;

public enum Player {
    RANDOM_PLAYER{
        @Override
        public Move nextMove() {
            return Move.randomMove();
        }
    },
    STUBBORN_ROCK_PLAYER{
        @Override
        public Move nextMove() { return Move.ROCK; }
    };

    public abstract Move nextMove();
}

