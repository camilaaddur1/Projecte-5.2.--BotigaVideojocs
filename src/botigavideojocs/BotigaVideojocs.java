/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package botigavideojocs;



/**
 *
 * @author batoi
 */
import java.util.Arrays;
import java.util.Scanner;
public class BotigaVideojocs {


    static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {
        seleccionaOpcion();
    }

    public static void Imprimir() {
        System.out.println("Bienvenido a la tienda de videojuegos. Elija una opción:");
        System.out.println("  1. Consultar catálogo de videojuegos");
        System.out.println("  2. Consultar stock de videojuegos");
        System.out.println("  3. Mostrar catálogo ordenado por stock");
        System.out.println("  4. Mostrar catálogo ordenado por precio");
        System.out.println("  5. Registrar venta de videojuego");
        System.out.println("  6. Registrar devolución de videojuegos");
        System.out.println("  7. Salir de la aplicación");
        System.out.print("\nIntroduce opción: ");
    }

    public static void seleccionaOpcion() {
        int opcion = 0;
        do {
            Imprimir();
            opcion = leerEntrada();
            opciones(opcion);
        } while (opcion != 7);

    }

    public static int leerEntrada() {
        do {
            int numero;
            if (teclado.hasNextInt()) {
                int numeroPositivo = teclado.nextInt();
                if (numeroPositivo > 0 && numeroPositivo < 8) {
                    numero = numeroPositivo;
                    return numero;
                } else {
                    System.out.print("\nerror \n\n");
                    Imprimir();
                }
            } else {
                System.out.print("\nerror \n\n");
                teclado.next();
                Imprimir();
            }
        } while (true);
    }

    public static void salirDelJuego() {
        System.out.println("Adiós");
    }

    public static String generarEnterAleatori() {
        int numeroAleatorio = (int) (Math.random() * (20 - 0 + 1)) + 0;
        return Integer.toString(numeroAleatorio);
    }

    public static String[][] matriz() {
        String[][] matriz = {
            {"1", "Super Mario Bros", "19.99", generarEnterAleatori()},
            {"2", "La leyenda de Zelda", "24.99", generarEnterAleatori()},
            {"3", "Sonic el erizo", "14.99", generarEnterAleatori()},
            {"4", "Tetris", "9.99", generarEnterAleatori()},
            {"5", "Pac-Man", "4.99", generarEnterAleatori()},
            {"6", "Street Fighter II", "29.99", generarEnterAleatori()},
            {"7", "Condenar", "39.99", generarEnterAleatori()},
            {"8", "Minecraft", "19.99", generarEnterAleatori()},
            {"9", "Los Sims", "34.99", generarEnterAleatori()},
            {"10", "Grand Theft Auto V", "49.99", generarEnterAleatori()},};
        return matriz;
    }

    public static void visualizarLineasDiscontinuas() {
        System.out.println("+---------+---------------------+--------+");
    }

    public static void visualizarCabecera(String[] cabecera) {
        visualizarLineasDiscontinuas();
        System.out.printf("| %8s| %20s| %7s|%n", cabecera[0], cabecera[1], cabecera[2]);
        visualizarLineasDiscontinuas();
    }

    public static void visualizarResultadoMatriz(String mensaje, String[][] sopaLetras, int indiceColumna, String[] cabecera) {
        System.out.println(mensaje);
        visualizarCabecera(cabecera);
        for (int i = 0; i < sopaLetras.length; i++) {
            visualizarResultadoFila(sopaLetras[i], indiceColumna);
        }
        visualizarLineasDiscontinuas();
    }

    public static void visualizarResultadoFila(String[] fila, int indiceColumna) {
        System.out.printf("| %8s| %20s| %7s|%n", fila[0], fila[1], fila[indiceColumna]);
    }

    public static void visualizarResultadoCelda(String sopaLetras) {
        System.out.print(sopaLetras + " ");
    }

    public static void visualizarOpcion2() {
        String[][] catalogo = matriz();
        String[] cabecera = new String[]{"Código", "Nombre", "Stock"};
        visualizarResultadoMatriz("Catálogo de videojuegos: ", catalogo, 3, cabecera);

    }

    public static String[][] copiarMatriz(String[][] original) {
        int filas = original.length;
        int columnas = original[0].length;
        String[][] copia = new String[filas][columnas];
        for (int i = 0; i < filas; i++) {
            copia[i] = Arrays.copyOf(original[i], columnas);
        }
        return copia;
    }

    public static void ordenarPorStock(String[][] matriz) {
        Arrays.sort(matriz, (a, b) -> Integer.compare(Integer.parseInt(a[3]), Integer.parseInt(b[3])));
    }

    public static void ordenarPorPrecio(String[][] matriz) {
        Arrays.sort(matriz, (a, b) -> Double.compare(Double.parseDouble(b[2]), Double.parseDouble(a[2])));
    }

    public static void visualizarCabeceraVenta() {
        visualizarGuiones();
        String codigo = "Código";
        String nombre = "Nombre";
        String unidades = "Unidades";

        System.out.printf("| %8s| %20s| %8s|%n", codigo, nombre, unidades);
        visualizarGuiones();
    }

    public static int leerOpcion5(String mensaje, int valor) {

        do {
            System.out.println(mensaje);
            int numero;
            if (teclado.hasNextInt()) {
                int numeroPositivo = teclado.nextInt();
                if (numeroPositivo > 0 && numeroPositivo < valor) {
                    return numeroPositivo;
                } else {
                    System.out.print("error\n ");
                    teclado.next();
                }
            } else {
                System.out.print("error\n");
                teclado.next();

            }
        } while (true);
    }

