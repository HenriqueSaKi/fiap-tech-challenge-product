FROM maven:3.9.8-eclipse-temurin-17-alpine AS build

WORKDIR /app

COPY . .

RUN mvn clean package -Dmaven.test.skip=true

FROM eclipse-temurin:17-jre-alpine

WORKDIR /app

COPY --from=build /app/target/ /app/target/

# Copiar o script de entrypoint
COPY entrypoint.sh /entrypoint.sh
RUN chmod +x /entrypoint.sh

ENTRYPOINT ["/entrypoint.sh"]

EXPOSE 8080/tcp
