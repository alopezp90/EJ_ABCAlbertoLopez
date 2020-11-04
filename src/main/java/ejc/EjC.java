package ejc;

/**
 *
 * @author alopezp90
 */
import javax.swing.JOptionPane;
import java.util.Random;

public class EjC {

    public static final int DESCUENTO1 = 10, DESCUENTO2 = 25, DESCUENTO3 = 40;
    public static final String COLOR1 = "Rojo", COLOR2 = "Naranja", COLOR3 = "Verde";

    public static void main(String[] args) {
        boolean repetir;

        do {
            preguntaBoton();
            mensajeDescuento();
            repetir = mensajeRepite();
        } while (repetir);
    }

    public static void preguntaBoton() {
        int opcion;

        do {
            opcion = JOptionPane.showOptionDialog(null,
                    "¡Pulsa para conseguir un descuento!",
                    "Pulsa",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    new Object[]{"PULSAR"},
                    null);
            if (opcion != 0) {
                JOptionPane.showMessageDialog(null,
                        "Pues nada, que pase el siguiente cliente.");
            }
        } while (opcion != 0);
    }

    public static void mensajeDescuento() {
        int descuento;
        String color = "";
        Random random = new Random();

        descuento = random.nextInt(3) + 1;
        switch (descuento) {
            case 1:
                color = COLOR1;
                descuento = DESCUENTO1;
                break;
            case 2:
                color = COLOR2;
                descuento = DESCUENTO2;
                break;
            case 3:
                color = COLOR3;
                descuento = DESCUENTO3;
                break;
        }
        JOptionPane.showMessageDialog(null,
                "¡¡¡Ha salido: " + color + ",\nrecibes un descuento del "+descuento+"%!!!");
    }
    
    public static boolean mensajeRepite() {

        boolean repite = true;

        int opcion = JOptionPane.showOptionDialog(null,
                "¿Quieres esperar al siguiente cliente?",
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
