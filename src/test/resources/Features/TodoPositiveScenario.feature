Feature: TodoMVC Application Positive Scenario

  Scenario: Adding a new todo
    Given I am on the TodoMVC application
    When I enter "Running" in the todo input field
    And I press enter key
    Then I should see "Running" in the todo list
    And close the browser

  Scenario: Marking a todo as completed
    Given I am on the TodoMVC application
    When I enter "Running" in the todo input field
    And I press enter key
    Then I should see "Running" in the todo list
    When I click on the checkbox of "Running"
    Then It should be marked as completed
    And close the browser

  Scenario: Deleting a todo
    Given I am on the TodoMVC application
    When I enter "Running" in the todo input field
    And I press enter key
    Then I should see "Running" in the todo list
    When I click the delete button of "Running"
    Then I should not see Completed button
    And close the browser
    
  Scenario: Adding multiple todo list
    Given I am on the TodoMVC application
    When I enter "Running" in the todo input field
    And I press enter key
    Then I should see "Running" in the todo list
    When I enter "Cycling" in the todo input field
    And I press enter key
    Then I should see "Cycling" in the todo list
    When I enter "Swimming" in the todo input field
    And I press enter key
    Then I should see "Swimming" in the todo list
    And close the browser

  Scenario: Completed button functionality
    Given I am on the TodoMVC application
    When I enter "Jumping" in the todo input field
    And I press enter key
    Then I click on the checkbox of "Jumping"
    When I click on Completed button
    Then I should see "Jumping" in the todo list
    And close the browser