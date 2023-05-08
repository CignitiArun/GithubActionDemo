$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/DivideExample.feature");
formatter.feature({
  "name": "Demo Calc with example",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Verify add service with JSON file",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@DivideServiceExample"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "I get the data from file \"ExampleDivide.json\" from 0 for divison",
  "keyword": "Given "
});
formatter.match({
  "location": "DivStepDef.theDataInFile(String,int)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Divide service should return me 2",
  "keyword": "Then "
});
formatter.match({
  "location": "AssertionStepDef.divServiceShouldReturnMe(int)"
});
formatter.result({
  "status": "passed"
});
});