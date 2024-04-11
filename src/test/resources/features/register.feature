#Feature: Registration
#
#  Scenario Outline: Successful User registration
#    Given I am on the registration page
#    When I fill in the form First Name as <firstName>
#    And I fill in the form Last Name as <lastName>
#    And I fill in the form Username as <username>
#    And I fill in the form Email as <email>
#    And I fill in the form Password as <password>
#    And I click on the Register button
#    Then I should be redirected to the <url> after registration
#    Examples:
#      | firstName | lastName | username   | email                  | password    | url                           |
#      | "John"    | "Doe"    | "john_doe" | "john.doe@example.com" | "password"  | "http://localhost:4000/login" |
#
#  Scenario Outline: Failed User registration
#    Given I am on the registration page
#    When I fill in the form First Name as <firstName>
#    And I fill in the form Last Name as <lastName>
#    And I fill in the form Username as <username>
#    And I fill in the form Email as <email>
#    And I fill in the form Password as <password>
#    And I click on the Register button
#    Then I see the error message <errorMessage> after registration
#    Examples:
#      | firstName | lastName | username   | email                  | password    | errorMessage                           |
#      | "John"    | "Doe"    | "john_doe" | "john.doe@example.com" | "password"  | "Đăng ký thất bại...!" |