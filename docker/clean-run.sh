#!/usr/bin/env bash
docker stop $(docker ps -a -q)
echo $'\n'ALL DOCKER CONTAINERS STOPPED$'\n'

docker rm $(docker ps -a -q)
echo $'\n'ALL DOCKER CONTAINERS REMOVED$'\n'

./build-all-docker-images.sh
echo $'\n'ALL DOCKER IMAGES PREPARED$'\n'

if [[ "$1" ]] && [[ "$1" -gt 0 ]]
then
        echo $'\n'STARTING DOCKER CONTAINERS WITH $1 WORKER SERVICES$'\n'
        docker-compose up --scale lb-worker-service=$1
else
        echo $'\n'STARTING DOCKER CONTAINERS WITH DEFAULT 2 WORKER SERVICES$'\n'
        docker-compose up --scale lb-worker-service=2
fi