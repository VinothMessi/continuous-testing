# Build a JAR File
FROM maven:3.8.2-jdk-11-slim AS stage1

WORKDIR continuous-testing

# Copying src code
COPY src src
# Copying pom file
COPY pom.xml    pom.xml

RUN mvn dependency:go-offline -B
RUN mvn clean package -DskipTests

# Copying reources
COPY continuous-testing.xml continuous-testing.xml
COPY config config
COPY checkHub.sh checkHub.sh

# Create an Image
FROM openjdk:11-jre-slim

RUN apt-get update && apt-get install -y curl && apt-get install -y jq

WORKDIR continuous-testing

# Adding JARS files from target folder of host
COPY --from=stage1 continuous-testing/target/continuous-testing.jar continuous-testing.jar
COPY --from=stage1 continuous-testing/target/continuous-testing-tests.jar continuous-testing-tests.jar
COPY --from=stage1 continuous-testing/target/libs libs

# Copying reources
COPY pom.xml pom.xml
COPY continuous-testing.xml continuous-testing.xml
COPY config config
COPY checkHub.sh checkHub.sh

ENTRYPOINT sh checkHub.sh