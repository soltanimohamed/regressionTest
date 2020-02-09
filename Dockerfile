FROM ubuntu:latest

Run \
# Update
apt-get update -y && \
#Install Java
apt-get install default-jre -y

ADD ./target/petstore-0.0.1-SNAPSHOT.jar  mavenpetstore.jar

EXPOSE 8080

CMD java -jar mavenpetstore.jar
