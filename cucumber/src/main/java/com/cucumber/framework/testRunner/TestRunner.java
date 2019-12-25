package com.cucumber.framework.testRunner;


import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;


@CucumberOptions(features="src/test/resources/features",glue= {"com/cucumber.framework.cucumber.stepdefinitions"},
plugin={"pretty","html:target/cucumber-jvm-reports","json:target/cucumber.json"},
monochrome=true,
strict=true,
dryRun=false,
tags= {"@smoke,@regression,@login","~@MapUI","~@ECMS"}
)

public class TestRunner {

	private TestNGCucumberRunner Runner;
	
	@BeforeClass(alwaysRun=true)
	public void setUpClass() {
		Runner = new TestNGCucumberRunner(this.getClass());
		
	}
	
	@Test(groups="cucumber",description="Runs Cucumber Features",dataProvider="features")
	public void feature(CucumberFeatureWrapper cucumberFeature) {
		Runner.runCucumber(cucumberFeature.getCucumberFeature());
		
	}
	
	@DataProvider()
	public Object[][] features(){
		return Runner.provideFeatures();
		
	}
	
	@AfterClass(alwaysRun=true)
	public void tearDownClass() {
		Runner.finish();
	}
}

