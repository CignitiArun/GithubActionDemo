Feature: Demo Calc with example

@AddServiceExample
  Scenario: Verify add service with JSON file
    Given I get the data from file "ExampleAdd.json" from 0
    Then ADD service should return me 6
    
@AddServiceExample
  Scenario: Verify add service with JSON file
    Given I get the data from file "ExampleAdd.json" from 0
    Then ADD service should return me 7
    
@AddServiceExample
  Scenario: Verify add service with JSON file
    Given I get the data from file "ExampleAdd.json" from 0
    Then ADD service should return me 0
    
@AddServiceExample
  Scenario: Verify add service with JSON file
    Given I get the data from file "ExampleAdd.json" from 0
    Then ADD service should return me 9