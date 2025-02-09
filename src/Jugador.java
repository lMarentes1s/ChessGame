import java.util.Scanner;

public class Jugador {
    private String colorPiezas;
    private String algoritmoOrdenamiento;
    private String tipoLista;
    private int cantidadPiezas;
    private int velocidadOrdenamiento;

    public Jugador(String[] args) {
        if (args.length < 5) {
            System.out.println("Uso: java CHESS a=<algoritmo> t=<tipo> c=<color> r=<cantidad> s=<velocidad>");
           // System.exit(1);
        }

        try {
            this.algoritmoOrdenamiento = args[0].split("=")[1].toUpperCase();
            if (!algoritmoOrdenamiento.matches("[SBIMQHCR]")) {
                throw new IllegalArgumentException("Algoritmo inválido. Debe ser una de las opciones disponibles.");
            }

            this.tipoLista = args[1].split("=")[1].toUpperCase();
            if (!tipoLista.equals("N") && !tipoLista.equals("C")) {
                throw new IllegalArgumentException("Tipo de lista inválido. Debe ser 'N' o 'C'.");
            }

            this.colorPiezas = args[2].split("=")[1].toLowerCase();
            if (!colorPiezas.equals("b") && !colorPiezas.equals("w")) {
                throw new IllegalArgumentException("Color inválido. Debe ser 'blancas' o 'negras'.");
            }

            this.cantidadPiezas = Integer.parseInt(args[3].split("=")[1]);
            if (cantidadPiezas != 1 && cantidadPiezas != 2 && cantidadPiezas != 4 && cantidadPiezas != 6 &&
                    cantidadPiezas != 8 && cantidadPiezas != 10 && cantidadPiezas != 16) {
                throw new IllegalArgumentException("Cantidad de piezas inválida. Debe ser una de las opciones disponibles.");
            }

           // this.velocidadOrdenamiento = Integer.parseInt(args[4].split("=")[1]);
         //   if (velocidadOrdenamiento < 100 || velocidadOrdenamiento > 1000) {
        //        throw new IllegalArgumentException("Velocidad inválida. Debe estar entre 100 y 1000 ms.");
         //   }
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
            System.exit(1);
        } catch (Exception e) {
            System.out.println("Error inesperado. Asegúrese de ingresar valores válidos.");
            System.exit(1);
        }
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