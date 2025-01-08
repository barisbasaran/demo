FROM openjdk:23  AS builder

RUN mkdir /project

COPY . /project

WORKDIR /project

RUN ./mvnw clean package

FROM openjdk:23

RUN mkdir /app

COPY --from=builder /project/target/demo-redis-0.0.1-SNAPSHOT.jar /app/demo-redis.jar

WORKDIR /app

CMD ["java", "-jar", "demo-redis.jar"]
