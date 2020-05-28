package com.dlinkddns.mpolonio.lottolandroshambo.service;

import com.dlinkddns.mpolonio.lottolandroshambo.model.Game;
import com.dlinkddns.mpolonio.lottolandroshambo.model.GameResult;
import com.dlinkddns.mpolonio.lottolandroshambo.repository.GameRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.StreamSupport;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

@Service
@Slf4j
public class StatsService {

    private GameRepository gameRepository;

    @Autowired
    public StatsService(GameRepository gameRepository){
        this.gameRepository = gameRepository;
    }

    public Map<GameResult,Long> tournamentStats(){

        Iterable<Game> games = gameRepository.findAll();
        return StreamSupport.stream(games.spliterator(), false)
                .map(Game::<GameResult>getGameResult)
                .collect(groupingBy(Function.identity(), counting()));
    }
}