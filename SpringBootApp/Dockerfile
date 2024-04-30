FROM maven:3.9.6-amazoncorretto-21

WORKDIR /SpringBootApp
COPY . .
RUN mvn clean install

CMD mvn spring-boot:run