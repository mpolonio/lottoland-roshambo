package com.dlinkddns.mpolonio.lottolandroshambo.model.tournament;

import com.dlinkddns.mpolonio.lottolandroshambo.model.Player;
import com.dlinkddns.mpolonio.lottolandroshambo.model.RandomPlayer;
import com.dlinkddns.mpolonio.lottolandroshambo.model.RockPlayer;
import com.dlinkddns.mpolonio.lottolandroshambo.model.Tournament;
import com.dlinkddns.mpolonio.lottolandroshambo.service.GameService;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.Mockito.*;

@SpringBootTest
public class TournamentStepsDefinition {

    @Autowired
    @MockBean
    private GameService gameService;

    @Autowired
    private RandomPlayer randomPlayer;

    @Autowired
    private RockPlayer rockPlayer;


    @Given("Tournament has been played")
    public void tournamentHasBeenPlayer() throws Exception {
        Tournament tournament = new Tournament(gameService,randomPlayer,rockPlayer);
    }

    @Then("There has to be exactly {int} played games")
    public void the_bag_should_contain_only_something(final int playsNumber) {
        verify(gameService,times(playsNumber))
                .game(any(Player.class),any(Player.class));
    }

}

