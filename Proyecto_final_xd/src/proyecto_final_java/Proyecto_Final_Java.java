package proyecto_final_java;

import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Random;

public class Proyecto_Final_Java {

    public static void main(String[] args) {
        MenuPrincipal();
    }

    public static void MenuPrincipal() {
        boolean salir = false;

        while (!salir) {
            String[] opciones = {"Iniciar Juego", "Instrucciones", "Salir"};
            int seleccion = JOptionPane.showOptionDialog(null, "Selecciona una opción:", "Preguntados by Los Magios",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);

            switch (seleccion) {
                case 0:
                    iniciarJuego();
                    break;
                case 1:
                    mostrarInstrucciones();
                    break;
                case 2:
                    salir = true;
                    JOptionPane.showMessageDialog(null, "Gracias por jugar. ¡Hasta pronto!", "Salida", JOptionPane.INFORMATION_MESSAGE);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Por favor, selecciona una opción válida.", "Opción inválida", JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    public static void iniciarJuego() {
        int puntuacionJugador1 = 0;
        int puntuacionJugador2 = 0;
        String titulo = "Preguntados by Los Magios";
        
        // Validación para el nombre del jugador 1
        String jugador1;
        do {
            jugador1 = JOptionPane.showInputDialog(null, "Jugador 1, ingresa tu nombre:", "Ingreso de nombre", JOptionPane.QUESTION_MESSAGE);
            if (jugador1 == null || jugador1.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Por favor ingrese un nombre válido para el Jugador 1.", "Nombre inválido", JOptionPane.WARNING_MESSAGE);
            }
        } while (jugador1 == null || jugador1.trim().isEmpty());

        // Validación para el nombre del jugador 2
        String jugador2;
        do {
            jugador2 = JOptionPane.showInputDialog(null, "Jugador 2, ingresa tu nombre:", "Ingreso de nombre", JOptionPane.QUESTION_MESSAGE);
            if (jugador2 == null || jugador2.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Por favor ingrese un nombre válido para el Jugador 2.", "Nombre inválido", JOptionPane.WARNING_MESSAGE);
            }
        } while (jugador2 == null || jugador2.trim().isEmpty());

        // Definir las categorías de preguntas
        HashMap<String, ArrayList<Pregunta>> categorias = new HashMap<>();

        ArrayList<Pregunta> categoria1 = new ArrayList<>();
        categoria1.add(new Pregunta("¿Cuál es el lenguaje de programación más usado en 2024?", new String[]{"Python", "Java", "JavaScript", "C++"}, 0));
        categoria1.add(new Pregunta("¿En qué año se lanzó Java?", new String[]{"1990", "1995", "2000", "2005"}, 1));
        categoria1.add(new Pregunta("¿Qué compañía desarrolló Java?", new String[]{"Microsoft", "Sun Microsystems", "Apple", "Google"}, 1));
        categoria1.add(new Pregunta("¿Cuál es el lenguaje más usado para el desarrollo web?", new String[]{"Java", "JavaScript", "C#", "Ruby"}, 1));
        categoria1.add(new Pregunta("¿Qué lenguaje es conocido por su simplicidad y legibilidad?", new String[]{"Python", "C++", "Swift", "PHP"}, 0));
        categoria1.add(new Pregunta("¿Cuál es el lenguaje desarrollado por Google?", new String[]{"Kotlin", "Swift", "Rust", "Go"}, 3));

        ArrayList<Pregunta> categoria2 = new ArrayList<>();
        categoria2.add(new Pregunta("¿Cuál es el país más grande del mundo?", new String[]{"China", "Rusia", "Estados Unidos", "Canadá"}, 1));
        categoria2.add(new Pregunta("¿Cuál es el océano más grande del mundo?", new String[]{"Atlántico", "Pacífico", "Índico", "Ártico"}, 1));
        categoria2.add(new Pregunta("¿Cuál es el continente más poblado?", new String[]{"Asia", "África", "Europa", "América"}, 0));
        categoria2.add(new Pregunta("¿Cuál es la capital de Japón?", new String[]{"Seúl", "Tokio", "Pekín", "Bangkok"}, 1));
        categoria2.add(new Pregunta("¿En qué continente se encuentra Egipto?", new String[]{"Asia", "África", "Europa", "América"}, 1));
        categoria2.add(new Pregunta("¿Cuál es la ciudad más poblada del mundo?", new String[]{"Nueva York", "Tokio", "Shanghái", "Delhi"}, 1));

        ArrayList<Pregunta> categoria3 = new ArrayList<>();
        categoria3.add(new Pregunta("¿Quién pintó la Mona Lisa?", new String[]{"Van Gogh", "Da Vinci", "Picasso", "Rembrandt"}, 1));
        categoria3.add(new Pregunta("¿En qué país se encuentra la Torre Eiffel?", new String[]{"Italia", "España", "Francia", "Alemania"}, 2));
        categoria3.add(new Pregunta("¿Cuál es el río más largo del mundo?", new String[]{"Nilo", "Amazonas", "Yangtsé", "Misisipi"}, 1));
        categoria3.add(new Pregunta("¿Quién es el autor de 'Cien años de soledad'?", new String[]{"Gabriel García Márquez", "Pablo Neruda", "Julio Cortázar", "Isabel Allende"}, 0));
        categoria3.add(new Pregunta("¿Qué obra es famosa de Picasso?", new String[]{"La noche estrellada", "El grito", "Las señoritas de Avignon", "La persistencia de la memoria"}, 2));
        categoria3.add(new Pregunta("¿Quién escribió 'Don Quijote de la Mancha'?", new String[]{"Cervantes", "Lope de Vega", "Góngora", "Bécquer"}, 0));

        // Agregar las categorías al mapa
        categorias.put("Ciencia y tecnología", categoria1);
        categorias.put("Geografía", categoria2);
        categorias.put("Arte e historia", categoria3);

        // Seleccionar al azar una categoría para cada jugador
        ArrayList<String> nombresCategorias = new ArrayList<>(categorias.keySet());
        Collections.shuffle(nombresCategorias);

        String categoriaJugador1 = nombresCategorias.get(0);
        String categoriaJugador2 = nombresCategorias.get(1);

        JOptionPane.showMessageDialog(null, jugador1 + " jugará en la categoría: " + categoriaJugador1);
        JOptionPane.showMessageDialog(null, jugador2 + " jugará en la categoría: " + categoriaJugador2);

        // Seleccionar 3 preguntas al azar para cada jugador
        Random rand = new Random();
        ArrayList<Pregunta> preguntasJugador1 = new ArrayList<>(categorias.get(categoriaJugador1));
        ArrayList<Pregunta> preguntasJugador2 = new ArrayList<>(categorias.get(categoriaJugador2));
        Collections.shuffle(preguntasJugador1);
        Collections.shuffle(preguntasJugador2);

        for (int i = 0; i < 3; i++) {
            // Pregunta para jugador 1
            Pregunta pregunta = preguntasJugador1.get(i);
            int respuestaJugador1 = JOptionPane.showOptionDialog(null, jugador1 + ", " + pregunta.texto, "Pregunta",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, pregunta.opciones, pregunta.opciones[0]);

            if (respuestaJugador1 == pregunta.respuestaCorrecta) {
                puntuacionJugador1++;
                JOptionPane.showMessageDialog(null, "¡Correcto!", titulo, JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Incorrecto. La respuesta correcta era " + pregunta.opciones[pregunta.respuestaCorrecta] + ".", titulo, JOptionPane.ERROR_MESSAGE);
            }

            // Pregunta para jugador 2
            pregunta = preguntasJugador2.get(i);
            int respuestaJugador2 = JOptionPane.showOptionDialog(null, jugador2 + ", " + pregunta.texto, "Pregunta",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, pregunta.opciones, pregunta.opciones[0]);

            if (respuestaJugador2 == pregunta.respuestaCorrecta) {
                puntuacionJugador2++;
                JOptionPane.showMessageDialog(null, "¡Correcto!", titulo, JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Incorrecto. La respuesta correcta era " + pregunta.opciones[pregunta.respuestaCorrecta] + ".", titulo, JOptionPane.ERROR_MESSAGE);
            }
        }

        // Calcula el porcentaje de aciertos y redondea al entero más cercano
        int totalPreguntas = 3; // Se han hecho 3 preguntas por jugador
        int porcentajeJugador1 = (int) ((puntuacionJugador1 / (double) totalPreguntas) * 100);
        int porcentajeJugador2 = (int) ((puntuacionJugador2 / (double) totalPreguntas) * 100);

        // Resultado final
        String mensajeFinal = jugador1 + ", tu puntuación final es: " + puntuacionJugador1 + "/" + totalPreguntas + 
                              " (" + porcentajeJugador1 + "%)\n" +
                              jugador2 + ", tu puntuación final es: " + puntuacionJugador2 + "/" + totalPreguntas + 
                              " (" + porcentajeJugador2 + "%)";

        if (puntuacionJugador1 > puntuacionJugador2) {
            mensajeFinal += "\n¡" + jugador1 + " es el ganador!";
        } else if (puntuacionJugador2 > puntuacionJugador1) {
            mensajeFinal += "\n¡" + jugador2 + " es el ganador!";
        } else {
            mensajeFinal += "\n¡Es un empate!";
        }

        JOptionPane.showMessageDialog(null, mensajeFinal, titulo, JOptionPane.INFORMATION_MESSAGE);
        JOptionPane.showMessageDialog(null, "Gracias por jugar!", titulo, JOptionPane.INFORMATION_MESSAGE);
    }

    public static void mostrarInstrucciones() {
        String instrucciones = "Bienvenido a Preguntados by Los Magios.\n\n"
                + "Instrucciones:\n"
                + "1. Cada jugador ingresará su nombre.\n"
                + "2. Cada jugador responderá preguntas en una categoría aleatoria.\n"
                + "3. Las respuestas correctas suman puntos.\n"
                + "4. Al final, el jugador con más puntos gana.\n\n"
                + "¡Buena suerte!";
        JOptionPane.showMessageDialog(null, instrucciones, "Instrucciones", JOptionPane.INFORMATION_MESSAGE);
    }
}

// Clase Pregunta
class Pregunta {
    String texto;
    String[] opciones;
    int respuestaCorrecta;

    public Pregunta(String texto, String[] opciones, int respuestaCorrecta) {
        this.texto = texto;
        this.opciones = opciones;
        this.respuestaCorrecta = respuestaCorrecta;
    }
}
