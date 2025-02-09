import java.util.Random;
import java.util.Arrays;

public class AlgoritmosOrdenamiento{

    public static void aplicarOrdenamiento(String algoritmo, Pieza[] piezas) {
        switch (algoritmo.toUpperCase()) {
            case "S":
                selectionSort(piezas);
                break;
            case "B":
                bubbleSort(piezas);
                break;
            case "I":
                insertionSort(piezas);
                break;
            case "M":
                mergeSort(piezas, 0, piezas.length - 1);
                break;
            case "Q":
                quickSort(piezas, 0, piezas.length - 1);
                break;
            default:
                System.out.println("Algoritmo no reconocido.");
                return;
        }
        mostrarPiezas(piezas);
    }

    public static void selectionSort(Pieza[] piezas) {
        int n = piezas.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (piezas[j].getNombre().compareTo(piezas[minIndex].getNombre()) < 0) {
                    minIndex = j;
                }
            }
            Pieza temp = piezas[minIndex];
            piezas[minIndex] = piezas[i];
            piezas[i] = temp;
        }
    }

    public static void bubbleSort(Pieza[] piezas) {
        int n = piezas.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (piezas[j].getNombre().compareTo(piezas[j + 1].getNombre()) > 0) {
                    Pieza temp = piezas[j];
                    piezas[j] = piezas[j + 1];
                    piezas[j + 1] = temp;
                }
            }
        }
    }

    public static void insertionSort(Pieza[] piezas) {
        int n = piezas.length;
        for (int i = 1; i < n; i++) {
            Pieza key = piezas[i];
            int j = i - 1;
            while (j >= 0 && piezas[j].getNombre().compareTo(key.getNombre()) > 0) {
                piezas[j + 1] = piezas[j];
                j = j - 1;
            }
            piezas[j + 1] = key;
        }
    }

    public static void mergeSort(Pieza[] piezas, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(piezas, left, mid);
            mergeSort(piezas, mid + 1, right);
            merge(piezas, left, mid, right);
        }
    }

    private static void merge(Pieza[] piezas, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        Pieza[] leftArray = Arrays.copyOfRange(piezas, left, mid + 1);
        Pieza[] rightArray = Arrays.copyOfRange(piezas, mid + 1, right + 1);

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (leftArray[i].getNombre().compareTo(rightArray[j].getNombre()) <= 0) {
                piezas[k] = leftArray[i];
                i++;
            } else {
                piezas[k] = rightArray[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            piezas[k++] = leftArray[i++];
        }
        while (j < n2) {
            piezas[k++] = rightArray[j++];
        }
    }

    public static void quickSort(Pieza[] piezas, int low, int high) {
        if (low < high) {
            int pi = partition(piezas, low, high);
            quickSort(piezas, low, pi - 1);
            quickSort(piezas, pi + 1, high);
        }
    }

    private static int partition(Pieza[] piezas, int low, int high) {
        Pieza pivot = piezas[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (piezas[j].getNombre().compareTo(pivot.getNombre()) <= 0) {
                i++;
                Pieza temp = piezas[i];
                piezas[i] = piezas[j];
                piezas[j] = temp;
            }
        }
        Pieza temp = piezas[i + 1];
        piezas[i + 1] = piezas[high];
        piezas[high] = temp;
        return i + 1;
    }

    public static void mostrarPiezas(Pieza[] piezas) {
        System.out.println("Piezas ordenadas:");
        for (Pieza pieza : piezas) {
            System.out.println(pieza.getNombre() + " (" + pieza.getColor() + ")");
        }
    }
}
