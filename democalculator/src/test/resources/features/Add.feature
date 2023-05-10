Feature: Demo Calc
  @AddService
Scenario: Verify add service
  Given I add 2 and 3
  Then ADD service should return me 5
  