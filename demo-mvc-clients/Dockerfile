FROM openjdk:23  AS builder

RUN mkdir /project

COPY . /project

WORKDIR /project

RUN ./mvnw clean package

FROM openjdk:23

RUN mkdir /app

COPY --from=builder /project/target/demo-mvc-clients-0.0.1-SNAPSHOT.jar /app/demo-mvc-clients.jar

WORKDIR /app

CMD ["java", "-jar", "demo-mvc-clients.jar"]
