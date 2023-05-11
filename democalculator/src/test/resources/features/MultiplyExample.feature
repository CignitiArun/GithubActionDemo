Feature: Demo Calc with example
 
@smoke
  Scenario: Verify add service with JSON file
    Given I get the data from file "ExampleMultiply.json" from 0 for Multiplication
    Then Multiply service should return me 8
