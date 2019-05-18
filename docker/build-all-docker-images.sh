cd eureka
./gradlew docker
echo 'EUREKA SERVER DOCKER IMAGE BUILT'

cd ../master
./gradlew docker
echo 'MASTER SERVICE DOCKER IMAGE BUILT'

cd ../worker
./gradlew docker
echo 'WORKER SERVICE DOCKER IMAGE BUILT'