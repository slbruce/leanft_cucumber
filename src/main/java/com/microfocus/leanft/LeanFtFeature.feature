#Auto generated Octane revision tag
@TID2178REV0.2.0
Feature: Shop

  Scenario: Check speakers price
    Given I navigate to www.advantageonlineshopping.com
    When I select the speakers category
    And I add the first product to the cart
    And I navigate to the cart
    Then the total price is $269.99