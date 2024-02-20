package stepDefination;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions
(features="./OHRM.feature",glue="logintest",publish = true,monochrome=true,
dryRun=true
  
)

public class TestRunner {

}
