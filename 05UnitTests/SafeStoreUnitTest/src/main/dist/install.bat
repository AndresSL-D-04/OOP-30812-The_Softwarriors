@echo off
title Instalador SafeStore v2.0
color 0A

echo ===========================================
echo   SAFESTORE - INSTALADOR
echo   Developed by The Softwarriors
echo   Version 2.0
echo ===========================================
echo.

mkdir "%ProgramFiles%\SafeStore" 2>nul
mkdir "%ProgramFiles%\SafeStore\lib" 2>nul

copy SafeStore.jar "%ProgramFiles%\SafeStore\"
copy lib\*.jar "%ProgramFiles%\SafeStore\lib\"

echo Set WshShell = CreateObject("WScript.Shell") > "%temp%\create_shortcut.vbs"
echo strDesktop = WshShell.SpecialFolders("Desktop") >> "%temp%\create_shortcut.vbs"
echo Set oShellLink = WshShell.CreateShortcut(strDesktop ^& "\SafeStore.lnk") >> "%temp%\create_shortcut.vbs"
echo oShellLink.TargetPath = "%ProgramFiles%\SafeStore\run.bat" >> "%temp%\create_shortcut.vbs"
echo oShellLink.WorkingDirectory = "%ProgramFiles%\SafeStore" >> "%temp%\create_shortcut.vbs"
echo oShellLink.Description = "SafeStore System" >> "%temp%\create_shortcut.vbs"
echo oShellLink.Save >> "%temp%\create_shortcut.vbs"
cscript "%temp%\create_shortcut.vbs"
del "%temp%\create_shortcut.vbs"

echo.
echo ===========================================
echo   INSTALACION COMPLETADA!
echo ===========================================
echo.
pause
