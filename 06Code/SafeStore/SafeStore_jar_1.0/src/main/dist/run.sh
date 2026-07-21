#!/bin/bash

RED='\033[0;31m'
GREEN='\033[0;32m'
NC='\033[0m'

echo "==========================================="
echo "  SAFESTORE - Disposable Products Management"
echo "  Developed by The Softwarriors"
echo "  Version 2.0"
echo "==========================================="
echo ""
echo "Iniciando aplicacion..."

java -jar SafeStore.jar

if [ $? -eq 0 ]; then
    echo ""
    echo "Aplicacion finalizada correctamente."
else
    echo ""
    echo -e "${RED}[ERROR] No se pudo iniciar la aplicacion.${NC}"
    echo "Asegurese de tener Java instalado."
    echo ""
    read -p "Presione Enter para continuar..."
fi
