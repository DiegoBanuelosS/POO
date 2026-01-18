#!/bin/bash

echo "===================================="
echo "Building Luxury Cars Catalog App"
echo "===================================="
echo ""

echo "Step 1: Building React Application..."
cd app/src/main/www
npm install
if [ $? -ne 0 ]; then
    echo "Error: npm install failed"
    exit 1
fi

npm run build
if [ $? -ne 0 ]; then
    echo "Error: npm build failed"
    exit 1
fi

echo ""
echo "Step 2: Building Java Application..."
cd ../../../..
./gradlew build
if [ $? -ne 0 ]; then
    echo "Error: Gradle build failed"
    exit 1
fi

echo ""
echo "===================================="
echo "Build completed successfully!"
echo "===================================="
echo ""
echo "To run the application, execute:"
echo "  ./gradlew run"
echo ""
