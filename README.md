# SQLite_example

*********************

Flyway

1. mvn clean install
2. mvn flyway:migrate
3. mvn flyway:info
4. mvn tomcat7:run

*********************
# Documentation

Path to th documentation: 
/documentation/swagger-ui.html

Note: Documentation is available only after authorization of the user

*********************
# MVN profiles

1. dev  : default
2. prod : mvn clean install -P prod

*********************
# Docker

 RUN Local
1. docker build -t sqlite_image:latest .
2. docker run -it -p 80:80 sqlite_image