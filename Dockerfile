# Étape de build : utiliser une image JDK 21 et installer Maven
FROM eclipse-temurin:21-jdk AS build

# Installer Maven (cette image est basée sur Debian)
RUN apt-get update && apt-get install -y maven

WORKDIR /app
# Copier le descriptor Maven et les sources
COPY pom.xml .
COPY src ./src

# Construire l'application sans exécuter les tests
RUN mvn clean package -DskipTests

# Étape d'exécution : utiliser l'image JRE 21 pour lancer l'application
FROM eclipse-temurin:21-jre
WORKDIR /app
# Copier le jar généré depuis l'étape de build
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
