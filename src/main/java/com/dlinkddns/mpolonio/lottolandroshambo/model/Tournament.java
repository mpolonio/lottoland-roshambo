package com.dlinkddns.mpolonio.lottolandroshambo.model;

import com.dlinkddns.mpolonio.lottolandroshambo.service.GameService;
import com.dlinkddns.mpolonio.lottolandroshambo.service.StatsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.util.Map;


@Slf4j
@Component
public class Tournament implements CommandLineRunner {

    @Value("${lottoland.roshambo.tournament.plays.number}")
    private int playsNumber;

    private GameService gameService;
    private StatsService statsService;
    private RandomPlayer randomPlayer;
    private RockPlayer rockPlayer;

    @Autowired
    public Tournament(GameService gameService, StatsService statsService,
                      RandomPlayer randomPlayer, RockPlayer rockPlayer) {
        this.gameService = gameService;
        this.statsService = statsService;
        this.randomPlayer = randomPlayer;
        this.rockPlayer = rockPlayer;
    }

    @Override
    public void run(String... args) throws Exception {

        for(int i=0; i<playsNumber; i++){
            gameService.game(i, randomPlayer, rockPlayer);
        }

        Map<GameResult, Long> stats = statsService.tournamentStats();

        resultsReport(stats);
    }

    public void resultsReport(Map<GameResult, Long> stats){
        stats.entrySet().stream()
                .forEach(entry -> log.info(entry.getKey() + " games " + entry.getValue().toString()));
    }

}


