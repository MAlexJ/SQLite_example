FROM sgrio/java-oracle
MAINTAINER Alex Maximov(alexmaximovj@gmail.com)
RUN apt-get update
RUN apt-get install -y maven
RUN apt-get install -y git
RUN mkdir -p /usr/local/sqlite
RUN cd /usr/local/sqlite
WORKDIR /usr/local/sqlite
RUN git clone https://github.com/MAlexJ/SQLite_example.git
WORKDIR /usr/local/sqlite/SQLite_example
RUN mvn clean install
RUN mvn flyway:migrate
RUN mvn dependency:get -DrepoUrl=http://download.java.net/maven/2/ -DgroupId=org.apache.tomcat.maven -DartifactId=tomcat7-maven-plugin -Dversion=2.2
CMD ["mvn","tomcat7:run"]
