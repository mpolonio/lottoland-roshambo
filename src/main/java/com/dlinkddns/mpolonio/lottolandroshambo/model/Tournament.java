package com.dlinkddns.mpolonio.lottolandroshambo.model;

import com.dlinkddns.mpolonio.lottolandroshambo.service.GameService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Tournament implements CommandLineRunner {

    @Value("${lottoland.roshambo.tournament.plays.number}")
    private int playsNumber;

    private GameService gameService;

    @Autowired
    public Tournament(GameService gameService) {
        this.gameService = gameService;
    }

    @Override
    public void run(String... args) throws Exception {
        Player randomPlayer = Player.RANDOM_PLAYER;
        Player stubbornRockPlayer = Player.STUBBORN_ROCK_PLAYER;

        this.play(randomPlayer, stubbornRockPlayer);
    }

    public void play(Player firstPlayer, Player secondPlayer) {


        for(int i=0; i<playsNumber; i++){
            gameService.game(firstPlayer.nextMove(), secondPlayer.nextMove());
        }


    }

}


