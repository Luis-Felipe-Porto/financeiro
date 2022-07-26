FROM openjdk

WORKDIR /app
COPY target/financeiro-0.0.1.jar financeiro.jar

ENTRYPOINT ["java", "-jar", "financeiro.jar"]