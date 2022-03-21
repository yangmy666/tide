FROM openjdk:11
ADD ./target/tide-system.jar ./
EXPOSE 8080
ENTRYPOINT ["java","-Dfile.encoding=UTF-8","-jar","tide-system.jar"]
