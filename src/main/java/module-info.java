module no.ntnu.mathijoh.cardgame {
    requires transitive javafx.graphics;
    requires javafx.controls;
    requires javafx.fxml;
    exports no.ntnu.mathijoh.cardgame;
    exports no.ntnu.mathijoh.cardgame.controller;
    opens no.ntnu.mathijoh.cardgame.controller to javafx.fxml;
}