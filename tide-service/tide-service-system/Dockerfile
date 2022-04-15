FROM openjdk:11
ADD ./target/tide-service-system.jar ./
ENV JAVA_OPTS="\
-server \
-Xmx500m \
-Xms128m \
-Dcom.sun.management.jmxremote=true \
-Dcom.sun.management.jmxremote.rmi.port=8890 \
-Dcom.sun.management.jmxremote.port=8890 \
-Dcom.sun.management.jmxremote.ssl=false \
-Dcom.sun.management.jmxremote.authenticate=false \
-Dcom.sun.management.jmxremote.local.only=false \
-Djava.rmi.server.hostname=47.94.147.204"
ENTRYPOINT java ${JAVA_OPTS} -Dfile.encoding=UTF-8 -jar tide-service-system.jar
RUN echo "Asia/Shanghai" > /etc/timezone;
