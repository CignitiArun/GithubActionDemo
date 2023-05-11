Feature: Demo Calc with example

@smoke
  Scenario: Verify add service with JSON file
    Given I get the data from file "ExampleAdd.json" from 0
    Then ADD service should return me 6
    
@smoke
  Scenario: Verify add service with JSON file
    Given I get the data from file "ExampleAdd.json" from 0
    Then ADD service should return me 7
    
@smoke
  Scenario: Verify add service with JSON file
    Given I get the data from file "ExampleAdd.json" from 0
    Then ADD service should return me 0
    
@smoke
  Scenario: Verify add service with JSON file
    Given I get the data from file "ExampleAdd.json" from 0
    Then ADD service should return me 9
