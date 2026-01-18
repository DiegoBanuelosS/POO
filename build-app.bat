@echo off
echo ====================================
echo Building Luxury Cars Catalog App
echo ====================================
echo.

echo Step 1: Building React Application...
cd app\src\main\www
call npm install
if errorlevel 1 (
    echo Error: npm install failed
    pause
    exit /b 1
)

call npm run build
if errorlevel 1 (
    echo Error: npm build failed
    pause
    exit /b 1
)

echo.
echo Step 2: Building Java Application...
cd ..\..\..\..
call gradlew.bat build
if errorlevel 1 (
    echo Error: Gradle build failed
    pause
    exit /b 1
)

echo.
echo ====================================
echo Build completed successfully!
echo ====================================
echo.
echo To run the application, execute:
echo   gradlew.bat run
echo.
pause
