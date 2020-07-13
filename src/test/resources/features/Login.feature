  @smoke
  Feature: Login functionality

  Background:
    Given I am on the login page

   @positive
   Scenario: A user with valid login credentials is able to log into and out of their account.
     When I login with valid credentials
     Then Dashboard page should be displayed
     And I log out
     Then Login page should be displayed


   @negative
   Scenario Outline: Invalid credentials combinations test
    When I fill in "username" with "<username>"
    And I fill in "password" with "<password>"
    And I click login button
    Then <errorName> error message should be displayed

    Examples:
      | username                            | password        | errorName                     |
      | invalidUsername                     | invalidPassword | UserName/Password Combination |
      |                                     | Interview11!    | username                      |
      | votervoice.qa.interviewee@gmail.com |                 | password                      |
      |                                     |                 | username/password             |

