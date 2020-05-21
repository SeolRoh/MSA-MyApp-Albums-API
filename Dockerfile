FROM openjdk:8-jdk-alpine
VOLUME /tmp
COPY target/myapp-api-albums-0.0.1-SNAPSHOT.jar PhotoAppApiAlbums.jar
ENTRYPOINT ["java","-jar","PhotoAppApiAlbums.jar"]