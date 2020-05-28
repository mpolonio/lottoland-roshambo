package com.dlinkddns.mpolonio.lottolandroshambo.service;

import com.dlinkddns.mpolonio.lottolandroshambo.model.Move;
import com.dlinkddns.mpolonio.lottolandroshambo.util.EnumRandomizer;
import org.springframework.stereotype.Service;

@Service
public class StrategyService {

    public Move randomNextMove(){
        return EnumRandomizer.getEnumConstant(Move.class);
    }

    public Move rockMove(){
        return Move.ROCK;
    }

}
