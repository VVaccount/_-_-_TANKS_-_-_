package com.project;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Game {
    Stage gameStage;
    Scene gameScene;
    boolean gameIsRunning = false;
    Player player;
    Game() {
        player = new Player(gameStage);
        gameStage = new Stage();
        gameScene = new Scene(new Group(player.playerTank));
        gameScene.setFill(Color.BLACK);
        gameStage.setScene(gameScene);
        gameStage.getIcons().add(new Image(Tanks.class.getResourceAsStream("tank.jpg")));
        gameStage.setWidth(1920);
        gameStage.setHeight(1080);
        gameStage.centerOnScreen();
        gameStage.setResizable(false);
        gameStage.setTitle("TANKS");
    }
    public void getGameEvents()
    {
        player.getPlayerEvents();
    }
    public void setGameIsRunning(){
        gameIsRunning = true;
    }
}
