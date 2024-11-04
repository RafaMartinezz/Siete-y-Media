package recursos;

import java.util.Random;

/**
 * Represents a Spanish deck of 40 cards. The deck includes 10 cards per suit
 * (no 8s or 9s).
 * Provides functionality to shuffle the deck and deal a specified number of
 * cards.
 */
public class Baraja {
    private final int NUM_CARTAS = 40; // Total number of cards in a Spanish deck
    private Carta[] cartas = new Carta[NUM_CARTAS]; // Array holding all the cards in the deck
    private int primeraMazo = 0; // Index of the first card still in the deck (not yet dealt)

    /**
     * Constructs a `Baraja` (deck) with cards ordered by suit and number, excluding
     * 8 and 9.
     */
    public Baraja() {
        int ultimaCarta = 0; // Tracks the current position in the deck array
        for (Palo p : Palo.values()) {
            for (int j = 0; j < 12; j++) {
                if (j == 7 || j == 8) { // Skip 8 and 9
                    continue;
                }
                cartas[ultimaCarta] = new Carta(p, j + 1); // Add card to deck
                ultimaCarta++;
            }
        }
    }

    /**
     * Shuffles the deck, specifically the portion of cards that have not yet been
     * dealt.
     */
    public void barajar() {
        Random r = new Random();
        // Shuffle only the cards in the deck that have not yet been dealt
        for (int i = primeraMazo; i < cartas.length; i++) {
            int posicionAzar = r.nextInt(cartas.length - primeraMazo) + primeraMazo;
            Carta temp = cartas[i];
            cartas[i] = cartas[posicionAzar];
            cartas[posicionAzar] = temp;
        }
    }

    /**
     * Deals a specified number of cards from the deck.
     * If there are not enough cards remaining in the deck, returns an empty array.
     *
     * @param numCartasDar The number of cards to deal.
     * @return An array of dealt `Carta` objects. Returns an empty array if not
     *         enough cards remain.
     */
    public Carta[] darCartas(int numCartasDar) {
        int cartasEnMazo = cartas.length - primeraMazo; // Count of undealt cards in the deck
        Carta[] cartasParaDar;

        // If there are not enough cards in the deck, return an empty array
        if (cartasEnMazo < numCartasDar) {
            cartasParaDar = new Carta[0];
        } else {
            cartasParaDar = new Carta[numCartasDar];
            for (int i = 0; i < cartasParaDar.length; i++) {
                cartasParaDar[i] = cartas[primeraMazo + i]; // Assign cards to be dealt
            }
            primeraMazo += numCartasDar; // Update the first undealt card index
        }
        return cartasParaDar;
    }
}
