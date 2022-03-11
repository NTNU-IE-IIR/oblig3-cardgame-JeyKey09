package no.ntnu.mathijoh.cardgame.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * A deck of cards
 * @author Matias J. Kirkeby
 * @version 11-03-2022
 */
public class DeckOfCard {
    
    private final char[] suit = {'S','H','D','C'};
    private final int cardeachsuit = 13; 
    private Random randomgeneraor;
    private List<PlayingCard> deck;

    /**
     * Constructs a normal deck of 52 cards 
     */
    public DeckOfCard() {
        this.deck = new ArrayList<>();
        for (char cSuit : suit) {
            for(int i = 1; i <= cardeachsuit ; i++) {
                deck.add(new PlayingCard(cSuit, i));
            }
        }
        randomgeneraor = new Random();
    }

    /**
     * Returns a list of n random cards and removes them from the deck
     * @param n the amount of random cards 
     * @return a list of random cards
     * @throws IllegalArgumentException if the number is higher the amount of cards in the deck
     */
    public List<PlayingCard> dealHand(int n) throws IllegalArgumentException {
        List<PlayingCard> placeholderPlayingCards = new ArrayList<>();
        if (n > this.deck.size()) {
            throw new IllegalArgumentException("You picked to many cards");
        }

        for(int i = 0; n > i; i++) {
            int index = this.randomgeneraor.nextInt(this.deck.size());
            PlayingCard drawedCard = this.deck.get(index);
            this.deck.remove(drawedCard);
            placeholderPlayingCards.add(drawedCard);
        }
        return placeholderPlayingCards;
    } 
}