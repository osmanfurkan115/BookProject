FROM openjdk:8 AS build

COPY pom.xml mvnw ./
COPY .mvn .mvn
RUN ./mvnw dependency:resolve

COPY src src
RUN ./mvnw package

FROM openjdk:8
WORKDIR book-project
COPY --from=build target/*.jar book-project.jar
ENTRYPOINT ["java", "-jar", "book-project.jar"]