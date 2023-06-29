# Test Wikipedia - curso Automatizacion


En este curso se ven los siguientes temas
  - Maven
  - Java 18
  - Selenium
  - Data provider 
  - Page Object Model y Page Factory 
  - Eclipse

# Requisitos
  - Java 
  - Maven
  - Selenium
  - Testng

# Browser

Este proyecto es compatible con los navegadores Firefox , Chrome y Edge. 

# Ejecucion

Para ejecutar este repositorio, debes abrir una consola y navegar hasta el directorio del proyecto. 
Luego, ejecutalo con el comando Maven:

si utilizar eclipse antes de todo debes ejecutar "mvn eclipse:eclipse"
este comando lo que hace intalar variables de entorno para el correcto funcionamiento en eclipse

Luego puedes utilizar
mvn install -Dsuite=wiki_e 
mvn install -Dsuite=wiki_c   (por defecto chrome)
... y asi con los demas

Otra opcion es ejecutar un script que ejecuta todas las pruebas que hay en la carpeta TestSuite
"sh ejecucionPom.txt"
o
"./ejecucuinPom"




