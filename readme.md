~~~bash
mvn clean install
docker build -t test-poke .
docker run test-poke:latest
~~~