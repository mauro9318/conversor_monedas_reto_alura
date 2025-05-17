---
El proyecto conversor de monedas es un proyecto para profundizar el conocimiento del lenguaje de programacion Java y el paradigma de la PROGRAMACION ORIENTADA A OBJETOS.
El presente proyecto hace uso de los pilares de la POO para poder desarrollar un solucion que puede ser escalable y de facil mantenimiento. Esto con el uso de las clases para distintas tareas que el programa requiere.
---

## Cómo usar

1. Clona el repositorio.
2. Asegúrate de tener Java 17 instalado.
3. Añade la librería JSON a tu proyecto (puedes descargarla de [https://mvnrepository.com/artifact/org.json/json](https://mvnrepository.com/artifact/org.json/json)).
4. Ejecuta la clase `principal.Principal` para iniciar la aplicación.
5. Sigue las instrucciones de la interfaz para realizar conversiones de monedas.

---
# Estructura del Proyecto

El proyecto está organizado en paquetes para facilitar la mantenibilidad y escalabilidad:

src/
│

├── principal/

│ └── Principal.java # Clase principal que ejecuta el programa
│

└── modelos/

├── InterfazConversor.java # Maneja el menú principal y la selección de opciones

├── ConversorMonedas.java # Lógica de conversión y manejo de la interfaz para monedas

├── ApiDivisas.java # Clase encargada de la conexión y consulta a la API Exchange Rate

└── CalculadoraCambio.java # (Opcional) Clase para cálculos adicionales relacionados con cambios

---
## Nota

Recuerda que para que la aplicación funcione correctamente, debes tener conexión a Internet y en caso de que la API utilizada requiera una **API Key**, asegurarte de configurarla adecuadamente en la clase `ApiDivisas`.

---

## Autor

Desarrollado por Angelo Mauricio Flores Soria.

---

¡Gracias por usar este conversor de divisas en Java!
