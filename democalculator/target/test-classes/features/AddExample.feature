Feature: Demo Calc with example

@AddServiceExample @smoke
  Scenario Outline: Verify add service with JSON file
    Given I get the data from file "<ExampleAdd.json>" from 0 for addition
    Then ADD service should return me 6
    Examples:
    |File_name|
    |ExampleAdd.json|