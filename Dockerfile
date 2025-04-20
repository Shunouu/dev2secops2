FROM openjdk:17-jdk-slim

WORKDIR /app

# Copier les fichiers du projet dans le conteneur
COPY . /app

# Installer Gradle et compiler le projet
RUN ./gradlew build

# Afficher le contenu du répertoire build/libs pour vérifier la présence du fichier .jar
RUN echo "Contenu du répertoire build/libs:" && ls -la build/libs/

# Exposer le port de l'application
EXPOSE 8081

# Exécuter l'application avec le bon fichier .jar
CMD ["java", "-jar", "build/libs/dev2secops2-0.0.1-SNAPSHOT.jar"]