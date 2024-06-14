# Dockerfile
FROM openjdk:21-rc-oraclelinux8
VOLUME /tmp
COPY build/libs/kotlin-springboot-starter.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
