
package proyecto_final_java;

import javax.swing.JOptionPane;
public class Proyecto_Final_Java {
    public static void main(String[] args) {
        int puntuacionJugador1 = 0;
        int puntuacionJugador2 = 0;
        String jugador1 = JOptionPane.showInputDialog("Jugador 1, ingresa tu nombre:");
        String jugador2 = JOptionPane.showInputDialog("Jugador 2, ingresa tu nombre:");
        String pregunta1 = "¿Cuál es el lenguaje de programación más usado en 2024?";
        String[] opciones1 = {"Python", "Java", "JavaScript", "C++"};
        int respuesta1 = JOptionPane.showOptionDialog(null, jugador1 + ", " + pregunta1, "Pregunta 1",
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones1, opciones1[0]);

        if (respuesta1 == 0) {
            puntuacionJugador1 += 1;
            JOptionPane.showMessageDialog(null, "¡Correcto! Python es el lenguaje más popular.");
        } else {
            JOptionPane.showMessageDialog(null, "Incorrecto. La respuesta correcta era Python.");
        }

        respuesta1 = JOptionPane.showOptionDialog(null, jugador2 + ", " + pregunta1, "Pregunta 1",
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones1, opciones1[0]);

        if (respuesta1 == 0) {
            puntuacionJugador2 += 1;
            JOptionPane.showMessageDialog(null, "¡Correcto! Python es el lenguaje más popular.");
        } else {
            JOptionPane.showMessageDialog(null, "Incorrecto. La respuesta correcta era Python.");
        }

        String pregunta2 = "¿En qué año se lanzó Java?";
        String[] opciones2 = {"1990", "1995", "2000", "2005"};
        int respuesta2 = JOptionPane.showOptionDialog(null, jugador1 + ", " + pregunta2, "Pregunta 2",
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones2, opciones2[0]);

        if (respuesta2 == 1) {
            puntuacionJugador1 += 1;
            JOptionPane.showMessageDialog(null, "¡Correcto! Java fue lanzado en 1995.");
        } else {
            JOptionPane.showMessageDialog(null, "Incorrecto. La respuesta correcta era 1995.");
        }

        respuesta2 = JOptionPane.showOptionDialog(null, jugador2 + ", " + pregunta2, "Pregunta 2",
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones2, opciones2[0]);

        if (respuesta2 == 1) {
            puntuacionJugador2 += 1;
            JOptionPane.showMessageDialog(null, "¡Correcto! Java fue lanzado en 1995.");
        } else {
            JOptionPane.showMessageDialog(null, "Incorrecto. La respuesta correcta era 1995.");
        }

        String pregunta3 = "¿Qué compañía desarrolló Java?";
        String[] opciones3 = {"Microsoft", "Sun Microsystems", "Apple", "Google"};
        int respuesta3 = JOptionPane.showOptionDialog(null, jugador1 + ", " + pregunta3, "Pregunta 3",
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones3, opciones3[0]);

        if (respuesta3 == 1) {
            puntuacionJugador1 += 1;
            JOptionPane.showMessageDialog(null, "¡Correcto! Sun Microsystems desarrolló Java.");
        } else {
            JOptionPane.showMessageDialog(null, "Incorrecto. La respuesta correcta era Sun Microsystems.");
        }

        respuesta3 = JOptionPane.showOptionDialog(null, jugador2 + ", " + pregunta3, "Pregunta 3",
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones3, opciones3[0]);

        if (respuesta3 == 1) {
            puntuacionJugador2 += 1;
            JOptionPane.showMessageDialog(null, "¡Correcto! Sun Microsystems desarrolló Java.");
        } else {
            JOptionPane.showMessageDialog(null, "Incorrecto. La respuesta correcta era Sun Microsystems.");
        }

        String mensajeFinal = jugador1 + ", tu puntuación final es: " + puntuacionJugador1 + "/3\n" +
                              jugador2 + ", tu puntuación final es: " + puntuacionJugador2 + "/3";

        if (puntuacionJugador1 > puntuacionJugador2) {
            mensajeFinal += "\n¡" + jugador1 + " es el ganador!";
        } else if (puntuacionJugador2 > puntuacionJugador1) {
            mensajeFinal += "\n¡" + jugador2 + " es el ganador!";
        } else {
            mensajeFinal += "\n¡Es un empate!";
        }

        JOptionPane.showMessageDialog(null, mensajeFinal);

        JOptionPane.showMessageDialog(null, "Gracias por jugar!");
    }
}

