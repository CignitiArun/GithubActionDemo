#!/bin/bash
mvn clean test verify -Dcucumber.options="--tags @AddService,@SubtractServiceExample" -Dglue=org.example.stepdefs -Dplugin=json:target/cucumber-reports/Cucumber.json -Ddataproviderthreadcount=3 