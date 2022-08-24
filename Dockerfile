FROM maven:3.6.3 as maven-build
RUN mkdir /usr/src/app
WORKDIR /usr/src/app
COPY . /usr/src/app
RUN mvn package -DskipTests

FROM tomcat:8.5-alpine
# VOLUME /tmp
RUN /bin/rm -fR /usr/local/tomcat/webapps/*
RUN sed -i 's/8080/80/' /usr/local/tomcat/conf/server.xml
WORKDIR /usr/local/tomcat/webapps/
COPY --from=maven-build /usr/src/app/target/sesar-rest-api-1.0.0.war /usr/local/tomcat/webapps/api.war
RUN sh -c 'touch /usr/local/tomcat/webapps/api.war'
# Expose Ports. SESAR will run on 443. Any request to 80 will be redirect to 443
EXPOSE 443 80
ENV JAVA_OPTS="-XX:PermSize=4096m -XX:MaxPermSize=1024m"
ENTRYPOINT ["sh", "-c", "java -jar /usr/local/tomcat/webapps/api.war"]
