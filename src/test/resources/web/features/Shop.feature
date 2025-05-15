@Shop     @Regression
Feature:Shop

  Background:
    Given The client is on shop page

  @SuccessfulFilterByProductCategories  @Smoke  @Automated
  Scenario Outline: Successful filter by product categories
    When The client clicks on '<category>'
    Then The product '<product>' is shown
    Examples:
      | category   | product    |
      | Android    | Android    |
      | HTML       | HTML       |
      | JavaScript | JavaScript |
      | selenium   | selenium   |

  @SuccessfulSorting  @Smoke  @Automated
  Scenario Outline: Successful sorting
    When The client clicks on '<filter>' option
    Then The filtered '<products>' are shown
    Examples:
      | filter                     | products    |
      | Sort by popularity         | popular     |
      | Sort by average rating     | rating      |
      | Sort by newness            | new         |
      | Sort by price: low to high | low to high |
      | Sort by price: high to low | high to low |
# NOTE: The tests for examples 4 and 5 (sorting by price: low to high / high to low) are currently failing
# because the product prices on the site are not displayed in ascending or descending order as expected.
# This may be due to incorrect sorting behavior on the site or inconsistent price formatting.
