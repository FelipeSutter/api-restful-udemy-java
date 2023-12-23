# diz primeiro qual o build que será gerada
FROM ubuntu:latest AS build

# instala o jdk 17
RUN apt-get update
RUN apt-get install openjdk-17-jdk -y
# copia todo o conteúdo da aplicação e coloca no container
COPY . .

# instala o maven e roda o clean install para gerar o jdk da aplicação
RUN apt-get install maven -y
RUN mvn clean install

FROM openjdk:17-jdk-slim

# deixa exposto a porta 8080
EXPOSE 8080

# copia da build (nome dado lá em cima) o target onde está localizado o .jar da aplicação e coloca dentro de um arquivo
COPY --from=build primeiro-exemplo/target/primeiro-exemplo-0.0.1-SNAPSHOT.jar app.jar

# esses são os comandos que serão executados dentro do docker após os comandos anteriores
ENTRYPOINT [ "java", "-jar", "app.jar" ]


