FROM adoptopenjdk/openjdk14:alpine
ADD ./target/demo-0.0.1-SNAPSHOT.jar /app/
CMD ["java", "-Xms200m", "-Xmx500m", "-jar", "/app/demo-0.0.1-SNAPSHOT.jar"]

EXPOSE 8080
