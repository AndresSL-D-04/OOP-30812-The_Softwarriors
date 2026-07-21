@echo off
title Desinstalador SafeStore v2.0
color 0C

echo ===========================================
echo   SAFESTORE - DESINSTALADOR
echo ===========================================
echo.
echo ¿Esta seguro que desea desinstalar SafeStore?
echo.

choice /C SN /M "¿Desea continuar?"

if errorlevel 2 goto cancel
if errorlevel 1 goto uninstall

:uninstall
rmdir /s /q "%ProgramFiles%\SafeStore" 2>nul
del "%USERPROFILE%\Desktop\SafeStore.lnk" 2>nul
rmdir /s /q "%ProgramData%\Microsoft\Windows\Start Menu\Programs\SafeStore" 2>nul

echo.
echo ===========================================
echo   DESINSTALACION COMPLETADA!
echo ===========================================
echo.
pause
exit

:cancel
echo.
echo Desinstalacion cancelada.
pause
exit
