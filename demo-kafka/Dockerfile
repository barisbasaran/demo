FROM openjdk:23  AS builder

RUN mkdir /project

COPY . /project

WORKDIR /project

RUN ./mvnw clean package

FROM openjdk:23

RUN mkdir /app

COPY --from=builder /project/target/demo-kafka-0.0.1-SNAPSHOT.jar /app/demo-kafka.jar

WORKDIR /app

CMD ["java", "-jar", "demo-kafka.jar"]
