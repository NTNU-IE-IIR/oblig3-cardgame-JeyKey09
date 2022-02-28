package no.ntnu.mathijoh.cardgame;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DeckOfCard {
    
    private final char[] suit = {'S','H','D','C'};
    private final int cardeachsuit = 13; 
    private Random randomgeneraor;
    private List<PlayingCard> deck;

    public DeckOfCard() {
        for (char cSuit : suit) {
            for(int i = 0; i < cardeachsuit ; i++) {
                deck.add(new PlayingCard(cSuit, i));
            }
        }
        randomgeneraor = new Random();
    }

    public List<PlayingCard> dealHand(int n) {
        List<PlayingCard> placeholderPlayingCards = new ArrayList<>();
        
        return placeholderPlayingCards;
    }  
}
