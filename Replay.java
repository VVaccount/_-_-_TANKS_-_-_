package com.project;

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
import java.util.Scanner;

public class Replay {
    GridPane menuGridpane;
    EventHandler<KeyEvent> movement;
    ImageView cursor;
    Stage menuStage;
    File replaysFolder;
    File[] files;
    File replayFile;
    FileWriter replayWriter;
    FileReader replayReader;
    Scanner replayScanner;

    Replay() {
        replaysFolder = new File("src/com/project/replays");
        files = replaysFolder.listFiles();
        assert files != null;
        replayFile = new File("src/com/project/replays/" + "replay" + files.length + ".txt");
        try {
            replayFile.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            replayWriter = new FileWriter(replayFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    Replay(Stage stage, Scene scene) {
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
        menuGridpane.setAlignment(Pos.TOP_CENTER);
        Scene menuScene = new Scene(menuGridpane);
        menuScene.setFill(Color.BLACK);
        stage.setScene(menuScene);
        setMenuEvents(scene, this, stage);
    }

    public void setMenuEvents(Scene scene, Replay replay, Stage stage) {
        int[] rowIndex = {0};
        movement = new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                boolean moveToLastItem = keyEvent.getCode() == KeyCode.UP && rowIndex[0] == 0;
                boolean moveToNextItem = keyEvent.getCode() == KeyCode.DOWN && rowIndex[0] < files.length - 1;
                boolean moveToFirstItem = keyEvent.getCode() == KeyCode.DOWN && rowIndex[0] == files.length - 1;
                boolean moveToPreviousItem = keyEvent.getCode() == KeyCode.UP && rowIndex[0] > 0;
                boolean choice = keyEvent.getCode() == KeyCode.ENTER && files.length - 1 >= 0;
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
                if (choice) {
                    try {
                        replayReader = new FileReader("src/com/project/replays/" + files[rowIndex[0]].getName());
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                    replayScanner = new Scanner(replayReader);
                    Game game = new Game(menuStage, "src/com/project/replays/" + files[rowIndex[0]].getName(), replay);
                    game.getGameEvents(replay, 0);
                }
                if (exit) {
                    menuStage.setScene(scene);
                }
            }
        };
        menuStage.getScene().setOnKeyPressed(movement);
    }

    public void writeReplayFile(String string) {
        try {
            replayWriter.write(string);
            replayWriter.write("\n");
            replayWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String readReplayFile() {
        if (replayScanner.hasNext()) {
            return replayScanner.nextLine();
        }
        return null;
    }
}
