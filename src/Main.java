import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Jugador jugador = new Jugador(args);
        String[] nombresPiezas;

        if (jugador.getTipoLista().equals("N")) {
            nombresPiezas = Pieza.obtenerPiezasPorCantidad(jugador.getCantidadPiezas());
        } else {
            nombresPiezas = Pieza.obtenerPiezasPorCantidadConLetras(jugador.getCantidadPiezas());
        }

        List<String> listaPiezas = Arrays.asList(nombresPiezas);
        Collections.shuffle(listaPiezas);
        nombresPiezas = listaPiezas.toArray(new String[0]);
        Pieza[] piezas = new Pieza[nombresPiezas.length];

        for (int i = 0; i < nombresPiezas.length; i++) {
            piezas[i] = new Pieza(nombresPiezas[i], jugador.getColorPiezas()) {
                @Override
                public void mover() {
                    System.out.println("En pruebas...");
                }
            };
        }

        // Mostrar piezas antes del ordenamiento
        System.out.println("Piezas antes del ordenamiento:");
        for (Pieza pieza : piezas) {
            System.out.println(pieza.getNombre() + " (" + pieza.getColor() + ")");
        }

        System.out.println();

        // Aplicar algoritmo de ordenamiento
        AlgoritmosOrdenamiento.aplicarOrdenamiento(jugador.getAlgoritmoOrdenamiento(), piezas);
    }
}