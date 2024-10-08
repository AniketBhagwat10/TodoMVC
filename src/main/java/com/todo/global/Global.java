package com.todo.global;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.todo.base.Base;

public class Global extends Base {

	public void click(WebDriver driver, WebElement ele) {

		Actions act = new Actions(driver);
		act.moveToElement(ele).click().build().perform();

	}

	public boolean elementVisible(WebDriver driver, WebElement ele) {
		boolean flag = false;
		try {
			ele.isDisplayed();
			flag = true;
		} catch (Exception e) {
			flag = false;
		} finally {
			if (flag) {
				System.out.println("Successfully Found element at");

			} else {
				System.out.println("Unable to locate element at");
			}
		}
		return flag;
	}

	public boolean type(WebElement ele, String text) {
		boolean flag = false;
		try {
			flag = ele.isDisplayed();
			ele.clear();
			ele.sendKeys(text);
			flag = true;
		} catch (Exception e) {
			System.out.println("Location Not found");
			flag = false;
		} finally {
			if (flag) {
				System.out.println("Successfully entered value");
			} else {
				System.out.println("Unable to enter value");
			}

		}
		return flag;
	}

	public boolean pressEnterKey(WebElement ele) {
		boolean flag = false;
		try {
			ele.sendKeys(Keys.ENTER);
			flag = true;
		} catch (Exception e) {
			System.out.println("Location Not found");
			flag = false;
		} finally {
			if (flag) {
				System.out.println("Successfull");
			} else {
				System.out.println("Unable to press enter key");
			}

		}
		return flag;
	}

	public String isDisplayed(WebDriver driver, WebElement ele) {
		boolean flag = false;
		String text;
		flag = elementVisible(driver, ele);
		if (flag) {
			flag = ele.isDisplayed();
			if (flag) {
				System.out.println("The element is Displayed");

			} else {
				System.out.println("The element is not Displayed");
			}
		} else {
			System.out.println("Not displayed ");
		}
		text = ele.getText();
		return text;
	}

	public void doubleClick(WebDriver driver, WebElement ele) {

		try {

			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].scrollIntoView(true);", ele);
			Actions actions = new Actions(driver);
			actions.moveToElement(ele).doubleClick().build().perform();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void mouseHover(WebDriver driver, WebElement ele) {

		try {

			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].scrollIntoView(true);", ele);
			Actions actions = new Actions(driver);
			actions.moveToElement(ele).build().perform();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
