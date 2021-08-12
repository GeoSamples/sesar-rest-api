From tomcat:8.5-alpine
# VOLUME /tmp
RUN /bin/rm -fR /usr/local/tomcat/webapps/*
COPY target/sesar-rest-api-1.0.0.war /usr/local/tomcat/webapps/api.war
RUN sh -c 'touch /usr/local/tomcat/webapps/api.war'
# Expose Ports. SESAR will run on 443. Any request to 80 will be redirect to 443
EXPOSE 443 8080
ENV JAVA_OPTS="-XX:PermSize=4096m -XX:MaxPermSize=1024m"
ENTRYPOINT ["sh", "-c", "java -jar /usr/local/tomcat/webapps/api.war"]
