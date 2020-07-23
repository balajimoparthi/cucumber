Feature: Login to Apolis application

  Background: user navigates to application URL
  Given i am on the Login page URL "http://172.16.40.64/apolis/#/login"
  Then i should see Login page



  @regression
  Scenario: Verification of Login
    When I enter username as "CO_WELFARE_SEC_BADRATHA_JSA"
    And I enter password as "CO_WELFARE_SEC_BADRATHA_JSA"
    And click on Login button
    Then I should see application homepage
    When I click on logout button
    Then I should be logged out

    Scenario Outline: Verification of Login with multiple logins
      When I enter username as "<usrName>"
      And I enter password as "<passWord>"
      And click on Login button
      Then I should see application homepage
      When I click on logout button
      Then I should be logged out
      Examples:
      |usrName|passWord|
      |CO_WELFARE_SEC_BADRATHA_JSA|CO_WELFARE_SEC_BADRATHA_JSA|
      |CO_WELFARE_SEC_BADRATHA_SS|CO_WELFARE_SEC_BADRATHA_SS|


    
      
