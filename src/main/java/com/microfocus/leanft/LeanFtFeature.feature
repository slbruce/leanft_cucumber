#Auto generated Octane revision tag
@TID2178REV0.2.0
Feature: Shop

  Scenario: Check tablets price
    Given I navigate to www.advantageonlineshopping.com
    When I select the tablets category
    And I add the first product to the cart
    And I navigate to the cart
    Then the total price is $1,009.00