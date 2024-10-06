package Hooks;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.todo.base.Base;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class AppHook extends Base {

@Before
public void setUpScenario(Scenario scenario) {
message = scenario;
}

@After()
public void takeScreenshot(Scenario scenario) {

boolean f = scenario.isFailed();
System.out.println("failed" + f);

if (scenario.isFailed()) {

TakesScreenshot ts = (TakesScreenshot) driver;
byte[] screenshotAs = ts.getScreenshotAs(OutputType.BYTES);
scenario.attach(screenshotAs, "image/png", "Failed Screenshot");

}
/*
* else { TakesScreenshot ts = (TakesScreenshot)driver; byte[] screenshotAs =
* ts.getScreenshotAs(OutputType.BYTES); scenario.attach(screenshotAs,
* "image/png", "Passed Screenshot"); }
*/
}
}
