/**
 * Adding stuff for javafx...
 * I don't know what it does...
 * The program refuses to work without it
 */
module no.ntnu.mathijoh.cardgame {
    requires transitive javafx.graphics;
    requires javafx.controls;
    requires javafx.fxml;
    exports no.ntnu.mathijoh.cardgame;
    opens no.ntnu.mathijoh.cardgame.controlleres to javafx.fxml;
}