package eja;

/**
 *
 * @author alopezp90
 */
import java.util.Random;
import javax.swing.JOptionPane;

public class EjA {

    public static final int INTENTOS = 3;

    public static void main(String[] args) {

        boolean acierta = false, repetir;
        char letra, objetivo;

        do {
            objetivo = generaLetra();
            for (int i = 0; i < INTENTOS; i++) {
                letra = eligeLetra();
                if (letra == objetivo) {
                    acierta = true;
                    break;
                } else {
                    haFallado(letra, objetivo, i);
                }
            }
            mensajeFinal(acierta, objetivo);
            repetir = mensajeRepite();
        } while (repetir);
    }

    public static char generaLetra() {

        Random random = new Random();

        char letraMinus = (char) (random.nextInt(26) + 'a');
        return letraMinus;
    }

    public static char eligeLetra() {

        String texto;
        char letraElegida = 0;
        boolean repite = true;

        while (repite) {
            do {
                texto = JOptionPane.showInputDialog(null, "Introduce una letra (a-z)");
                if (texto == null) {
                    System.out.println("Entrada no válida. Repite.");
                }
            } while (texto == null);            
            letraElegida = texto.charAt(0);

            if (letraElegida >= 'a' && letraElegida <= 'z') {
                repite = false;
            } else if (letraElegida >= 'A' && letraElegida <= 'Z') {
                letraElegida = (char) (letraElegida + 32);
                repite = false;
            }
        }

        return letraElegida;
    }

    public static void haFallado(char letra, char objetivo, int i) {

        String pista;
        String mensaje = "La letra '" + letra + "' no es la correcta.";

        if (letra > objetivo) {
            pista = "anterior";
        } else {
            pista = "posterior";
        }
        if (i != INTENTOS - 1) {
            mensaje = mensaje + "\nTe quedan " + (INTENTOS - 1 - i)
                    + " intentos.\nPrueba una letra " + pista + ".";
        }
        JOptionPane.showMessageDialog(null, mensaje);
        System.out.println("Recuerda, es "+pista+" a '"+letra+"'.");
    }

    public static void mensajeFinal(boolean acierta, char objetivo) {

        if (acierta) {
            JOptionPane.showMessageDialog(null,
                    "¡ENHORABUENA, HAS ACERTADO! La letra era '" + objetivo + "'.");
        } else {
            JOptionPane.showMessageDialog(null,
                    "LO SENTIMOS. No has conseguido acertar, la letra era '" + objetivo + "'.");
        }
    }

    public static boolean mensajeRepite() {

        boolean repite = true;

        int opcion = JOptionPane.showOptionDialog(null,
                "¿Quieres volver a jugar?",
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
