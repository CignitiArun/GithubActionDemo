Feature: Demo Calc with example
 
@smoke
  Scenario: Verify add service with JSON file
    Given I get the data from file "ExampleDivide.json" from 0 for divison
    Then Divide service should return me 2
