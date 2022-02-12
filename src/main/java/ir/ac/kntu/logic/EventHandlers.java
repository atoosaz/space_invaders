package ir.ac.kntu.logic;

import ir.ac.kntu.gui.Move;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

public class EventHandlers {

    public static Player newPlayerField(TextField textField, Player player) {
        Player player1 = Main.getInstance().gameGui.getPlayer();
        player1.setNamee(textField.getText());
        Main.getInstance().gameGui.setPlayer(player1);
        return player1;
    }



}
