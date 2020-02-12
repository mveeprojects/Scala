Feature: Should get a sensible response from URLs

#  Scenario: Calling base URL should result in Hello World being returned
#    Given I call the '/' endpoint locally
#    Then I should receive a status code of '200'

  @wip
  Scenario: Should add two positive numbers
    Given my calculator is running
    When I add 1 and 2
    Then result should be equal to 3
  @wip
  Scenario: Should subtract two positive numbers
    Given my calculator is running
    When I subtract 3 and 1
    Then result should be equal to 2