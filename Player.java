package com.project;

import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.util.*;

public class Player {
    ImageView playerTank;
    ArrayList<ImageView> shells;
    EventHandler<KeyEvent> movement, stop;
    double offsetX;
    double offsetY;
    double playerOffsetX;
    double width = 32;
    double height = 32;
    boolean up;
    boolean down;
    boolean left;
    boolean right;
    boolean upCollision;
    boolean downCollision;
    boolean leftCollision;
    boolean rightCollision;
    boolean shooted;
    int frame;
    Enemy enemy;

    Player(Group root) {
        shells = new ArrayList<>();
        offsetX = 0;
        offsetY = 0;
        playerTank = new ImageView(new Image(Tanks.class.getResourceAsStream("sprites.jpg"), 800, 512, false, true));
        playerTank.setViewport(new Rectangle2D(offsetX, offsetY, width, height));
        playerTank.setX(570);
        playerTank.setY(566);
        root.getChildren().add(playerTank);
        up = false;
        down = false;
        left = false;
        right = false;
        upCollision = false;
        downCollision = false;
        leftCollision = false;
        rightCollision = false;
        setPlayerEvents(root);
    }

    public void setPlayerEvents(Group root) {
        movement = new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                boolean moveUp = keyEvent.getCode().equals(KeyCode.UP);
                boolean moveDown = keyEvent.getCode().equals(KeyCode.DOWN);
                boolean moveLeft = keyEvent.getCode().equals(KeyCode.LEFT);
                boolean moveRight = keyEvent.getCode().equals(KeyCode.RIGHT);
                boolean shoot = keyEvent.getCode().equals(KeyCode.SPACE);
                boolean exit = keyEvent.getCode().equals(KeyCode.ESCAPE);
                if (moveUp) {
                    up = true;
                    down = false;
                    left = false;
                    right = false;
                }
                if (moveDown) {
                    up = false;
                    down = true;
                    left = false;
                    right = false;
                }
                if (moveLeft) {
                    up = false;
                    down = false;
                    left = true;
                    right = false;
                }
                if (moveRight) {
                    up = false;
                    down = false;
                    left = false;
                    right = true;
                }
                if (shoot) {
                    shooted = true;
                }
                if (exit) {
                    Platform.exit();
                }
            }
        };
        stop = new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                if (keyEvent.getCode().equals(KeyCode.UP)) {
                    up = false;
                }
                if (keyEvent.getCode().equals(KeyCode.DOWN)) {
                    down = false;
                }
                if (keyEvent.getCode().equals(KeyCode.LEFT)) {
                    left = false;
                }
                if (keyEvent.getCode().equals(KeyCode.RIGHT)) {
                    right = false;
                }
            }
        };
        root.getScene().setOnKeyPressed(movement);
        root.getScene().setOnKeyReleased(stop);
    }

    public void update(Collisions collisions, Group root) {
        up = up && playerTank.getY() > 182;
        down = down && playerTank.getY() < 566;
        left = left && playerTank.getX() > 442;
        right = right && playerTank.getX() < 826;
        collisions.tankCollisions(this, enemy);
        collisions.shellsCollisions(this, root, enemy);
    }

    public void move(){
        if (up) {
            if (frame == 0) {
                frame = 1;
            } else {
                frame = 0;
            }
            playerOffsetX = frame * 32;
            playerTank.setY(playerTank.getY() - 8);
            playerTank.setViewport(new Rectangle2D(playerOffsetX, offsetY, width, height));
        }
        if (down) {
            if (frame == 4) {
                frame = 5;
            } else {
                frame = 4;
            }
            playerOffsetX = frame * 32;
            playerTank.setY(playerTank.getY() + 8);
            playerTank.setViewport(new Rectangle2D(playerOffsetX, offsetY, width, height));
        }
        if (left) {
            if (frame == 2) {
                frame = 3;
            } else {
                frame = 2;
            }
            playerOffsetX = frame * 32;
            playerTank.setX(playerTank.getX() - 8);
            playerTank.setViewport(new Rectangle2D(playerOffsetX, offsetY, width, height));
        }
        if (right) {
            if (frame == 6) {
                frame = 7;
            } else {
                frame = 6;
            }
            playerOffsetX = frame * 32;
            playerTank.setX(playerTank.getX() + 8);
            playerTank.setViewport(new Rectangle2D(playerOffsetX, offsetY, width, height));
        }
    }

    public void setEnemy(Enemy enemy){
        this.enemy = enemy;
    }
}