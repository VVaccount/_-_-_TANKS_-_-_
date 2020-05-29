package com.project;

import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
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

import java.io.*;

public class Replay {
    GridPane menuGridpane;
    EventHandler<KeyEvent> movement;
    ImageView cursor;
    Stage menuStage;
    File replaysFolder;
    File[] files;
    Replay(Stage stage) {
        replaysFolder = new File("src/com/project/replays");
        files = replaysFolder.listFiles();
        assert files != null;
        Label[] labels = new Label[files.length];
        menuStage = stage;
        menuGridpane = new GridPane();
        cursor = new ImageView(new Image(Tanks.class.getResourceAsStream("cursor.jpg"), 25, 25, false, true));
        cursor.getTransforms().add(new Rotate(90));
        cursor.setFocusTraversable(true);
        menuGridpane.setBackground(Background.EMPTY);
        menuGridpane.add(cursor, 0, 0);
        for (int rowIndex = 0; rowIndex < files.length; rowIndex++) {
            labels[rowIndex] = new Label(files[rowIndex].getName());
            labels[rowIndex].setFont(Font.font("Courier New", 20));
            labels[rowIndex].setPrefSize(500, 50);
            labels[rowIndex].setTextFill(Color.WHITE);
            labels[rowIndex].setAlignment(Pos.CENTER);
            menuGridpane.add(labels[rowIndex], 0, rowIndex);
        }
        menuGridpane.setAlignment(Pos.CENTER);
        Scene menuScene = new Scene(menuGridpane);
        menuScene.setFill(Color.BLACK);
        stage.setScene(menuScene);
        setMenuEvents();
    }
    public void setMenuEvents() {
        int[] rowIndex = {1};
        movement = new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                boolean moveToLastItem = keyEvent.getCode() == KeyCode.UP && rowIndex[0] == 0;
                boolean moveToNextItem = keyEvent.getCode() == KeyCode.DOWN && rowIndex[0] < files.length - 1;
                boolean moveToFirstItem = keyEvent.getCode() == KeyCode.DOWN && rowIndex[0] == files.length - 1;
                boolean moveToPreviousItem = keyEvent.getCode() == KeyCode.UP && rowIndex[0] > 0;
                boolean exit = keyEvent.getCode() == KeyCode.ESCAPE;
                if (moveToFirstItem) {
                    menuGridpane.getChildren().removeAll(cursor);
                    rowIndex[0] = 0;
                    menuGridpane.add(cursor, 0, rowIndex[0]);
                }
                if (moveToNextItem) {
                    menuGridpane.getChildren().removeAll(cursor);
                    rowIndex[0]++;
                    menuGridpane.add(cursor, 0, rowIndex[0]);
                }
                if (moveToLastItem) {
                    menuGridpane.getChildren().removeAll(cursor);
                    rowIndex[0] = files.length - 1;
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

//    public GridPane getMenuGridpane() {
//        return menuGridpane;
//    }
}