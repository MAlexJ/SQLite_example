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
RUN mvn tomcat7:help
CMD ["mvn","tomcat7:run"]