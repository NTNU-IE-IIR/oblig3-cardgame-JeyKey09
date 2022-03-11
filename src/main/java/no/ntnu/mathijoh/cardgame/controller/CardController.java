package no.ntnu.mathijoh.cardgame.controller;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Text;
import no.ntnu.mathijoh.cardgame.models.DeckOfCard;
import no.ntnu.mathijoh.cardgame.models.HandOfCards;
import no.ntnu.mathijoh.cardgame.models.PlayingCard;

/**
 * CardController to be linked to the buttons and labels
 * @author Matias J. Kirkeby
 * @version 11-03-2022
 */
public class CardController {

    private int cardwidth = 79;
    private int cardheight = 123;

    private HandOfCards hand = new HandOfCards();
    private DeckOfCard deck = new DeckOfCard();

    @FXML
    private FlowPane board;

    @FXML
    private Text sumOfFaces;

    @FXML
    private Text cardsOfHearts;
    
    @FXML
    private Text queenOfSpades;
    
    @FXML
    private Text flush;

    @FXML
    private Text cardsLeft;
    
    /** 
     * Draws one card and adds the card to the Board and hand
     * @param event
     */
    @FXML
    private void drawCard(ActionEvent event) {
        List<PlayingCard> playingCards = this.deck.dealHand(1);
        this.hand.addCard(playingCards);
        Iterator<PlayingCard> it = playingCards.iterator();
        
        while(it.hasNext()) {
            PlayingCard card = it.next();
            board.getChildren().add(cardImageView(card));
        }
        updateInfo();
    }

    /**
     * Draws 5 card of the deck
     * @param event
     */
    @FXML
    private void newHand(ActionEvent event) {
        List<PlayingCard> playingCards = this.deck.dealHand(5);
        this.hand.addCard(playingCards);
        Iterator<PlayingCard> it = playingCards.iterator();
        
        while(it.hasNext()) {
            PlayingCard card = it.next();
            board.getChildren().add(cardImageView(card));
        }
        updateInfo();
    }

    /**
     * Resets the hand, board and deck
     * @param event
     */
    @FXML
    private void reset(ActionEvent event) {
        purgeBoard();
        hand = new HandOfCards();
        deck = new DeckOfCard();
        updateInfo();
    }

    /**
     * Gets a card and returns a image object of that card
     * @param card the playing card to fetch a image from
     * @return ImageView of the card
     */
    private ImageView cardImageView(PlayingCard card) {
        int yStart = 0;
        int xStart = cardwidth*card.getFace() - cardwidth;
        switch (card.getSuit()) {               
            case 'D':
                yStart = cardheight;
                break;
            case 'H':
                yStart = cardheight*2;
                break;
            case 'S':
                yStart = cardheight*2;
                break;
        }
        Image cardsImage = new Image(getClass().getResourceAsStream("/sample_images/card-deck-2.png"));
        ImageView cardImageView = new ImageView();
        Rectangle2D frame = new Rectangle2D(xStart,yStart,cardwidth,cardheight);
        cardImageView.setViewport(frame);
        cardImageView.setImage(cardsImage);
        cardImageView.setScaleX(0.9);
        cardImageView.setScaleY(0.9);
        return cardImageView;
    }

    /**
     * Purges the board of every card on it
     */
    private void purgeBoard(){
        board.getChildren().removeAll(board.getChildren());
    }

    /**
     * Updates every field on the bottom 
     */
    private void updateInfo() {
        Iterator<PlayingCard> it = this.hand.getHand().iterator();
        int sum = 0;
        String heartOfCards = "";
        boolean hasFlush = false;
        boolean hasQueenOfSpades = false; 
        int newCardsLeft = 52 - hand.getHand().size(); 
        HashMap<Character,Integer> flushControl = new HashMap<>();
        flushControl.put('C', 0);
        flushControl.put('D', 0);
        flushControl.put('H', 0);
        flushControl.put('S', 0);
        while(it.hasNext()) {
            
            PlayingCard card = it.next();
            sum += card.getFace();

            if (!hasQueenOfSpades && card.getFace() == 12) {
                hasQueenOfSpades = true;

            }
            
            if (!hasFlush) {
                flushControl.put(card.getSuit(), flushControl.get(card.getSuit()) + 1);
                hasFlush = (flushControl.get(card.getSuit()) == 5);
            }

            if (card.getSuit() == 'H') {
                heartOfCards += ("" + card.getFace() + card.getSuit() + " ");
            }
        }
        this.sumOfFaces.setText(String.valueOf(sum));
        this.cardsOfHearts.setText(heartOfCards);
        this.flush.setText(String.valueOf(hasFlush));
        this.queenOfSpades.setText(String.valueOf(hasQueenOfSpades));
        this.cardsLeft.setText(String.valueOf(newCardsLeft));
    }
}