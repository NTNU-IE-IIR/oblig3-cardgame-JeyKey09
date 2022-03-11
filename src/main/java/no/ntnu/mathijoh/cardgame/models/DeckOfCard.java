package no.ntnu.mathijoh.cardgame.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class DeckOfCard {
    
    private final char[] suit = {'S','H','D','C'};
    private final int cardeachsuit = 13; 
    private Random randomgeneraor;
    private List<PlayingCard> deck;

    public DeckOfCard() {
        this.deck = new ArrayList<>();
        for (char cSuit : suit) {
            for(int i = 1; i <= cardeachsuit ; i++) {
                deck.add(new PlayingCard(cSuit, i));
            }
        }
        randomgeneraor = new Random();
    }

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