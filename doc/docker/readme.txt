 RUN Local
 docker build -t sqlite_image:latest .
 docker run -it -p 80:80 sqlite_image

RUN From GITHUB:
 docker build https://github.com/MAlexJ/SQLite_example.git#docker

 git push -u origin <branch>
