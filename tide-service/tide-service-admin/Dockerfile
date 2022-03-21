FROM openjdk:11
ADD ./target/tide-admin.jar ./
EXPOSE 2333
ENTRYPOINT ["java","-Dfile.encoding=gbk","-jar","tide-admin.jar"]
