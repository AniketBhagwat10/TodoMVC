package com.todo.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.core.logging.Logger;
import io.cucumber.java.Scenario;

public class Base {

	public static WebDriver driver;
	public static Scenario message;

	public static void launch() throws IOException {

		String browser = "chrome";
		// Launching browser
		if (browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\anagh\\eclipse-workspace\\Todo\\Driver\\chromedriver.exe");

			ChromeOptions option = new ChromeOptions();
			option.addArguments("--remote-allow-origins=*");
			driver = new ChromeDriver(option);

		}
		driver.get("https://todomvc.com/examples/react/dist/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);

	}

	public static void takeScreenshot() {
		TakesScreenshot ts = (TakesScreenshot) driver;

		byte[] screenshotAs = ts.getScreenshotAs(OutputType.BYTES);
		message.attach(screenshotAs, "image/png", "Passed Screenshot");

	}
}
