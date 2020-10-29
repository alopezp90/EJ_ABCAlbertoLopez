package ejb;

/**
 *
 * @author alopezp90
 */
import java.util.Random;
import javax.swing.JOptionPane;

public class EjB {

    public static final int DIGITOS = 4;

    public static void main(String[] args) {
        boolean repite;
        int cantidad;
        int[][] pin;

        do {
            cantidad = eligeCantidad();
            pin = new int[DIGITOS][cantidad];

            for (int i = 0; i < cantidad; i++) {
                for (int posicion = 0; posicion < DIGITOS; posicion++) {
                    pin[posicion][i] = calculaPin(pin, posicion, i);
                }
            }
            mensajeResultado(pin);
            repite = mensajeRepite();
        } while (repite);
    }

    public static int eligeCantidad() {
        String texto;

        do {
            texto = JOptionPane.showInputDialog("¿Cuántos PIN quieres calcular?");
            if (!isParsable(texto) || Integer.parseInt(texto) < 1 ||
                    Integer.parseInt(texto) == 0 || Integer.parseInt(texto) > 500) {
                JOptionPane.showMessageDialog(null, "Introduce un número valido (1-500).");
            }
        } while (!isParsable(texto) || Integer.parseInt(texto) < 1 ||
                Integer.parseInt(texto) == 0 || Integer.parseInt(texto) > 500);
        int cantidad = Integer.parseInt(texto);
        return cantidad;
    }

    public static boolean isParsable(String texto) {
        try {
            Integer.parseInt(texto);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static int calculaPin(int[][] pin, int posicion, int i) {
        int digitoValido = 0;

        switch (posicion) {
            case 0:
                digitoValido = aleatorio();
                break;
            case 1:
                do {
                    digitoValido = aleatorio();
                } while (digitoValido == pin[0][i]);
                break;
            case 2:
                do {
                    digitoValido = aleatorio();
                } while (digitoValido == pin[0][i] || digitoValido == pin[1][i]
                        || (digitoValido + pin[0][i]) % 2 == 0);
                break;
            case 3:
                do {
                    digitoValido = aleatorio();
                } while (digitoValido == pin[0][i] || digitoValido == pin[1][i]
                        || digitoValido == pin[2][i] || (digitoValido * pin[1][i]) % 2 != 0);
                break;
        }
        return digitoValido;
    }

    public static int aleatorio() {
        Random random = new Random();
        int aleatorio = random.nextInt(10);
        return aleatorio;
    }

    public static void mensajeResultado(int[][] pin) {
        String mensaje = "Los PIN solicitados son:";

        for (int i = 0; i < pin[0].length; i++) {
            if (i % 10 == 0) {
                mensaje = mensaje + "\n";
            } else {
                mensaje = mensaje + " | ";
            }
            mensaje = mensaje + pin[0][i] + pin[1][i] + pin[2][i] + pin[3][i];
        }
        JOptionPane.showMessageDialog(null, mensaje);
    }

    public static boolean mensajeRepite() {

        boolean repite = true;

        int opcion = JOptionPane.showOptionDialog(null,
                "¿Quieres calcular más PIN?",
                "Elige",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                new Object[]{"Sí", "No"},
                null);

        if (opcion != 0) {
            repite = false;
        }
        return repite;
    }
}
