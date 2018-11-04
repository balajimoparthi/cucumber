#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@login
Feature: Sign in
  As an employee of the company
  I want to login to the application

  Background: user navigates to application URL
    Given i am on the Login page URL "http://localhost:8888/index.php?action=index&module=Home"
    Then i should see Login page

  @sanity
  Scenario: Sign in with valid credentials
    When I enter username as "admin"
    And I enter password as "password"
    And click on Login button
    Then I should see application homepage
    And I should see administrator text message on home page

  @sanity
  Scenario Outline: Title of your scenario outline
    When I enter username as "<userName>"
    And I enter password as "<passWord>"
    And click on Login button
    Then I should see application homepage
    And I should see administrator text message on home page

    Examples: 
      | userName | passWord |
      | admin    | password |
      | admin    | password |
