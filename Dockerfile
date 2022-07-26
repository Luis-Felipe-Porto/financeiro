FROM maven:3.8.3-openjdk-17

WORKDIR /app
RUN mvn install -DskipTests
COPY target/financeiro-0.0.1.jar financeiro.jar

ENTRYPOINT ["java", "-jar", "financeiro.jar"]