@HomePage    @Regression
Feature:Home Page

  Background:
    Given The client is on home page

  @SuccessfulHomePageWithThreeSliders      @Smoke      @Automated
  Scenario: Successful home page with three sliders
    Then Only three sliders are shown

  @SuccessfulHomePageWithThreeArrivals      @Smoke     @Automated
  Scenario: Successful home page with three arrivals
    Then Only three arrivals are shown

  @SuccessfulArrivalsReviews     @Smoke      @Automated
  Scenario Outline: Successful arrivals reviews
    When The client clicks on '<product>' image
    And The client clicks on 'Reviews' button
    Then The review for the product is shown
    Examples:
      | product    |
      | Selenium   |
      | HTML       |
      | JavaScript |











