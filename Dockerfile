FROM adoptopenjdk/openjdk11:alpine-jre
ARG JAR_FILE=target/CurrencyComporator-0.0.1-SNAPSHOT
WORKDIR /opt/app
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","app.jar"]