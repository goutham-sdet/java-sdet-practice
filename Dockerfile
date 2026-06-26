FROM maven:3.9.6-eclipse-temurin-17
WORKDIR /app
COPY . .
RUN mvn -B test -DsuiteXmlFile=testng.xml -Dtestnames="API"