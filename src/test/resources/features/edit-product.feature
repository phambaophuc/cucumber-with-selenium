#Feature: Edit product
#
#  Scenario Outline: Successful Edit product
#    Given I am on the product management page edit
#    And I click on the edit button
#    And I fill in the edit product Name as <arg0>
#    And I fill in the edit image as <arg01>
#    And I fill in the edit price as <arg02>
#    And I fill in the edit quantity as <arg03>
#    And I fill in the edit des as <arg04>
#    And I fill in the edit id nsx as <arg05>
#    And I fill in the edit id kho as <arg06>
#    And I fill in the edit id cate as <arg07>
#    And I click on the Save edit button
#    Then I should see a message <message> after edit
#    Examples:
#      | arg0      | arg01 | arg02    | arg03 | arg04 | arg05 | arg06 | arg07 | message           |
#      | "product" | "img" | "100000" | "10"  | "des" | "1"   | "1"   | "1"   | "Chỉnh sửa product thành công!" |