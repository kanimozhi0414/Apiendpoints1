package org.cucumberstepdef;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

	@RunWith(Cucumber.class)
	@CucumberOptions(features="src\\test\\resources\\ApiFeature\\ApiTest.feature",
	glue = "org.cucumberstepdef",
	monochrome = true)

	
	public class CucumberRunnerClass
	{
		
	}
