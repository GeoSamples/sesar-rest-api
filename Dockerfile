From tomcat:8.5-alpine
VOLUME /tmp
COPY target/sesar-rest-api-0.0.2.war /usr/local/tomcat/webapps/api.war
RUN sh -c 'touch /usr/local/tomcat/webapps/api.war'
# Expose Ports. SESAR will run on 443. Any request to 80 will be redirect to 443
EXPOSE 443 8080
ENTRYPOINT ["sh", "-c", "java -jar /usr/local/tomcat/webapps/api.war"]