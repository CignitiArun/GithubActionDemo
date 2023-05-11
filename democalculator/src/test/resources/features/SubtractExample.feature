Feature: Demo Calc with example

@smoke
  Scenario: Verify add service with JSON file
    Given I get the data from file "ExampleSubtract.json" from 0 for Subtraction
    Then Subtract service should return me 2
