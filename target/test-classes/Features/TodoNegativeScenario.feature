Feature: TodoMVC Application with Negative Scenario


Scenario: Adding a duplicate Todo
   Given I am on the TodoMVC application
   When I enter "Running" in the todo input field
   And I press enter key
   Then I should see "Running" in the todo list
   When I enter "Running" in the todo input field
   And I press enter key
   Then I should see "Running" in the todo list
   And close the browser
 
 
   
Scenario: Check todo input field with special character and number
  Given I am on the TodoMVC application
  When I enter "123!@#$%^" in the todo input field
  And I press enter key
  Then I should see "123!@#$%^" in the todo list
  And close the browser

 
Scenario: Check todo input field accpet any number of characters
  Given I am on the TodoMVC application
  When I enter "HelloWorldHelloWorldHelloWorldHelloWorldHelloWorldHelloWorldHelloWorldHelloWorldHelloWorld" in the todo input field
  And I press enter key
  Then I should see "HelloWorldHelloWorldHelloWorldHelloWorldHelloWorldHelloWorldHelloWorldHelloWorldHelloWorld" in the todo list
  And close the browser
   
 
 Scenario: Add an empty string
  Given I am on the TodoMVC application
  When I enter " " in the todo input field
  And I press enter key
  Then I should not see Completed button
  And close the browser