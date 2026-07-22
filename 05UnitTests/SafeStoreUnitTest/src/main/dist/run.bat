@echo off
title SafeStore System v2.0
color 0A

echo ===========================================
echo   SAFESTORE - Disposable Products Management
echo   Developed by The Softwarriors
echo   Version 2.0
echo ===========================================
echo.
echo Iniciando aplicacion...
echo.

java -jar SafeStore.jar

if errorlevel 1 (
    echo.
    echo [ERROR] No se pudo iniciar la aplicacion.
    echo Asegurese de tener Java instalado.
    echo.
    pause
) else (
    echo.
    echo Aplicacion finalizada.
    pause
)
