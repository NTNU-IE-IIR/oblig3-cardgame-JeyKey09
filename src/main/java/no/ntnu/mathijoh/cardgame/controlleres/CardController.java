package no.ntnu.mathijoh.cardgame.controlleres;

import java.util.Iterator;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import no.ntnu.mathijoh.cardgame.models.DeckOfCard;
import no.ntnu.mathijoh.cardgame.models.HandOfCards;
import no.ntnu.mathijoh.cardgame.models.PlayingCard;


public class CardController {

    private HandOfCards hand = new HandOfCards();
    private DeckOfCard deck = new DeckOfCard();

    @FXML
    private Button newHandButton;

    @FXML
    private Button drawButton;
    
    @FXML
    private Button checkHandButton;

    @FXML
    private FlowPane board;

    public void checkHand() {
    }
    
    @FXML
    private void drawCard(ActionEvent event) {
        List<PlayingCard> playingCards = this.deck.dealHand(1);
        this.hand.addCard(playingCards);
        Iterator<PlayingCard> it = playingCards.iterator();
        
        while(it.hasNext()) {
            PlayingCard card = it.next();
            board.getChildren().add(cardImageView(card));
        }
        
    }


    @FXML
    private void newHand(ActionEvent event) {
        List<PlayingCard> playingCards = this.deck.dealHand(1);
        this.hand.addCard(playingCards);
        Iterator<PlayingCard> it = playingCards.iterator();
        
        while(it.hasNext()) {
            PlayingCard card = it.next();
            board.getChildren().add(cardImageView(card));
        }
        
    }

    private ImageView cardImageView(PlayingCard card) {
        ImageView imageView = null;

        return imageView;
    }
}