@Shop     @Regression
Feature:Shop

  Background:
    Given The client is on checkout page


  @SuccessfulOrderPlacement  @Smoke
  Scenario Outline: Successful order placement
    When The client sets: <firstName>, <lastName>, <emailAddress>, <phone>, <country>, <address>, <city>, <state>, <postcode>
    And The client selects 'Cash on Delivery' payment method
    And The client clicks on 'Place Order' button
    Then The order details are shown
    Examples:
      | firstName | lastName   | emailAddress      | phone | country   | address  | city           | state   | postcode |
      | User      | Automation | usuario@gmail.com | 12345 | Argentina | Street 1 | General Alvear | Mendoza | C5620    |

  @SuccessfulTaxFunctionality  @Smoke
  Scenario Outline: Successful tax functionality
    Then The tax amount should be correct for country <country> with rate <rate>

    @ResetBeforeEach
    Examples:
      | country   | rate |
      | India     | 2    |
      | Argentina | 5    |