Feature: Shop

  Scenario: Check speakers price
    Given I navigate to www.advantageonlineshopping.com
    When I select the tablets category
    And I add the first product to the cart
    And I navigate to the cart
    Then the total price is $1,009.00