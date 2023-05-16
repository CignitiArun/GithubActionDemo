#!/bin/bash
while IFS="," read -r rec_column1 rec_column2
do
  echo "Displaying Record-$rec_column1"
  echo "Quantity: $rec_column2"
  mvn clean test verify -Dcucumber.options="--tags @$rec_column1" -Dglue=org.example.stepdefs -Dplugin=json:target/cucumber-reports/Cucumber.json -Ddataproviderthreadcount=3
done < <(tail -n +2 input.csv)
