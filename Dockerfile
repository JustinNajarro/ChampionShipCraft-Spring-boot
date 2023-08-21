FROM amazoncorretto:17-alpine-jdk
MAINTAINER JustinNajarro
COPY target/edu.idat.pe-1.0.0.jar championship.jar
ENTRYPOINT [ "java","-jar","/championship.jar" ]