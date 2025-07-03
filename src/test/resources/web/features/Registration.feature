@Registration    @Regression
Feature:Registration

  Background:
    Given The client is on my account page


  @FailedRegistration
  Scenario Outline: Failed registration due to <cause>
    When The client registers with email <email> and password <pass>
    Then The client sees the error <error>
    Examples:
      | cause                    | email              | pass                  | error                                        |
      | invalid email            | clockify@gmail     | Automation.testing123 | Error: Please provide a valid email address. |
      | empty email              |                    | Automation.testing123 | Error: Please provide a valid email address. |
      | empty password           | usuario1@gmail.com |                       | Error: Please enter an account password.     |
      | empty email and password |                    |                       | Error: Please provide a valid email address. |












