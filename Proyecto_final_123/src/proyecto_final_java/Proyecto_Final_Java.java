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
        categoria1.add(new Pregunta("Programacion:¿Cuál es el lenguaje de programación más usado en 2024?", 
                                   new String[] {"Python", "Java", "JavaScript", "C++"}, 0));
        categoria1.add(new Pregunta("Programacion:¿En qué año se lanzó Java?", 
                                   new String[] {"1990", "1995", "2000", "2005"}, 1));
        categoria1.add(new Pregunta("Programacion:¿Qué compañía desarrolló Java?", 
                                   new String[] {"Microsoft", "Sun Microsystems", "Apple", "Google"}, 1));
        categoria1.add(new Pregunta("Programacion:¿Qué operador de asignación en Java se utiliza para sumar y asignar el resultado a una variable?",
                                    new String[]{"==","=","+="}, 2));
        categoria1.add(new Pregunta("Programacion:En Java, los operadores aritméticos incluyen +, -, *, / y %. ",
                                    new String[]{"Verdadero","Falso"},0));
        categoria1.add(new Pregunta("Programacion:¿Qué método se utiliza para agregar un elemento al final de un array en JavaScript?",
                                    new String[] {".append()" , ".push()" , ".add()"}, 1));
        categoria1.add(new Pregunta("Programacion:¿Qué palabra clave se usa para crear una nueva instancia de un objeto en Java?",
                                    new String[]{"init","New","create"},1));
        categoria1.add(new Pregunta("Programacion:¿Cuál es el resultado de la siguiente expresión en Python? 5 // 2",
                                    new String[]{"2.5","3","2"},2));
        categoria1.add(new Pregunta("Programacion:¿Cuál es la salida de la siguiente expresión en Python?: print(Hello  * 2 + World )",
                                    new String[]{"Hello World","HelloHelloWorld","Hello2World"},1));
        categoria1.add(new Pregunta("Programacion:¿Qué palabra clave se utiliza para declarar una variable que no cambiará su valor?",
                                    new String[]{"var","let","const"},2));
        categoria1.add(new Pregunta("¿Cuál es el lenguaje más usado para el desarrollo web?", new String[]{"Java", "JavaScript", "C#", "Ruby"}, 1));
        
        categoria1.add(new Pregunta("¿Qué lenguaje es conocido por su simplicidad y legibilidad?", new String[]{"Python", "C++", "Swift", "PHP"}, 0));
        
        categoria1.add(new Pregunta("¿Cuál es el lenguaje desarrollado por Google?", new String[]{"Kotlin", "Swift", "Rust", "Go"}, 3));

        ArrayList<Pregunta> categoria2 = new ArrayList<>();
        categoria2.add(new Pregunta("Estadística: ¿Cuál es la probabilidad de obtener cara al lanzar una moneda justa?", 
                           new String[] {"0.25", "0.5", "0.75"}, 1));
       categoria2.add(new Pregunta("Estadística: ¿Cuál de las siguientes es una distribución discreta?", 
                           new String[] {"Normal", "Poisson", "Exponencial"}, 1));
       categoria2.add(new Pregunta("Estadística: Si un dado tiene seis caras, ¿cuál es la probabilidad de obtener un número impar?", 
                           new String[] {"1/2", "1/3", "2/3"}, 0));
       categoria2.add(new Pregunta("Estadística: ¿Qué distribución discreta describe el número de éxitos en una serie de ensayos independientes?", 
                           new String[] {"Binomial", "Uniforme", "Normal"}, 0));
       categoria2.add(new Pregunta("Estadística: ¿La suma de las probabilidades en un espacio muestral debe ser igual a?", 
                           new String[] {"0", "1", "Depende del caso"}, 1));
       categoria2.add(new Pregunta("Estadística: ¿Cuál es la probabilidad de obtener un número mayor que 4 al lanzar un dado justo?", 
                           new String[] {"1/6", "1/3", "1/2"}, 1));
       categoria2.add(new Pregunta("Estadística: ¿Qué nombre recibe el suceso que contiene todos los resultados posibles en un experimento?", 
                           new String[] {"Evento seguro", "Evento simple", "Evento vacío"}, 0));
       categoria2.add(new Pregunta("Estadística: En una distribución binomial, si la probabilidad de éxito es p, ¿cuál es la probabilidad de fracaso?", 
                           new String[] {"1 - p", "p", "p^2"}, 0));
       categoria2.add(new Pregunta("Estadística: ¿Qué propiedad cumple una distribución de probabilidad discreta?", 
                           new String[] {"Cada probabilidad es positiva", "La suma de probabilidades es menor a 1", "No hay restricciones"}, 0));
       categoria2.add(new Pregunta("Estadística: ¿Cuál es la media de una distribución binomial con n ensayos y probabilidad p de éxito?", 
                           new String[] {"n * p", "p / n", "n + p"}, 0));


        ArrayList<Pregunta> categoria3 = new ArrayList<>();
       categoria3.add(new Pregunta("Inglés: Which component is considered the 'brain' of the computer?", 
                           new String[] {"RAM", "CPU", "Hard Drive"}, 1));
       categoria3.add(new Pregunta("Inglés: What does RAM stand for in computer hardware?", 
                           new String[] {"Random Access Memory", "Read Access Memory", "Run Access Module"}, 0));
       categoria3.add(new Pregunta("Inglés: Which role is primarily responsible for designing the look and feel of a website?", 
                           new String[] {"Back-end Developer", "Graphic Designer", "Front-end Developer"}, 2));
       categoria3.add(new Pregunta("Inglés: What does the acronym 'IT' stand for?", 
                           new String[] {"Information Technology", "Internet Technology", "Integrated Technology"}, 0));
       categoria3.add(new Pregunta("Inglés: Which software is commonly used to manage relational databases?", 
                           new String[] {"Photoshop", "Microsoft Access", "Premiere Pro"}, 1));
       categoria3.add(new Pregunta("Inglés: Who is responsible for creating, modifying, and managing websites?", 
                           new String[] {"Software Developer", "Web Developer", "Database Administrator"}, 1));
       categoria3.add(new Pregunta("Inglés: What is the purpose of an operating system?", 
                           new String[] {"To manage computer resources", "To create websites", "To edit videos"}, 0));
       categoria3.add(new Pregunta("Inglés: Which job involves ensuring that software works as expected by testing it?", 
                           new String[] {"Web Developer", "Software Tester", "Database Administrator"}, 1));
       categoria3.add(new Pregunta("Inglés: Which of the following is a popular content management system (CMS) for websites?", 
                           new String[] {"Microsoft Word", "WordPress", "Excel"}, 1));
       categoria3.add(new Pregunta("Inglés: What is the main function of a hard drive in a computer?", 
                           new String[] {"Processing data", "Storing data", "Transmitting data"}, 1));


        // Agregar las categorías al mapa
        categorias.put("Programacion", categoria1);
        categorias.put("Estadística", categoria2);
        categorias.put("Inglés", categoria3);

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
