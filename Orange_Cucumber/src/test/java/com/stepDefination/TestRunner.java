package com.stepDefination;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions
(features="./OrangeHRMApplication/OrangeHRM.feature", glue="com.stepDefination", 
  monochrome=true  
  //dryRun=true
  )


public class TestRunner {

}
