#!/bin/bash

echo "===================================="
echo "  Luxury Cars Catalog Application"
echo "===================================="
echo ""

# Configurar JAVA_HOME
export JAVA_HOME="$HOME/java/jdk-21.0.1"
export PATH="$JAVA_HOME/bin:$PATH"

echo "Java Home: $JAVA_HOME"
java -version
echo ""

echo "Iniciando aplicación..."
echo ""

cd "$(dirname "$0")"
./gradlew run --no-configuration-cache
