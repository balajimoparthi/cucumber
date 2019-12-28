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
@TravelTracker
Feature: Sign in and verify maphome tab
  As an Traveller of the company
  I want to login to the application

  Background: user navigates to application URL
    Given i am on the Login page URL "https://mobileqa.internationalsos.com/Mobile/MapUI/Login.aspx?to=1"
    Then i should see Login page

  @regression @MapUI
  Scenario: Verification of MapHome tab in home page
    When I enter username as "ITG.AUT@internationalsos.com"
    And click on continue button
    And I enter password as "Tracker@654321"
    And click on Login button
    Then I should see application homepage
    When I click on logout button
    Then I should be logged out   
    
  @regression
  Scenario: Sign in with valid credentials
    When I enter username as "ITG.AUT@internationalsos.com"
    And click on continue button
    And I enter password as "Tracker@654321"
    And click on Login button
    When I click on logout button
    Then I should be logged out   
    
      