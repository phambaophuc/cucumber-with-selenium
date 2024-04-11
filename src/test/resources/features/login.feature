#Feature: Login
#
#  Scenario Outline: Successful Login attempt
#    Given I am on the login page
#    And I fill in the User Name as <userName>
#    And I fill in the Password as <password>
#    When I click on the Log In button
#    Then I should be redirected to the <url>
#    Examples:
#      | userName   | password    | url                      |
#      | "phucpham" | "Abcd@1234" | "http://localhost:4000/book" |
#
#  Scenario Outline: Failed login attempt
#    Given I am on the login page
#    And I fill in the User Name as <userName>
#    And I fill in the Password as <password>
#    When I click on the Log In button
#    Then I see the error message <errorMessage>
#    Examples:
#      | userName   | password    | errorMessage             |
#      | "phucpham" | "wrongpass" | "Tài khoản hoặc mặt khẩu sai!" |
