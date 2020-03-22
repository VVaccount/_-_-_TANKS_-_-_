package com.project;

import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class Player {
    ImageView playerTank;
    EventHandler<KeyEvent> movement;
    Stage playerStage;
    Player(Stage stage) {
        playerStage = stage;
        playerTank = new ImageView(new Image(Tanks.class.getResourceAsStream("cursor.jpg"),25,25,false,true));
        playerTank.maxHeight(50);
        playerTank.maxWidth(50);
        playerTank.setX(100);
        playerTank.setY(100);

    }
    public void getPlayerEvents() {
        movement = event->{
            boolean moveUp = event.getCode() == KeyCode.UP;
            boolean moveDown = event.getCode() == KeyCode.DOWN;
            boolean moveLeft = event.getCode() == KeyCode.LEFT;
            boolean moveRight = event.getCode() == KeyCode.RIGHT;
            boolean exit = event.getCode() == KeyCode.ESCAPE;
            if(moveUp)
            {
                playerTank.setY(playerTank.getY() + 1);
                event.consume();
            }
            if(moveDown)
            {
                playerTank.setY(playerTank.getY() - 1);
                event.consume();
            }
            if(moveLeft)
            {
                playerTank.setX(playerTank.getX() - 1);
                event.consume();
            }
            if(moveRight)
            {
                playerTank.setX(playerTank.getX() + 1);
                event.consume();
            }
            if(exit)
            {
                playerStage.close();
                Platform.exit();
            }
        };
    }
}
