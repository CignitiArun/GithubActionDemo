#!/bin/bash
count=0
while IFS=, read -r name code; do
  # do something...
  [[ "$code" == *","* ]] && echo "$name $code" && ((++count))
done < input.csv; \
echo ">> we found ${count} bad entries"
