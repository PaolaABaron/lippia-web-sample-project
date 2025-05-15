@Login     @Regression
Feature:Login in Automation Practice web

  Background:
    Given The client is on my account page

  @SuccessfulLogin      @Smoke    @Automated
  Scenario: Successful login
    When The client logs in with registered email 'usuario@gmail.com' and password 'usuario1234'
    Then The client is on the home page


  @FailedLogin    @Automated
  Scenario Outline: Failed login due to <cause>
    When The client logs in with email '<email>' and password '<pass>'
    Then The message '<error>' is shown
    Examples:
      | cause                                | email                      | pass         | error                                                                                                         |
      | incorrect email and password         | usuario2@gmail.com         | 1111         | Error: A user could not be found with this email address.                                                     |
      | correct email and empty password     | usuario.clockify@gmail.com |              | Error: Password is required.                                                                                  |
      | empty email and valid password       |                            | clockify1234 | Error: Username is required.                                                                                  |
      | empty email and password             |                            |              | Error: Username is required.                                                                                  |
      | correct email and incorrect password | usuario.clockify@gmail.com | 1111         | Error: The password you entered for the username usuario.clockify@gmail.com is incorrect. Lost your password? |






