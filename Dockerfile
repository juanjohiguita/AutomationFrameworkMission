FROM maven:3.6.3-jdk-11 AS build
WORKDIR /app
COPY . .
RUN mvn clean test

# Instalar Allure
RUN apt-get update && apt-get install -y allure

# Copiar los resultados de Allure
RUN mvn allure:serve