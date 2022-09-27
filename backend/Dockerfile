FROM gradle:7.1-jdk16 as build
COPY . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle clean build -x test --no-daemon

FROM openjdk:16-alpine
EXPOSE 8080
COPY --from=build /home/gradle/src/build/libs/*.jar application.jar
RUN java -jar application.jar