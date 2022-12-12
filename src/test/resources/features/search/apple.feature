Feature: Investopedia stock search feature

  @new
  Scenario: Pass the test if the price is below 150 USD, fail otherwise.
    Given I open the investopedia home page
    When I search for APPLE
    And I verify correct stock is loaded
    And I verify stock price doesn't breach the defined value
