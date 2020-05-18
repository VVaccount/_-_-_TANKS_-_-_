package com.project;

import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;

public class Menu {
    GridPane menuGridpane;
    EventHandler<KeyEvent> movement;
    ImageView cursor;
    Stage menuStage;
    Game game;

    Menu(Stage stage) {
        menuStage = stage;
        menuGridpane = new GridPane();
        cursor = new ImageView(new Image(Tanks.class.getResourceAsStream("cursor.jpg"), 25, 25, false, true));
        Label tanksLabel = new Label("TANKS");
        Label startLabel = new Label("START");
        Label settingsLabel = new Label("SETTINGS");
        Label exitLabel = new Label("EXIT");
        cursor.getTransforms().add(new Rotate(90));
        cursor.setFocusTraversable(true);
        menuGridpane.setBackground(Background.EMPTY);
        tanksLabel.setFont(Font.font("Courier New", 40));
        startLabel.setFont(Font.font("Courier New", 20));
        settingsLabel.setFont(Font.font("Courier New", 20));
        exitLabel.setFont(Font.font("Courier New", 20));
        tanksLabel.setPrefSize(200, 50);
        startLabel.setPrefSize(200, 50);
        settingsLabel.setPrefSize(200, 50);
        exitLabel.setPrefSize(200, 50);
        tanksLabel.setAlignment(Pos.CENTER);
        tanksLabel.setTextFill(Color.RED);
        startLabel.setTextFill(Color.WHITE);
        settingsLabel.setTextFill(Color.WHITE);
        exitLabel.setTextFill(Color.WHITE);
        menuGridpane.add(cursor, 0, 1);
        menuGridpane.add(tanksLabel, 1, 0);
        menuGridpane.add(startLabel, 1, 1);
        menuGridpane.add(settingsLabel, 1, 2);
        menuGridpane.add(exitLabel, 1, 3);
        menuGridpane.setAlignment(Pos.CENTER);
    }

    public void setMenuEvents() {
        int[] rowIndex = {1};
        movement = new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                boolean start = keyEvent.getCode() == KeyCode.ENTER && rowIndex[0] == 1;
                boolean moveToLastItem = keyEvent.getCode() == KeyCode.UP && rowIndex[0] == 1;
                boolean moveToNextItem = keyEvent.getCode() == KeyCode.DOWN && rowIndex[0] < 3;
                boolean moveToFirstItem = keyEvent.getCode() == KeyCode.DOWN && rowIndex[0] == 3;
                boolean moveToPreviousItem = keyEvent.getCode() == KeyCode.UP && rowIndex[0] > 1;
                boolean exit = keyEvent.getCode() == KeyCode.ENTER && rowIndex[0] == 3;
                if (start) {
                    game = new Game(menuStage);
                    game.getGameEvents();
                }
                if (moveToFirstItem) {
                    menuGridpane.getChildren().removeAll(cursor);
                    rowIndex[0] = 1;
                    menuGridpane.add(cursor, 0, rowIndex[0]);
                }
                if (moveToNextItem) {
                    menuGridpane.getChildren().removeAll(cursor);
                    rowIndex[0]++;
                    menuGridpane.add(cursor, 0, rowIndex[0]);
                }
                if (moveToLastItem) {
                    menuGridpane.getChildren().removeAll(cursor);
                    rowIndex[0] = 3;
                    menuGridpane.add(cursor, 0, rowIndex[0]);
                }
                if (moveToPreviousItem) {
                    menuGridpane.getChildren().removeAll(cursor);
                    rowIndex[0]--;
                    menuGridpane.add(cursor, 0, rowIndex[0]);
                }
                if (exit) {
                    Platform.exit();
                }
            }
        };
        menuStage.getScene().setOnKeyPressed(movement);
    }

    public GridPane getMenuGridpane() {
        return menuGridpane;
    }
}