FROM ubuntu:18.04
RUN apt-get update -y
RUN apt-get install -y ca-certificates-java
RUN apt-get install -y openjdk-17-jdk openjdk-17-jre
RUN apt-get update -y && apt-get upgrade -y
CMD ["echo", "hello"]