package stepDefinitions;
import java.io.IOException;

import org.testng.Assert;

import com.todo.base.Base;
import com.todo.pages.HomePage;


import io.cucumber.java.BeforeStep;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TodoPositiveScenarioTest extends Base {

	HomePage todo;

	@BeforeStep
	public void setup() {
		todo = new HomePage();
	}

	@Given("I am on the TodoMVC application")
	public void i_am_on_the_TodoMVC_application() throws IOException {
		launch();
	}

	@When("I enter {string} in the todo input field")
	public void i_enter_in_the_todo_input_field(String string) {

		todo.enterTodoList(string);

	}

	@When("I press enter key")
	public void i_press_enter_key() {

		todo.pressEnterKey();
	}

	@Then("I should see {string} in the todo list")
	public void i_should_see_in_the_todo_list(String string) {

		Assert.assertEquals(todo.verifyTodoList(string), string);
	}

	@When("I click on the checkbox of {string}")
	public void i_click_on_the_checkbox_of(String string) {

		todo.clickOnCheckbox(string);

	}

	@Then("It should be marked as completed")
	public void it_should_be_marked_as_completed() {

		Assert.assertEquals(todo.verifyCompleted(), "completed");
	}

	@When("I click the delete button of {string}")
	public void i_click_the_delete_button_of(String string) {

		todo.clickOnCrossButton(string);
	}

	@Then("I should not see Completed button")
	public void i_should_not_see_Completed_button() {

		Assert.assertFalse(todo.verifyCompleteButton());

	}

	@When("I click on Completed button")
	public void i_click_on_Completed_buttonn() {

		todo.clickOnCompleteButton();
	}

	@Then("close the browser")
	public void close_the_browser() {
		driver.quit();

	}
}
