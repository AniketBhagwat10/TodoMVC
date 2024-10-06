package testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//import org.junit.runner.RunWith;
//import io.cucumber.junit.Cucumber;
//import io.cucumber.junit.CucumberOptions;  


	import io.cucumber.testng.AbstractTestNGCucumberTests;
	import io.cucumber.testng.CucumberOptions;

	//import org.junit.runner.RunWith;
	//import io.cucumber.junit.Cucumber;
	//import io.cucumber.junit.CucumberOptions;  


	//@RunWith(Cucumber.class)
	@CucumberOptions(
	features={"src/test/resources/Features"},
	glue={"stepDefinitions","Hooks"},

	monochrome = true, //display the console output in a proper readable format
	//strict = true, //it will check if any step is not defined in step definition file
	dryRun = false,
	strict = true,
	plugin= {"pretty","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
	)//to check the mapping is proper between feature file and step def file
	public class TestRunner extends AbstractTestNGCucumberTests{

	}


