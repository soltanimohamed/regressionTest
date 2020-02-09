FROM ubuntu:latest

Run \
# Update
apt-get update -y && \
#Install Java
apt-get install default-jre -y

ADD ./target/petstore-0.0.1-SNAPSHOT.jar  mavenPetstore.jar

EXPOSE 8080

CMD java -jar petstore.jar
