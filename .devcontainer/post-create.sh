#!/usr/bin/env bash

set -euo pipefail

echo "[PantryFit] Verificando ambiente de desenvolvimento..."
java -version
mvn -version
docker --version

echo ""
echo "[PantryFit] Ambiente pronto."
echo "Próximo passo sugerido: inicializar o projeto Spring Boot com Maven na raiz do repositório."
