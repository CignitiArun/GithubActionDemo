Feature: Demo Calc with division example
 
@DivideServiceExample @smoke
  Scenario: Verify division service with JSON file
  	Given I divide 4 and 2
    Then Divide service should return me 2
