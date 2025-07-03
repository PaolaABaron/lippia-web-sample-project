@Login     @Regression
Feature:Login in Automation Practice web

  Background:
    Given The client is on my account page

  @FailedLogin
  Scenario Outline: Failed login - case sensitive handling
    When The client logs in with email <email> and password <pass>
    Then The message <error> is shown
    Examples:
      | email             | pass        | error                                                                                                |
      | USUARIO@gmail.com | USUARIO1234 | Error: The password you entered for the username USUARIO@gmail.com is incorrect. Lost your password? |

  @LogoutRemainsAfterBack     @Smoke
  Scenario Outline: Logout remains after back
    When The client logs in with registered email <email> and password <pass>
    And The client clicks on 'Sign out' link
    And The client navigates back
    Then The client is on login page
    Examples:
      | email             | pass        |
      | usuario@gmail.com | usuario1234 |









