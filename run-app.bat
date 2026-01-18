@echo off
echo ====================================
echo   Luxury Cars Catalog Application
echo ====================================
echo.

REM Configurar JAVA_HOME
set JAVA_HOME=%USERPROFILE%\java\jdk-21.0.1
set PATH=%JAVA_HOME%\bin;%PATH%

echo Java Home: %JAVA_HOME%
java -version
echo.

echo Iniciando aplicación...
echo.

cd /d "%~dp0"
call gradlew.bat run --no-configuration-cache

pause
