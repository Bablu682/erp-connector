#!/bin/sh

cd api-gateway; ./gradlew clean build; cd ..
cd config-server; ./gradlew clean build; cd ..
cd asn-service; ./gradlew clean build; cd ..
cd bom-service; ./gradlew clean build; cd ..
cd web-portal; ./gradlew clean build; cd ..
cd eureka-server; ./gradlew clean build; cd ..
cd plm-subscriber; ./gradlew clean build; cd ..
