#!/bin/bash
# Encontrar o arquivo .jar
JAR_FILE=$(ls target/product*.jar | head -n 1)

# Verificar se o arquivo existe
if [ -z "$JAR_FILE" ]; then
  echo "Erro: Nenhum arquivo .jar encontrado em target/."
  exit 1
fi

# Executar o comando
exec java -jar "$JAR_FILE"
