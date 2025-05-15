@MyAccount    @Regression
Feature:My Account

  Background:
    Given The client is on my account page with email 'usuario@gmail.com' and password 'usuario1234'

  @SuccessfulOrdersView  @Smoke   @Automated
  Scenario: Successful orders view
    When The client clicks on 'Orders' link
    Then The orders are shown

  @SuccessfulOrdersDetailsView  @Smoke   @Automated
  Scenario: Successful orders details view
    When The client clicks on 'Orders' link
    And The client clicks on 'VIEW' button
    Then The orders details are shown

  @SuccessfulLogOut  @Smoke   @Automated
  Scenario: Successful log out
    When The client clicks on 'Log out' link
    Then The client comes out from the site

