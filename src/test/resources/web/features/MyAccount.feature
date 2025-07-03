@MyAccount    @Regression
Feature:My Account

  Background:
    Given The client is on my account page with email 'usuario@gmail.com' and password 'usuario1234'


  @SuccessfulAccountDetailsView  @Smoke
  Scenario: Successful account details view
    When The client clicks on 'My account' link
    And The client clicks on 'Account details' link
    Then The account details are shown

  @SuccessfulLogOut  @Smoke
  Scenario: Successful log out
    When The client clicks on 'Log out' link
    Then The client comes out from the site

