package com.example;

import java.util.HashMap;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class ClcTicTakToe {
    private final HashMap<String, Button> buttonMap = new HashMap<>();
    private String currentPlayer = "X";
    private int moveCounter = 0;

    @FXML
    private Label turnLabel;
    @FXML
    private Button button1, button2, button3, button4, button5, button6, button7, button8, button9, resetButton;

    @FXML
    private void initialize() {
        buttonMap.put("button1", button1);
        buttonMap.put("button2", button2);
        buttonMap.put("button3", button3);
        buttonMap.put("button4", button4);
        buttonMap.put("button5", button5);
        buttonMap.put("button6", button6);
        buttonMap.put("button7", button7);
        buttonMap.put("button8", button8);
        buttonMap.put("button9", button9);

        buttonMap.values().forEach(button -> button.setOnAction(this::handleButtonAction));
        resetButton.setOnAction(this::handleResetAction);

        turnLabel.setText("Turn: X");
        resetButton.setVisible(false);
    }

    @FXML
    private void handleButtonAction(ActionEvent event) {
        Button clickedButton = (Button) event.getSource();

        clickedButton.setText(currentPlayer);
        clickedButton.setDisable(true);
        moveCounter++;

        if (isWinner()) {
            turnLabel.setText("Winner: " + currentPlayer);
            endGame();
        } else if (moveCounter == 9) {
            turnLabel.setText("Draw!");
            endGame();
        } else {
            togglePlayer();
            turnLabel.setText("Turn: " + currentPlayer);
        }
    }

    private boolean isWinner() {
        String[][] winPatterns = {
            {"button1", "button2", "button3"},
            {"button4", "button5", "button6"},
            {"button7", "button8", "button9"},
            {"button1", "button4", "button7"},
            {"button2", "button5", "button8"},
            {"button3", "button6", "button9"},
            {"button1", "button5", "button9"},
            {"button3", "button5", "button7"}
        };

        for (String[] pattern : winPatterns) {
            if (buttonMap.get(pattern[0]).getText().equals(currentPlayer) &&
                buttonMap.get(pattern[1]).getText().equals(currentPlayer) &&
                buttonMap.get(pattern[2]).getText().equals(currentPlayer)) {
                return true;
            }
        }
        return false;
    }

    private void endGame() {
        buttonMap.values().forEach(button -> button.setDisable(true));
        resetButton.setVisible(true);
    }

    private void togglePlayer() {
        currentPlayer = currentPlayer.equals("X") ? "O" : "X";
    }

    @FXML
    private void handleResetAction(ActionEvent event) {
        resetGame();
    }

    private void resetGame() {
        buttonMap.values().forEach(button -> {
            button.setText("");
            button.setDisable(false);
        });
        currentPlayer = "X";
        moveCounter = 0;
        turnLabel.setText("Turn: X");
        resetButton.setVisible(false);
    }
}
