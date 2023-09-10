package runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
	//features="src\\test\\sources\\features",
	features = "classpath:features",
	glue = "steps",
	tags = "@DbLoginScenario1 ",
	monochrome = true,
	dryRun = false,
	plugin= {
		"pretty",
		"html:target/reports/cucumber.html",
		"json:target/reports/cucumber.json",
	}
	
		)
public class LoginRunner {

}
