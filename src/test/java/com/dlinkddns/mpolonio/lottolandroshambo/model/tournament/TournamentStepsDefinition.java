package com.dlinkddns.mpolonio.lottolandroshambo.model.tournament;

import com.dlinkddns.mpolonio.lottolandroshambo.model.*;
import com.dlinkddns.mpolonio.lottolandroshambo.service.GameService;
import com.dlinkddns.mpolonio.lottolandroshambo.service.StatsService;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

@SpringBootTest
public class TournamentStepsDefinition {

    @SpyBean
    @Autowired
    private GameService gameService;

    @SpyBean
    @Autowired
    private StatsService statsService;

    @Autowired
    private RandomPlayer randomPlayer;

    @Autowired
    private RockPlayer rockPlayer;


    @Given("Tournament has been played")
    public void tournamentHasBeenPlayer() throws Exception {
        Tournament tournament = new Tournament(gameService, statsService, randomPlayer, rockPlayer);
    }

    @Then("There has to be exactly {int} played games")
    public void accountForPlayedGames(final int playsNumber) {
        verify(gameService,times(playsNumber))
                .game(anyInt(),any(Player.class),any(Player.class));
    }

    @Then("Stats should contain {word} results")
    public void statsShouldContainNResults(final String keyName) {
        GameResult gameResult =GameResult.valueOf(keyName);
        assertThat(statsService.tournamentStats()).containsKey(gameResult);
    }

    @And("Result summation should be {int}")
    public void statsShouldContainOtherResults(final int totalGames) {
        assertTrue(statsService.tournamentStats().values()
                .stream().mapToLong(num -> num).sum()==totalGames);

    }

}

