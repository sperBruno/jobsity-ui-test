Feature:
  This feature is going to test Women Dresses page

  Background:
    Given I navigate to Women Online Shop Page

  @smoke
  Scenario: Validate that Online Shop Page is displayed properly
    When I see the online shop logo
    Then Navigation bar is displayed
      And Search button is displayed
      And items panel is displayed
      And Cart Dropdown is displayed
      And User Info Bar is displayed

  @regression
  Scenario: Validate that user is able to filter Women Summer Dresses
    Given I navigate to Summer Dresses page
      And I filter "L" size
      And I filter "yellow" color
    When I sort by "Price: Lowest first" dropdown
    Then I verify that "Printed Chiffon Dress" is displayed with a price of "$16.40"
      And I verify that "Printed Summer Dress" is displayed with a price of "$28.98"

  @regression
  Scenario: Validate that add Element to cart is working properly
    Given I navigate to Summer Dresses page
    When I select "Printed Chiffon Dress" item
      And I click on add cart
      And I click on proceed to cart
    Then I see the "Printed Chiffon Dress" item on the cart list

  @regression
  Scenario: Validate that filtered Women Summer Dresses items are ordered in asscendant order
    Given I navigate to Summer Dresses page
      And I filter "L" size
      And I filter "yellow" color
    When I sort by "Price: Lowest first" dropdown
    Then I verify that "Printed Chiffon Dress" is displayed with a price of "$16.40"
      And I verify that "Printed Summer Dress" is displayed with a price of "$28.98"
      And I verify that listed items have asscendant ordering by price

  @CloseWomenShop
  Scenario: Validate that search option is working properly
    When I search "blouse" item
    Then I see the "blouse" word appears on the items list
