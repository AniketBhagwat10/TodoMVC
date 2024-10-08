package com.todo.pages;



import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.todo.base.Base;
import com.todo.global.Global;

public class HomePage extends Base {

	Global global = new Global();

	@FindBy(id = "todo-input")
	WebElement inputField;

	@FindBy(xpath = "//*[@id='root']/main/ul/li")
	WebElement attribute;

	@FindBy(xpath = "//*[text() = 'Completed']")
	WebElement completedButton;

public HomePage() {

PageFactory.initElements(driver, this);
}

	public void enterTodoList(String string) {

		global.type(inputField, string);
		takeScreenshot();
	}

	public void pressEnterKey() {
		global.pressEnterKey(inputField);
		takeScreenshot();

	}

	public String verifyTodoList(String text) {

		WebElement todoItem = driver.findElement(By.xpath("//label[text()='" + text + "']"));
		return global.isDisplayed(driver, todoItem);

	}

	public void clickOnCheckbox(String text) {

		WebElement checkbox = driver.findElement(By.xpath("//label[text()='" + text + "']/preceding-sibling::input"));
		global.click(driver, checkbox);
		takeScreenshot();

	}

	public String verifyCompleted() {

		return attribute.getAttribute("class");

	}

	public void clickOnCrossButton(String text) {

		WebElement deleteButton = driver
				.findElement(By.xpath("//label[text()='" + text + "']/following-sibling::button"));
		WebElement todoItem = driver.findElement(By.xpath("//label[text()='" + text + "']"));
		global.mouseHover(driver, todoItem);
		global.click(driver, deleteButton);
		takeScreenshot();
	}

	public boolean verifyCompleteButton() {

		return global.elementVisible(driver, completedButton);
	}

	public void clickOnCompleteButton() {

		global.click(driver, completedButton);
		takeScreenshot();

	}

}
