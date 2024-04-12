Feature: Order
  Scenario: Order Product
    Given I on the login page
    And I will be logged in with "user" and "123"
    And I will go to the home page
    And I see the product detail
    And I click on the add to cart button
    And I wil go to cart page
    Then I see if the product is in the cart