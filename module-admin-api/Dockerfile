FROM openjdk:17
ARG JAR_FILE=/module-admin-api/build/libs/module-admin-api.jar
COPY ${JAR_FILE} app.jar
ENV TZ=Asia/Seoul
ENTRYPOINT ["java","-jar","/app.jar"]