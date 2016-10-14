FROM reg.news.cn/library/xh-baseimage-java:8
MAINTAINER gongchengdong <gongchengdong@news.cn>

ADD target/demo-spring-boot-1.0-SNAPSHOT.jar app.jar

# Http port
EXPOSE 8080

ENTRYPOINT ["java","-jar","/app.jar"]