package com.project;

import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Game {
    Scene gameScene;
    boolean gameIsRunning = false;
    Player player;
    Group root;
    Game(Stage stage) {
        root = new Group();
        gameScene = new Scene(root);
        player = new Player(root);
        gameScene.setFill(Color.GREEN);
        stage.setScene(gameScene);
        stage.show();
    }
    public void getGameEvents() {
        player.getPlayerEvents(root);
    }
    public void setGameIsRunning(){
        gameIsRunning = true;
    }
}