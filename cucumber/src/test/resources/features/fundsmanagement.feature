Feature: Verification of Funds Management Scenarios

  Background: user navigates to application URL
    Given I am on the Login page URL
    Then I should see Login page
    When I enter username as "CO_WELFARE_SEC_BADRATHA_JSA"
    And I enter password as "CO_WELFARE_SEC_BADRATHA_JSA"
    And I click on Login button
    Then I should see application homepage
   
  @smoke
 Scenario: Verify user is navigated to the Funds Management Page
   When I click on bhadratha section on homepage
   Then I should see funds management page

    @regression
    Scenario: Verify creation of funds
      When I click on bhadratha section on homepage
      Then I should see funds management page
      When I click on create new fund button
      Then I should see create new fund page
      When I enter "RC" number in to the RC number field
      And I enter "GO" number in to the GO number field
      And I enter "Fund" name in to the fund name field
      Then I should see the fund name
      When I enter AccountNumber number in to the account number field
      Then I should see the account number
      When I enter IFSC code
      And  I enter bank name
      Then I should see ifsc and bank name
      When I enter other details
      Then I should see other details
      When I enter head name
      #When I enter headers name
      #|EMI|principal|interest|
      And I click on add sub head button
      And I enter "principal" name
      And I click on add sub head button
      And I enter "interest" name
      And I click on create fund button
      And I should see fund created successfully popup
      And I click on ok button
      Then I should see the fund name in the funds management page

     @regression
      Scenario: Creation of transaction for the fund
        When I click on bhadratha section on homepage
        Then I should see funds management page
        When I click on create transaction link
        #Then I should see create transaction page
        When I select unit name
        And I select fund name
        And I select header name
        And I select sub header name
        And I enter "RC" number in to the RC number field
        And I select transaction type
        And I enter transaction amount
        And I enter cheque number
        And I choose date of transfer
        And I enter bank name
        And I enter other details
        #And I upload supporting documents
        And I click on create transaction button
        And I click yes on the popup window
        And I click no on add another transaction popup window
        Then I should see funds management page
        When I click on pending transactions for clearance
        Then I should see transactions for clearance page
        When I click on view details for the transaction created
        #Then I should see transaction popup window
        When I click on approve button
        And I click on okay button
        And I click on fund management from the breadcrumb
        And I should see funds management page
        And I click on the fund under the fund history
        Then I should see fund details
        And I should see transaction amount in the subheader

















 
