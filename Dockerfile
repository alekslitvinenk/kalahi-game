FROM openjdk:11.0-jre
COPY . /usr/src/myapp
WORKDIR /usr/src/myapp
ENTRYPOINT [ "java", "-jar", "kalahi-0.0.1-SNAPSHOT.jar" ]
EXPOSE 8080/tcp
CMD [ "" ]