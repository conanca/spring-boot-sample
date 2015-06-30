FROM java:8
MAINTAINER gongchengdong <gongchengdong@news.com>

ADD target/demo-spring-boot-1.0-SNAPSHOT.jar app.jar
RUN bash -c 'touch /app.jar'

ENTRYPOINT ["java","-jar","/app.jar"]