    public static String RealizarMasCompras(String mensaje) {
        System.out.println(mensaje);

        do {
            String opcion = teclado.next();
            if (opcion.equals("S") | opcion.equals("N")) {
                return opcion;
            } else {
                System.out.println("Error");
                System.out.println(mensaje);
            }
        } while (true);

    }

    public static double calcularTotalPagar(String[][] catalogo, String[][] listaVentas, int indiceVenta) {
        double totalPagar = 0;
        for (int i = 0; i < indiceVenta; i++) {
            int codigo = Integer.parseInt(listaVentas[i][1]);
            int cantidad = Integer.parseInt(listaVentas[i][2]);
            totalPagar += Double.parseDouble(catalogo[codigo - 1][2]) * cantidad;
        }
        return totalPagar;
    }

    public static void opcion5(String[][] matriz) {
        int codigoVenta = 1;
        String[][] ventasRealizadas = new String[1000][3];
        int indiceFila = 0;

        do {
            int codigoVideojuego = leerOpcion5("Introduzca el código del videojuego que desea comprar: ", 11);
            int cantidadVideoJuego = leerOpcion5("Introduzca la cantidad de unidades que desea comprar: ", 1000);
            String comprarMas = RealizarMasCompras("¿Desea comprar otro videojuego? (S/N):");

            int indiceFilaValor = buscarIndiceFilaValorEnColumna(matriz, 0, codigoVideojuego);
            int cantidadOriginalVideoJuego = (indiceFilaValor != -1) ? Integer.parseInt(matriz[indiceFilaValor][3]) : 0;

            if (indiceFilaValor != -1 && cantidadVideoJuego <= cantidadOriginalVideoJuego) {
                System.out.println("El videojuego existe y hay suficientes cantidades.");

                ventasRealizadas[indiceFila][0] = String.valueOf(codigoVenta);
                ventasRealizadas[indiceFila][1] = String.valueOf(codigoVideojuego);
                ventasRealizadas[indiceFila][2] = String.valueOf(cantidadVideoJuego);

                if (comprarMas.equals("N")) {
                    imprimirVenta(matriz, ventasRealizadas, codigoVenta, calcularTotalPagar(matriz, ventasRealizadas, indiceFila));
                    codigoVenta++;
                    break;
                }

                // Incrementa el índice de fila para la siguiente venta
                indiceFila++;
            } else {
                if (indiceFilaValor != -1) {
                    System.out.println("El videojuego existe pero no hay suficientes cantidades.");
                } else {
                    System.out.println("El videojuego no existe.");
                }
            }
        } while (true);
    }
    public static String obtenerNombreJuegoPorCodigo(int codigoBuscado, String[][] catalogo) {
        for (String[] juego : catalogo) {
            int codigo = Integer.parseInt(juego[0]);
            if (codigo == codigoBuscado) {
                return juego[1];
            }
        }
        return null;
    }
    public static void visualizarFilaVenta(int codigoVideojuego, String[][] catalogo, int cantidad) {
    String nombre = obtenerNombreJuegoPorCodigo(codigoVideojuego, catalogo);

    System.out.printf("| %8s| %20s| %8s|%n", codigoVideojuego, nombre, cantidad);
}
public static void visualizarGuiones() {
        System.out.println("+---------+---------------------+---------");
    }

    public static void imprimirVenta(String[][] catalogo, String[][] listaVentas, int siguienteCodigo, double totalPagar) {
        System.out.println("\nResumen de la venta (código " + siguienteCodigo + "):");

        visualizarCabeceraVenta();

        for (int i = 0; i < listaVentas.length; i++) {
            if (listaVentas[i][0] != null && Integer.parseInt(listaVentas[i][0]) == siguienteCodigo) {
                visualizarFilaVenta(Integer.parseInt(listaVentas[i][1]), catalogo, Integer.parseInt(listaVentas[i][2]));
            }
        }

        visualizarGuiones();
        System.out.printf("Total a pagar: %.2f €%n", totalPagar);
        System.out.println("\nGracias por su compra.");
    }

    public static int buscarIndiceFilaValorEnColumna(String[][] matriz, int columna, int valorBuscado) {

        for (int j = 0; j < matriz.length; j++) {
            if (matriz[j][columna].equals(String.valueOf(valorBuscado))) {

                return j;
            }
        }

        return -1;

    }

    public static void opciones(int opcion) {
        String[][] catalogo = matriz();
        String[] cabecera1 = new String[]{"Código", "Nombre", "Precio"};
        String[] cabecera2 = new String[]{"Código", "Nombre", "Stock"};

        switch (opcion) {
            case 1:
                visualizarResultadoMatriz("Stock de videojuegos: ", catalogo, 2, cabecera1);
                break;
            case 2:
                visualizarOpcion2();
                break;
            case 3:
                String[][] copiaCatalogo = copiarMatriz(catalogo);
                ordenarPorStock(copiaCatalogo);
                visualizarResultadoMatriz("Stock de videojuegos ordenado: ", copiaCatalogo, 3, cabecera2);
                break;
            case 4:
                String[][] copiaCatalogo2 = copiarMatriz(catalogo);
                ordenarPorPrecio(copiaCatalogo2);
                visualizarResultadoMatriz("Catálogo de videojuegos ordenado por precio de mayor a menor: ", copiaCatalogo2, 2, cabecera1);
                break;
            case 5:
                opcion5(catalogo);
                break;
            case 6:
                salirDelJuego();
                break;
            case 7:
                salirDelJuego();
                break;
        }
    }

}
