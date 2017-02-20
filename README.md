
## 项目简介
spring boot 示例项目。主要实现了操作mongodb数据库，网页模板，装饰器布局，验证和鉴权，前端样式等。

## 组件
- Spring Boot
- Spring Security
- Spring Data Mongodb
- Fastjson
- Thymeleaf3
- Thymeleaf Layout Dialect
- Semantic UI

## 运行


- 本地编译运行：
 1. 启动redis
 ```
 docker run -d -p 6379:6379 redis:alpine redis-server --appendonly yes --requirepass test
 ```
 2. 启动mongodb
 ```
 docker run -d -p 27017:27017 -p 28017:28017 -e MONGODB_USER=user7 -e MONGODB_PASS=test -e MONGODB_DATABASE=spring-boot-sample tutum/mongodb
 ```
 3.编译运行
 ```
 mvn package
 java -jar target/spring-boot-sample-1.0-SNAPSHOT.jar
 ```

- docker compose方式运行：
  1. 按“本地编译运行”先编译jar包   
  2. 启动
```
docker-compose up -d
```

- rancher上部署运行
  1. 按“本地编译运行”先编译jar包  
  2. build docker镜像并push至镜像仓库
  ```
  docker build . -t "reg.news.cn/gongchengdong/spring-boot-sample:1.1"
  docker push reg.news.cn/gongchengdong/spring-boot-sample:1.1
  ```
  3. rancher上“添加应用栈”，“导入COMPOSE”时选择/rancher/目录下的配置文件