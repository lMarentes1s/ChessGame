import java.util.Scanner;

public class Jugador {
    private String nombre;
    private String colorPiezas;
    private String algoritmoOrdenamiento;
    private String tipoLista;
    private int cantidadPiezas;
    private int velocidadOrdenamiento;

    public Jugador() {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Ingrese su nombre: ");
            this.nombre = scanner.nextLine();

            System.out.print("Seleccione el color de sus piezas (blancas/negras): ");
            this.colorPiezas = scanner.nextLine().toLowerCase();
            if (!colorPiezas.equals("blancas") && !colorPiezas.equals("negras")) {
                throw new IllegalArgumentException("Color inválido. Debe ser 'blancas' o 'negras'.");
            }

            System.out.print("Seleccione el algoritmo de ordenamiento (S, B, I, M, Q, H, C, R): ");
            this.algoritmoOrdenamiento = scanner.nextLine().toUpperCase();
            if (!algoritmoOrdenamiento.matches("[SBIMQHCR]")) {
                throw new IllegalArgumentException("Algoritmo inválido. Debe ser una de las opciones disponibles.");
            }

            System.out.print("Seleccione el tipo de lista (N para numérica, C para caracteres): ");
            this.tipoLista = scanner.nextLine().toUpperCase();
            if (!tipoLista.equals("N") && !tipoLista.equals("C")) {
                throw new IllegalArgumentException("Tipo de lista inválido. Debe ser 'N' o 'C'.");
            }

            System.out.print("Seleccione la cantidad de piezas (1, 2, 4, 6, 8, 10, 16): ");
            this.cantidadPiezas = Integer.parseInt(scanner.nextLine());
            if (cantidadPiezas != 1 && cantidadPiezas != 2 && cantidadPiezas != 4 && cantidadPiezas != 6 &&
                    cantidadPiezas != 8 && cantidadPiezas != 10 && cantidadPiezas != 16) {
                throw new IllegalArgumentException("Cantidad de piezas inválida. Debe ser una de las opciones disponibles.");
            }

            System.out.print("Ingrese la velocidad de ordenamiento (100 - 1000 ms): ");
            this.velocidadOrdenamiento = Integer.parseInt(scanner.nextLine());
            if (velocidadOrdenamiento < 100 || velocidadOrdenamiento > 1000) {
                throw new IllegalArgumentException("Velocidad inválida. Debe estar entre 100 y 1000 ms.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
            System.exit(1);
        } catch (Exception e) {
            System.out.println("Error inesperado. Asegúrese de ingresar valores válidos.");
            System.exit(1);
        }
    }

    public String getNombre() {
        return nombre;
    }

    public String getColorPiezas() {
        return colorPiezas;
    }

    public String getAlgoritmoOrdenamiento() {
        return algoritmoOrdenamiento;
    }

    public String getTipoLista() {
        return tipoLista;
    }

    public int getCantidadPiezas() {
        return cantidadPiezas;
    }

    public int getVelocidadOrdenamiento() {
        return velocidadOrdenamiento;
    }
}