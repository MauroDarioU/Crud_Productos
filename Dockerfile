 # imagen base
 FROM openjdk:17-jdk-slim

 # directorio de trabajo (contenedor)
 WORKDIR /app

 # archivo JAR al directorio de trabajo
 COPY target/ mi-aplicacion.jar app.jar

 # puerto de la aplicación
 EXPOSE 8080

 #  comando para ejecutar la aplicación
 CMD ["java", "-jar", "app.jar"]