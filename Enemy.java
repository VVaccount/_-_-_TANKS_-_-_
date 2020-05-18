package com.project;

import javafx.event.EventHandler;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;

import java.util.ArrayList;

public class Enemy {
    ImageView enemyTank;
    ArrayList<ImageView> shells;
    double offsetX;
    double offsetY;
    double enemyOffsetX;
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
    Player player;

    Enemy(Group root, Player player) {
        shells = new ArrayList<>();
        offsetX = 384;
        offsetY = 0;
        enemyTank = new ImageView(new Image(Tanks.class.getResourceAsStream("sprites.jpg"), 800, 512, false, true));
        enemyTank.setViewport(new Rectangle2D(offsetX, offsetY, width, height));
        offsetX = 256;
        enemyTank.setX(570);
        enemyTank.setY(182);
        root.getChildren().add(enemyTank);
        up = false;
        down = false;
        left = false;
        right = false;
        upCollision = false;
        downCollision = false;
        leftCollision = false;
        rightCollision = false;
        this.player = player;
    }
    public void update(Collisions collisions, Group root) {
        int random = (int)(Math.random() * 7);
        if(random == 4) {
            randomDirection();
        }
        randomShoot();
        up = up && enemyTank.getY() > 182;
        down = down && enemyTank.getY() < 566;
        left = left && enemyTank.getX() > 442;
        right = right && enemyTank.getX() < 826;
        collisions.enemyTankCollisions(this, player);
        collisions.enemyShellsCollisions(this, root, player);
    }

    public void randomDirection(){
        int randomNumber = (int)(Math.random() * 4);
        if (randomNumber == 0){
            up = true;
            down = false;
            left = false;
            right = false;
        }
        if (randomNumber == 1){
            up = false;
            down = true;
            left = false;
            right = false;
        }
        if (randomNumber == 2){
            up = false;
            down = false;
            left = true;
            right = false;
        }
        if (randomNumber == 3){
            up = false;
            down = false;
            left = false;
            right = true;
        }
    }

    public void randomShoot(){
        int randomNumber = (int)(Math.random() * 10);
        if(randomNumber == 5){
            shooted = true;
        }
        else{
            shooted = false;
        }
    }

    public void move(){
        enemyOffsetX = offsetX + frame * 32;
        if (up) {
            if (frame == 0) {
                frame = 1;
            } else {
                frame = 0;
            }
            enemyTank.setY(enemyTank.getY() - 8);
            enemyTank.setViewport(new Rectangle2D(enemyOffsetX, offsetY, width, height));
        }
        if (down) {
            if (frame == 4) {
                frame = 5;
            } else {
                frame = 4;
            }
            enemyTank.setY(enemyTank.getY() + 8);
            enemyTank.setViewport(new Rectangle2D(enemyOffsetX, offsetY, width, height));
        }
        if (left) {
            if (frame == 2) {
                frame = 3;
            } else {
                frame = 2;
            }
            enemyTank.setX(enemyTank.getX() - 8);
            enemyTank.setViewport(new Rectangle2D(enemyOffsetX, offsetY, width, height));
        }
        if (right) {
            if (frame == 6) {
                frame = 7;
            } else {
                frame = 6;
            }
            enemyTank.setX(enemyTank.getX() + 8);
            enemyTank.setViewport(new Rectangle2D(enemyOffsetX, offsetY, width, height));
        }
    }
}
