FROM maven:3.5.0

MAINTAINER mxy

#相当于cd命令
WORKDIR /movieticket-back-end-xy

RUN echo '\
<settings>\n \
    <localRepository>/movieticket-back-end-xy/maven-repository</localRepository>\n \
</settings>' \
> /usr/share/maven/conf/settings.xml

# Cache dependencies
COPY ./pom.xml .
RUN mvn clean test tomcat7:shutdown -DskipTests=true

COPY . .

EXPOSE 8000
#设置container启动时执行的操作
CMD ["mvn", "clean", "tomcat7:run"]
