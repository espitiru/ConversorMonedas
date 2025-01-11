import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class ConversorMonedas {

    // Método para obtener las tasas de conversión desde la API
    public static JsonObject obtenerTasasDeCambio() {
        String url = "https://v6.exchangerate-api.com/v6/b99ac3e87811666efb8965f3/latest/USD";
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() == 200) {
                JsonObject jsonResponse = JsonParser.parseString(response.body()).getAsJsonObject();
                return jsonResponse.getAsJsonObject("conversion_rates");
            } else {
                System.out.println("Error: No se pudo obtener las tasas de cambio.");
            }
        } catch (Exception e) {
            System.out.println("Error al conectar con la API: " + e.getMessage());
        }
        return null;
    }

    // Método para convertir una moneda a otra
    public static double convertirMoneda(double cantidad, double tasaOrigen, double tasaDestino) {
        return cantidad * (tasaDestino / tasaOrigen);
    }

    // Método principal con la interfaz textual
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        JsonObject tasas = obtenerTasasDeCambio();

        if (tasas == null) {
            System.out.println("No se pueden realizar conversiones debido a problemas con la API.");
            return;
        }

        while (true) {
            System.out.println("\nSea bienvenido/a al conversor de moneda. Seleccione una opción:");
            System.out.println("1. Dólar Americano a Peso Argentino");
            System.out.println("2. Peso Argentino a Dólar Americano");
            System.out.println("3. Dólar Americano a Real Brasileño");
            System.out.println("4. Real Brasileño a Dólar Americano");
            System.out.println("5. Dólar Americano a Peso Colombiano");
            System.out.println("6. Peso Colombiano a Dólar Americano");
            System.out.println("7. Salir");
            System.out.print("Elija una opción válida: ");

            int opcion = scanner.nextInt();
            if (opcion == 7) {
                System.out.println("Gracias por usar el conversor. ¡Hasta luego!");
                break;
            }

            System.out.print("Ingrese la cantidad a convertir: ");
            double cantidad = scanner.nextDouble();

            double resultado = 0;
            switch (opcion) {
                case 1:
                    resultado = convertirMoneda(cantidad, 1, tasas.get("ARS").getAsDouble());
                    System.out.printf("%.2f USD equivalen a %.2f ARS\n", cantidad, resultado);
                    break;
                case 2:
                    resultado = convertirMoneda(cantidad, tasas.get("ARS").getAsDouble(), 1);
                    System.out.printf("%.2f ARS equivalen a %.2f USD\n", cantidad, resultado);
                    break;
                case 3:
                    resultado = convertirMoneda(cantidad, 1, tasas.get("BRL").getAsDouble());
                    System.out.printf("%.2f USD equivalen a %.2f BRL\n", cantidad, resultado);
                    break;
                case 4:
                    resultado = convertirMoneda(cantidad, tasas.get("BRL").getAsDouble(), 1);
                    System.out.printf("%.2f BRL equivalen a %.2f USD\n", cantidad, resultado);
                    break;
                case 5:
                    resultado = convertirMoneda(cantidad, 1, tasas.get("COP").getAsDouble());
                    System.out.printf("%.2f USD equivalen a %.2f COP\n", cantidad, resultado);
                    break;
                case 6:
                    resultado = convertirMoneda(cantidad, tasas.get("COP").getAsDouble(), 1);
                    System.out.printf("%.2f COP equivalen a %.2f USD\n", cantidad, resultado);
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }

        scanner.close();
    }
}
