package com.dlinkddns.mpolonio.lottolandroshambo.model;

import com.dlinkddns.mpolonio.lottolandroshambo.service.StrategyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RandomPlayer extends Player{

    @Autowired
    public RandomPlayer(StrategyService strategyService) {
        this.strategyService = strategyService;
    }

    @Override
    public Move nextMove() {
        return strategyService.randomNextMove();
    }
}
