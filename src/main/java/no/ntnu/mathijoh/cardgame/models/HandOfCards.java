package no.ntnu.mathijoh.cardgame.models;

import java.util.ArrayList;
import java.util.List;

import java.util.Iterator;

public class HandOfCards {
    private ArrayList<PlayingCard> hand;

    public HandOfCards() {
        this.hand = new ArrayList<>();
    }

    public List<PlayingCard> getHand() {
        return hand;
    }

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
