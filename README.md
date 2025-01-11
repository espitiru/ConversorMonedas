# ConversorMonedas# Conversor de Monedas

Este proyecto es un conversor de monedas interactivo desarrollado en Java. Permite realizar conversiones entre varias monedas utilizando datos en tiempo real obtenidos de la API [ExchangeRate-API](https://www.exchangerate-api.com/).

## Características
- Interfaz de texto simple y fácil de usar.
- Conversión entre:
  - Dólar Americano (USD) y Peso Argentino (ARS).
  - Dólar Americano (USD) y Real Brasileño (BRL).
  - Dólar Americano (USD) y Peso Colombiano (COP).
  - Y conversiones inversas.
- Tasas de cambio obtenidas en tiempo real.
- Modularidad para cálculos y manejo de API.

## Requisitos

- **Java JDK** 11 o superior.
- **IntelliJ IDEA** (o cualquier IDE de Java de tu preferencia).
- **Maven** para la gestión de dependencias.

## Dependencias

El proyecto utiliza la biblioteca Gson para manejar datos JSON. Asegúrate de incluir la siguiente dependencia en tu archivo `pom.xml`:

```xml
<dependency>
    <groupId>com.google.code.gson</groupId>
    <artifactId>gson</artifactId>
    <version>2.8.9</version>
</dependency>
```

## Instalación y Ejecución

1. Clona el repositorio:
   ```bash
   git clone https://github.com/tu-usuario/conversor-monedas.git
   ```

2. Abre el proyecto en tu IDE favorito (por ejemplo, IntelliJ IDEA).

3. Asegúrate de que el archivo principal se llame `ConversorMonedas.java` y esté ubicado en el paquete correcto.

4. Configura Maven para descargar las dependencias.

5. Ejecuta la clase `ConversorMonedas`.

## Uso

1. Al iniciar el programa, verás un menú con las opciones de conversión disponibles.
2. Ingresa el número correspondiente a la conversión deseada.
3. Introduce la cantidad que deseas convertir.
4. El programa mostrará el resultado de la conversión basado en las tasas de cambio actuales.

### Ejemplo

```
Sea bienvenido/a al conversor de moneda. Seleccione una opción:
1. Dólar Americano a Peso Argentino
2. Peso Argentino a Dólar Americano
3. Dólar Americano a Real Brasileño
4. Real Brasileño a Dólar Americano
5. Dólar Americano a Peso Colombiano
6. Peso Colombiano a Dólar Americano
7. Salir
Elija una opción válida: 1
Ingrese la cantidad a convertir: 100
100.00 USD equivalen a 9800.00 ARS
```

## API Utilizada

La API utilizada para obtener las tasas de cambio es [ExchangeRate-API](https://www.exchangerate-api.com/). El programa utiliza la siguiente URL base:
```
https://v6.exchangerate-api.com/v6/b99ac3e87811666efb8965f3/latest/USD
```



