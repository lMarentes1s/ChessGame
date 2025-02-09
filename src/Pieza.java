public abstract class Pieza {
    protected String nombre;
    protected String color;

    public Pieza(String nombre, String color) {
        this.nombre = nombre;
        this.color = color;
    }

    public static String[] obtenerPiezasPorCantidad(int cantidadPiezas) {
        String[][] piezasPorCantidad = {
                {"01-Rey"},
                {"01-Rey", "02-Reina"},
                {"01-Rey", "02-Reina", "03-Alfil I", "04-Alfil II"},
                {"01-Rey", "02-Reina", "03-Alfil I", "04-Alfil II", "05-Caballo I", "06-Caballo II"},
                {"01-Rey", "02-Reina", "03-Alfil I", "04-Alfil II", "05-Caballo I", "06-Caballo II", "07-Torre I", "08-Torre II"},
                {"01-Rey", "02-Reina", "03-Alfil I", "04-Alfil II", "05-Caballo I", "06-Caballo II", "07-Torre I", "08-Torre II", "09-Peón 1", "10-Peón 2"},
                {"01-Rey", "02-Reina", "03-Alfil I", "04-Alfil II", "05-Caballo I", "06-Caballo II", "07-Torre I", "08-Torre II", "09-Peón 1", "10-Peón 2", "11-Peón 3", "12-Peón 4", "13-Peón 5", "14-Peón 6", "15-Peón 7", "16-Peón 8"}
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
