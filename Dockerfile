# Usar uma imagem oficial do OpenJDK
FROM openjdk:21-jdk-slim

# Definir o diretório de trabalho
WORKDIR /app

# Copiar o arquivo JAR para o container
# Substitua `target/sua-aplicacao.jar` pelo caminho real do seu arquivo
COPY target/testPoke-1.0-SNAPSHOT.jar app.jar

# Comando para executar a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]