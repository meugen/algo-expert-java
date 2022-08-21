#!/bin/bash

./mvnw clean || exit 1
./mvnw test || exit 1
git push