package com.project;

import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Player {
    ImageView playerTank;
    EventHandler<KeyEvent> movement;
    Player(Group root) {
        playerTank = new ImageView(new Image(Tanks.class.getResourceAsStream("cursor.jpg"),25,25,false,true));
        playerTank.setX(624);
        playerTank.setY(364);
        root.getChildren().add(playerTank);
    }
    public void getPlayerEvents(Group root) {
        movement = new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                boolean moveUp = keyEvent.getCode() == KeyCode.UP;
                boolean moveDown = keyEvent.getCode() == KeyCode.DOWN;
                boolean moveLeft = keyEvent.getCode() == KeyCode.LEFT;
                boolean moveRight = keyEvent.getCode() == KeyCode.RIGHT;
                boolean exit = keyEvent.getCode() == KeyCode.ESCAPE;
                if(moveUp)
                {
                    root.getChildren().remove(playerTank);
                    playerTank.setY(playerTank.getY() - 15);
                    root.getChildren().add(playerTank);
                    keyEvent.consume();
                }
                if(moveDown)
                {
                    root.getChildren().remove(playerTank);
                    playerTank.setY(playerTank.getY() + 15);
                    root.getChildren().add(playerTank);
                    keyEvent.consume();
                }
                if(moveLeft)
                {
                    root.getChildren().remove(playerTank);
                    playerTank.setX(playerTank.getX() - 15);
                    root.getChildren().add(playerTank);
                    keyEvent.consume();
                }
                if(moveRight)
                {
                    root.getChildren().remove(playerTank);
                    playerTank.setX(playerTank.getX() + 15);
                    root.getChildren().add(playerTank);
                    keyEvent.consume();
                }
                if(exit)
                {
                    Platform.exit();
                }
            }
        };
        root.getScene().addEventHandler(KeyEvent.KEY_PRESSED,movement);
    }
}
