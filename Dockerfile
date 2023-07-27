FROM ubuntu:latest

WORKDIR /app

RUN apt-get update -y && \
    apt-get install -y openjdk-17-jdk && \
    apt-get install -y curl

COPY . .

RUN ./gradlew build --stacktrace

EXPOSE 8080

CMD ["java", "-jar", "build/libs/post-microsservice-0.0.1-SNAPSHOT.jar"]