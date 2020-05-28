package com.dlinkddns.mpolonio.lottolandroshambo.model;

import com.dlinkddns.mpolonio.lottolandroshambo.service.StrategyService;

public abstract class Player {

    StrategyService strategyService;

    public abstract Move nextMove();
}

