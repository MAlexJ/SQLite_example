 RUN Local
 docker build -t sqlite_image:latest .
 docker run -it -p 80:80 sqlite_image

RUN From GITHUB:
 docker build https://github.com/MAlexJ/SQLite_example.git#docker -t sqlite_image

 git push -u origin <branch>

 Documentation:
 https://docs.docker.com/engine/reference/commandline/build/