FROM maven:3.9.9-eclipse-temurin-23-alpine  AS builder

RUN mkdir /project

COPY . /project

WORKDIR /project

RUN mvn clean package

FROM openjdk:23

RUN mkdir /app

COPY --from=builder /project/target/demo-jersey-0.0.1-SNAPSHOT.jar /app/demo-jersey.jar

WORKDIR /app

CMD ["java", "-jar", "demo-jersey.jar"]
