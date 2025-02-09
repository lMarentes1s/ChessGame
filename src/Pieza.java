public abstract class Pieza {
    protected String nombre;
    protected String color;

    public Pieza(String nombre, String color) {
        this.nombre = nombre;
        this.color = color;
    }

    public static String[] obtenerPiezasPorCantidad(int cantidadPiezas) {
        String[][] piezasPorCantidad = {
                {"01"},
                {"01", "02"},
                {"01", "02", "03", "04"},
                {"01", "02", "03", "04", "05", "06"},
                {"01", "02", "03", "04", "05", "06", "07", "08"},
                {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10"},
                {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16"}
        };
        int index = (cantidadPiezas == 1) ? 0 : (cantidadPiezas == 2) ? 1 : (cantidadPiezas == 4) ? 2 : (cantidadPiezas == 6) ? 3 : (cantidadPiezas == 8) ? 4 : (cantidadPiezas == 10) ? 5 : 6;
        return piezasPorCantidad[index];
    }public static String[] obtenerPiezasPorCantidadConLetras(int cantidadPiezas) {
        String[][] piezasPorCantidad = {
                {"a"},
                {"a", "b"},
                {"a", "b", "c", "d"},
                {"a", "b", "c", "d", "e", "f"},
                {"a", "b", "c", "d", "e", "f", "g", "h"},
                {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j"},
                {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p"}
        };
        int index = (cantidadPiezas == 1) ? 0 : (cantidadPiezas == 2) ? 1 : (cantidadPiezas == 4) ? 2 : (cantidadPiezas == 6) ? 3 : (cantidadPiezas == 8) ? 4 : (cantidadPiezas == 10) ? 5 : 6;
        return piezasPorCantidad[index];
    }
    public String getNombre() {
        return nombre;
    }

    public String getColor() {
        return color;
    }

    public abstract void mover();
}

class Rey extends Pieza {
    public Rey(String color) {
        super("Rey", color);
    }

    @Override
    public void mover() {
        System.out.println("El Rey se mueve una casilla en cualquier dirección.");
    }
}

class Reina extends Pieza {
    public Reina(String color) {
        super("Reina", color);
    }

    @Override
    public void mover() {
        System.out.println("La Reina se mueve en cualquier dirección tantas casillas como quiera.");
    }
}

class Torre extends Pieza {
    public Torre(String color) {
        super("Torre", color);
    }

    @Override
    public void mover() {
        System.out.println("La Torre se mueve en líneas rectas verticales u horizontales.");
    }
}

class Alfil extends Pieza {
    public Alfil(String color) {
        super("Alfil", color);
    }

    @Override
    public void mover() {
        System.out.println("El Alfil se mueve en diagonal.");
    }
}

class Caballo extends Pieza {
    public Caballo(String color) {
        super("Caballo", color);
    }

    @Override
    public void mover() {
        System.out.println("El Caballo se mueve en forma de 'L'.");
    }
}

class Peon extends Pieza {
    public Peon(String color) {
        super("Peón", color);
    }

    @Override
    public void mover() {
        System.out.println("El Peón se mueve hacia adelante una casilla, dos si es su primer movimiento.");
    }
}
