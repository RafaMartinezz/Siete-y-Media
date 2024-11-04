package sieteymedia;

import java.util.Scanner;
import recursos.Carta;

/**
 * A console-based interface for the "Siete y Media" card game.
 * This class handles game instructions, player and dealer turns, and displays
 * the outcome.
 */
public class InterfaceConsola {
    private Scanner sc; // Scanner for user input
    private SieteYMedia SYM; // Game logic handler for "Siete y Media"

    /**
     * Initializes the console interface, presents the game instructions, and starts
     * the game.
     */
    public InterfaceConsola() {
        sc = new Scanner(System.in);
        SYM = new SieteYMedia();
        presentarJuego();
        jugar();
    }

    /**
     * Displays the rules and instructions for the "Siete y Media" game to the
     * player.
     */
    void presentarJuego() {
        System.out.println("- El usuario es el jugador y el ordenador la banca.");
        System.out.println("- No hay en la baraja 8s y 9s. El 10 es la sota, el 11 el caballo y el 12 el Rey.");
        System.out.println("- Las figuras (10-sota, 11-caballo y 12-rey) valen medio punto y, el resto, su valor.");
        System.out.println(
                "- Hay dos turnos de juego: el turno del jugador y el turno de la banca. Se comienza por el turno del jugador.");
        System.out.println("- El jugador va pidiendo cartas a la banca de una en una.");
        System.out.println("- El jugador puede plantarse en cualquier momento.");
        System.out.print("- Si la suma de los valores de las cartas sacadas es superior ");
        System.out.println("a 7 y medio, el jugador 'se pasa de siete y medio' y pierde.");
        System.out.println(
                "- Si el jugador no se pasa, comienza a sacar cartas la banca y ésta está obligada a sacar cartas hasta empatar o superar al jugador.");
        System.out.println(
                "- Si la banca consigue empatar o superar la puntuación del jugador 'sin pasarse de siete y medio', gana la banca.");
        System.out.println(
                "- La banca no se puede plantar y tiene que empatar o superar la puntuación del jugador sin pasarse.");
        System.out.println(
                "- En este proceso puede ocurrir que la banca 'se pase' y entonces pierde la banca y gana el jugador.");
        System.out.println("\nEmpecemos!!!\n");
    }

    /**
     * Starts the game by executing the player's turn and then the dealer's turn.
     */
    void jugar() {
        turnoJugador();
        turnoBanca();
        System.out.println("Adios");
    }

    /**
     * Handles the player's turn, allowing them to draw cards or stop when they
     * choose.
     * The player can keep drawing cards until they choose to stop or their hand
     * exceeds 7.5 points.
     */
    void turnoJugador() {
        char opc = 'C'; // Default to 'C' for continuing to draw cards

        System.out.println("Como mínimo recibes una carta, luego puedes decidir si seguir o plantarte");

        while (!SYM.esFinTurnoJugador() && opc == 'C') {
            SYM.darCartaJugador(); // Deal a card to the player

            // Show player's cards and their value
            System.out.println("Éstas son tus cartas jugador:");
            mostrarCartas(SYM.getCartasJugador());
            double valor = SYM.valorCartas(SYM.getCartasJugador());
            System.out.println("\n\tValor de cartas: " + valor);

            // Check if player wants another card or to stop
            if (valor < 7.5) {
                System.out.println("\n¿Pides [C]arta o te [P]lantas?");
                opc = sc.next().trim().toUpperCase().charAt(0);
            }
        }
    }

    /**
     * Handles the dealer's turn, where the dealer must draw cards until they match
     * or exceed the player's score.
     * The dealer cannot stop voluntarily and loses if their score exceeds 7.5.
     */
    void turnoBanca() {
        double valorCartasJugador = SYM.valorCartas(SYM.getCartasJugador());

        // Check if the player has already lost
        if (valorCartasJugador > 7.5) {
            System.out.println("Jugador, te has pasado en tu jugada anterior, gana la banca");
            return;
        }

        System.out.println("\n\nTurno de banca ...");

        // Dealer draws cards until their score matches or exceeds the player's score
        while (SYM.valorCartas(SYM.getCartasBanca()) < valorCartasJugador) {
            SYM.darCartaBanca();
        }

        System.out.println("Éstas son mis cartas:");
        mostrarCartas(SYM.getCartasBanca());
        System.out.println("\nValor de mis cartas (banca): " + SYM.valorCartas(SYM.getCartasBanca()));

        // Determine the winner based on dealer's final score
        if (SYM.valorCartas(SYM.getCartasBanca()) > 7.5) {
            System.out.println("Me pasé, ganas tú, jugador");
        } else {
            System.out.println("Gana la banca");
        }
    }

    /**
     * Displays the cards in a given hand.
     *
     * @param cartas Array of `Carta` objects representing a player's or dealer's
     *               hand.
     */
    void mostrarCartas(Carta[] cartas) {
        int i = 0;
        while (cartas[i] != null) {
            System.out.print("\t" + cartas[i]);
            i++;
        }
        System.out.println();
    }

    /**
     * Entry point of the program. Initializes and starts the console interface for
     * the game.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        new InterfaceConsola();
    }
}
