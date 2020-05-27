package com.dlinkddns.mpolonio.lottolandroshambo.model;

import com.dlinkddns.mpolonio.lottolandroshambo.service.GameService;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.Mockito.*;

@Slf4j
@SpringBootTest
public class TournamentStepsDefinition {

    @Autowired
    @MockBean
    private GameService gameService;


    @Given("Tournament has been played")
    public void tournamentHasBeenPlayer() throws Exception {
        Tournament tournament = new Tournament(gameService);
    }

    @Then("There has to be exactly {int} played games")
    public void the_bag_should_contain_only_something(final int playsNumber) {
        verify(gameService,times(playsNumber))
                .game(any(Move.class),any(Move.class));
    }

}

