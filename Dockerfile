FROM openjdk:11.0-jdk

WORKDIR /usr/share/continuous-testing

#Adding JAR files and libs folder
ADD target/continuous-testing.jar           continuous-testing.jar
ADD target/continuous-testing-tests.jar     continuous-testing-tests.jar
ADD target/libs                             libs

#Adding suite files
ADD continuous-testing.xml                  continuous-testing.xml

ENTRYPOINT java -cp continuous-testing.jar:continuous-testing-tests.jar:libs/* -Dspring.profiles.active=$PROFILE -Dbrowser=$BROWSER -Dhub.host=$HOST -Dhub.port=$PORT org.testng.TestNG $MODULE