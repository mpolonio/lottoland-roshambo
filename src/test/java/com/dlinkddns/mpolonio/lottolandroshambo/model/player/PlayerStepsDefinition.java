package com.dlinkddns.mpolonio.lottolandroshambo.model.player;

import com.dlinkddns.mpolonio.lottolandroshambo.model.Move;
import com.dlinkddns.mpolonio.lottolandroshambo.model.RandomPlayer;
import com.dlinkddns.mpolonio.lottolandroshambo.model.RockPlayer;
import com.dlinkddns.mpolonio.lottolandroshambo.service.StrategyService;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.verify;

@SpringBootTest
public class PlayerStepsDefinition {

    @SpyBean
    @Autowired
    private StrategyService strategyService;

    @Autowired
    private RandomPlayer randomPlayer;

    @Autowired
    private RockPlayer rockPlayer;

    @Given("First player is of {word} type")
    public void playerIsRandomPlayer(String className) {
        assertThat(randomPlayer.getClass().getSimpleName()).isEqualTo(className);
    }

    @Given("Second player is of {word} type")
    public void playerIsRockPlayer(String className) {
        assertThat(rockPlayer.getClass().getSimpleName()).isEqualTo(className);
    }

    @When("Player makes a new move")
    public void playerMakesNewMove(){
        randomPlayer.nextMove();
    }

    @Then("It invokes randomizer")
    public void invokesRandomizer() {
        verify(strategyService, atLeast(1)).randomNextMove();
    }

    @Then("It returns a {word} move")
    public void returnsRockMove(final String move) {
        Move requiredMove = Move.valueOf(move);
        assertThat(rockPlayer.nextMove()).isEqualTo(requiredMove);
    }
}
