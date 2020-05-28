package com.dlinkddns.mpolonio.lottolandroshambo.model;

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
}

