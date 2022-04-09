FROM openjdk:11
ADD ./target/tide-service-system.jar ./
EXPOSE 80
ENTRYPOINT ["java","-Dfile.encoding=UTF-8","-jar","tide-service-system.jar"]
