#Feature: Create Product
#
#  Scenario Outline: Successful created product
#    Given I am on the add product page
#    And I fill in the Product Name as <product>
#    And I fill in the Image as <arg0>
#    And I fill in the Price as <arg01>
#    And I fill in the Quantity as <arg02>
#    And I fill in the Des as <arg03>
#    And I fill in the id nsx as <arg04>
#    And I fill in the id kho as <arg05>
#    And I fill in the id cate as <arg06>
#    And I click on the Save button
#    Then I should see a message <message>
#    Examples:
#      | product | arg0   | arg01  | arg02 | arg03   | arg04 | arg05 | arg06 | message |
#      | "abc"   | "img"  | "1111" | "21"  | "des"   | "1"   | "1"   | "1"   | "Thêm product thàn công!"  |