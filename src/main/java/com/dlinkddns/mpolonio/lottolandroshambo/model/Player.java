package com.dlinkddns.mpolonio.lottolandroshambo.model;

import com.dlinkddns.mpolonio.lottolandroshambo.service.StrategyService;

public abstract class Player {

    String name;

    StrategyService strategyService;

    public abstract Move nextMove();
    public String getName(){
        return this.name;
    }
}

