package com.dlinkddns.mpolonio.lottolandroshambo.model.player;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features/model/player",
        plugin = {"pretty", "html:target/cucumber/model/"})
public class IntegrationTests {
}
