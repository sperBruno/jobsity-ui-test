Feature: Socialive Login

  Scenario: Login to Socialive page
    Given I navigate to Socialive Page
    When I insert "" in the user field
    And I insert "" in the password field
    And I click on the login button
    Then Socialive Dashboard is displayed