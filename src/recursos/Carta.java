package recursos;

/**
 * Represents a single card in a Spanish deck.
 * Each card has a suit (`palo`) and a number (`numero`), following the Spanish
 * deck conventions.
 */
public class Carta {
    private Palo palo; // The suit of the card (e.g., "Oros", "Copas")
    private int numero; // The number of the card (1-12, excluding 8 and 9)

    /**
     * Constructs a `Carta` (card) with a specified suit and number.
     *
     * @param palo   The suit of the card.
     * @param numero The number of the card.
     */
    public Carta(Palo palo, int numero) {
        this.palo = palo;
        this.numero = numero;
    }

    /**
     * Returns the suit of the card as a string.
     *
     * @return A string representation of the suit.
     */
    public String getPalo() {
        return palo.toString();
    }

    /**
     * Returns the number of the card.
     *
     * @return The number of the card.
     */
    public int getNumero() {
        return numero;
    }

    /**
     * Returns a string representation of the card, showing both suit and number.
     *
     * @return A string in the format "(suit, number)".
     */
    @Override
    public String toString() {
        return "(" + palo + ", " + numero + ')';
    }
}
