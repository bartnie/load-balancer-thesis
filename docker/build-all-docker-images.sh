#!/usr/bin/env bash
cd ../eureka
./gradlew docker
echo $'\n'EUREKA SERVER DOCKER IMAGE BUILT$'\n'

cd ../master
./gradlew docker
echo $'\n'MASTER SERVICE DOCKER IMAGE BUILT$'\n'

cd ../worker
./gradlew docker
echo $'\n'WORKER SERVICE DOCKER IMAGE BUILT$'\n'
