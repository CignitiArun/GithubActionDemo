Feature: Demo Calc with Multiply example
 
@MultiplyServiceExample @smoke
  Scenario: Verify multiply service with JSON file
    Given I Multiply 2 and 4
    Then Multiply service should return me 8