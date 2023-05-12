#!/bin/bash
# Convert Excel file to CSV
input.csv
# Extract runner and tag information
while read line; do
  runner=$(echo $line | cut -d',' -f1)
  tags=$(echo $line | cut -d',' -f2)
  
  # Run Cucumber tests for the runner and tags
  mvn test -Dcucumber.filter.tags="$tags" -Drunner="$runner"
done < input.csv
