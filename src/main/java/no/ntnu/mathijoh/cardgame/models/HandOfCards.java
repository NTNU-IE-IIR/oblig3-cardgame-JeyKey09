package no.ntnu.mathijoh.cardgame.models;

import java.util.ArrayList;
import java.util.List;

import java.util.Iterator;

/**
 * A hand of cards 
 * @author Matias J. Kirkeby
 * @version 11-03-2022
 */
public class HandOfCards {
    private ArrayList<PlayingCard> hand;

    /**
     * Creates a empty hand of cards
     */
    public HandOfCards() {
        this.hand = new ArrayList<>();
    }

    /**
     * Gets the cards in the hand
     * @return List of cards
     */
    public List<PlayingCard> getHand() {
        return hand;
    }

    /**
     * Adds a list of cards into the hand
     * @param cardList a List of cards
     * @throws IllegalArgumentException if the list is empty of null
     */
    public void addCard(List<PlayingCard> cardList) throws IllegalArgumentException {
        if (cardList == null || cardList.isEmpty()) {
            throw new IllegalArgumentException("The list can't be null or empty");
        }

        Iterator<PlayingCard> it = cardList.iterator();
        while (it.hasNext()) {
            this.hand.add(it.next());
        }
    }
}
