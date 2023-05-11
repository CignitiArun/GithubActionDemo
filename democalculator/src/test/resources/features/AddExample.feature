Feature: Demo Calc with example

@smoke
  Scenario: Verify add service with JSON file
    Given I get the data from file "ExampleAdd.json" from 0 for addition
    Then ADD service should return me 6
