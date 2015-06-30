FROM java:8
MAINTAINER gongchengdong <gongchengdong@news.com>

ADD target/demo-spring-boot-1.0-SNAPSHOT.jar app.jar

# Need file modification time
RUN bash -c 'touch /app.jar'

# Http port
EXPOSE 8080

ENTRYPOINT ["java","-jar","/app.jar"]