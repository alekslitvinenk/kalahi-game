FROM openjdk:11.0-jre
COPY ./target /usr/src/myapp
COPY ./static /usr/src/myapp/static
WORKDIR /usr/src/myapp
ENTRYPOINT [ "java", "-jar", "kalahi-0.0.1-SNAPSHOT.jar" ]
EXPOSE 8080/tcp
CMD [ "" ]