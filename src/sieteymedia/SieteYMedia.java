package sieteymedia;

import recursos.Carta;
import recursos.Baraja;

/**
 * Manages the logic for the "Siete y Media" game.
 * Handles the deck, player and dealer hands, and provides methods for dealing
 * cards
 * and calculating the score.
 */
public class SieteYMedia {
    private Baraja baraja; // The deck of cards used in the game
    private Carta[] cartasJugador; // Array to store the player's hand of cards
    private Carta[] cartasBanca; // Array to store the dealer's hand of cards
    private boolean finTurnoJugador; // Flag to indicate if the player's turn has ended

    /**
     * Initializes the game by shuffling the deck and preparing empty hands for
     * player and dealer.
     */
    public SieteYMedia() {
        baraja = new Baraja();
        baraja.barajar(); // Shuffle the deck
        cartasJugador = new Carta[15]; // Initialize player's hand with a maximum of 15 cards
        cartasBanca = new Carta[15]; // Initialize dealer's hand with a maximum of 15 cards
    }

    /**
     * Returns the player's current hand.
     *
     * @return Array of `Carta` objects representing the player's hand.
     */
    Carta[] getCartasJugador() {
        return cartasJugador;
    }

    /**
     * Returns the dealer's current hand.
     *
     * @return Array of `Carta` objects representing the dealer's hand.
     */
    Carta[] getCartasBanca() {
        return cartasBanca;
    }

    /**
     * Checks if the player's turn should end based on their hand value.
     * Ends the turn if the player's total card value is 7.5 or higher.
     *
     * @return True if the player's turn has ended; false otherwise.
     */
    boolean esFinTurnoJugador() {
        finTurnoJugador = valorCartas(getCartasJugador()) >= 7.5;
        return finTurnoJugador;
    }

    /**
     * Deals one card to the player from the deck and adds it to their hand.
     */
    void darCartaJugador() {
        Carta c = baraja.darCartas(1)[0]; // Deal one card to the player
        int i = 0;
        while (cartasJugador[i] != null) { // Find the next empty position in the player's hand
            i++;
        }
        cartasJugador[i] = c; // Place the dealt card in the player's hand
    }

    /**
     * Deals one card to the dealer from the deck and adds it to their hand.
     */
    void darCartaBanca() {
        Carta c = baraja.darCartas(1)[0]; // Deal one card to the dealer
        int i = 0;
        while (cartasBanca[i] != null) { // Find the next empty position in the dealer's hand
            i++;
        }
        cartasBanca[i] = c; // Place the dealt card in the dealer's hand
    }

    /**
     * Calculates the total value of the given hand.
     * Each card is worth its number unless it's a face card (10, 11, 12), which are
     * worth 0.5.
     *
     * @param cartas Array of `Carta` objects representing a hand of cards.
     * @return The total value of the hand as a double.
     */
    double valorCartas(Carta[] cartas) {
        double total = 0.0;
        int i = 0;

        while (cartas[i] != null) {
            int val = cartas[i].getNumero();
            total += (val > 7) ? 0.5 : val; // Face cards (10, 11, 12) are worth 0.5; others are worth their number
            i++;
        }
        return total;
    }
}
