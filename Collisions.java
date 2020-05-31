package com.project;

import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.ListIterator;

public class Collisions {
    Map map;
    boolean upPermission;
    boolean downPermission;
    boolean rightPermission;
    boolean leftPermission;
    boolean upCollision;
    boolean downCollision;
    boolean rightCollision;
    boolean leftCollision;

    Collisions(Map map) {
        this.map = map;
        upPermission = false;
        downPermission = false;
        rightPermission = false;
        leftPermission = false;
        upCollision = false;
        downCollision = false;
        rightCollision = false;
        leftCollision = false;
    }

    public void tankCollisions(Player player, Enemy enemy) {
        for (int brickNumber = 0; brickNumber < map.brickTiles.size(); brickNumber++) {
            if (player.playerTank.intersects(map.brickTiles.get(brickNumber).getX(), map.brickTiles.get(brickNumber).getY(), map.SIZE, map.SIZE)) {
                if (player.up && map.brickTiles.get(brickNumber).getY() < player.playerTank.getY() && map.brickTiles.get(brickNumber).getX() >= player.playerTank.getX() - 15 && map.brickTiles.get(brickNumber).getX() <= player.playerTank.getX() + 31) {
                    upCollision = true;
                    break;
                }
                if (player.down && map.brickTiles.get(brickNumber).getY() > player.playerTank.getY() && map.brickTiles.get(brickNumber).getX() >= player.playerTank.getX() - 15 && map.brickTiles.get(brickNumber).getX() <= player.playerTank.getX() + 31) {
                    downCollision = true;
                    break;
                }
                if (player.left && map.brickTiles.get(brickNumber).getX() < player.playerTank.getX() && map.brickTiles.get(brickNumber).getY() >= player.playerTank.getY() - 15 && map.brickTiles.get(brickNumber).getY() <= player.playerTank.getY() + 31) {
                    leftCollision = true;
                    break;
                }
                if (player.right && map.brickTiles.get(brickNumber).getX() > player.playerTank.getX() && map.brickTiles.get(brickNumber).getY() >= player.playerTank.getY() - 15 && map.brickTiles.get(brickNumber).getY() <= player.playerTank.getY() + 31) {
                    rightCollision = true;
                    break;
                }
            }
        }
        for (int waterNumber = 0; waterNumber < map.waterTiles.size(); waterNumber++) {
            if (player.playerTank.intersects(map.waterTiles.get(waterNumber).getX(), map.waterTiles.get(waterNumber).getY(), map.SIZE, map.SIZE)) {
                if (player.up && map.waterTiles.get(waterNumber).getY() < player.playerTank.getY() && map.waterTiles.get(waterNumber).getX() >= player.playerTank.getX() - 15 && map.waterTiles.get(waterNumber).getX() <= player.playerTank.getX() + 31) {
                    upCollision = true;
                    break;
                }
                if (player.down && map.waterTiles.get(waterNumber).getY() > player.playerTank.getY() && map.waterTiles.get(waterNumber).getX() >= player.playerTank.getX() - 15 && map.waterTiles.get(waterNumber).getX() <= player.playerTank.getX() + 31) {
                    downCollision = true;
                    break;
                }
                if (player.left && map.waterTiles.get(waterNumber).getX() < player.playerTank.getX() && map.waterTiles.get(waterNumber).getY() >= player.playerTank.getY() - 15 && map.waterTiles.get(waterNumber).getY() <= player.playerTank.getY() + 31) {
                    leftCollision = true;
                    break;
                }
                if (player.right && map.waterTiles.get(waterNumber).getX() > player.playerTank.getX() && map.waterTiles.get(waterNumber).getY() >= player.playerTank.getY() - 15 && map.waterTiles.get(waterNumber).getY() <= player.playerTank.getY() + 31) {
                    rightCollision = true;
                    break;
                }
            }
        }
        for (int metalNumber = 0; metalNumber < map.metalTiles.size(); metalNumber++) {
            if (player.playerTank.intersects(map.metalTiles.get(metalNumber).getX(), map.metalTiles.get(metalNumber).getY(), map.SIZE, map.SIZE)) {
                if (player.up && map.metalTiles.get(metalNumber).getY() < player.playerTank.getY() && map.metalTiles.get(metalNumber).getX() >= player.playerTank.getX() - 15 && map.metalTiles.get(metalNumber).getX() <= player.playerTank.getX() + 31) {
                    upCollision = true;
                    break;
                }
                if (player.down && map.metalTiles.get(metalNumber).getY() > player.playerTank.getY() && map.metalTiles.get(metalNumber).getX() >= player.playerTank.getX() - 15 && map.metalTiles.get(metalNumber).getX() <= player.playerTank.getX() + 31) {
                    downCollision = true;
                    break;
                }
                if (player.left && map.metalTiles.get(metalNumber).getX() < player.playerTank.getX() && map.metalTiles.get(metalNumber).getY() >= player.playerTank.getY() - 15 && map.metalTiles.get(metalNumber).getY() <= player.playerTank.getY() + 31) {
                    leftCollision = true;
                    break;
                }
                if (player.right && map.metalTiles.get(metalNumber).getX() > player.playerTank.getX() && map.metalTiles.get(metalNumber).getY() >= player.playerTank.getY() - 15 && map.metalTiles.get(metalNumber).getY() <= player.playerTank.getY() + 31) {
                    rightCollision = true;
                    break;
                }
            }
        }
        for (int iceNumber = 0; iceNumber < map.iceTiles.size(); iceNumber++) {
            if (player.playerTank.intersects(map.iceTiles.get(iceNumber).getX(), map.brickTiles.get(iceNumber).getY(), map.SIZE, map.SIZE)) {
                if (player.up && map.iceTiles.get(iceNumber).getY() < player.playerTank.getY() && map.iceTiles.get(iceNumber).getX() >= player.playerTank.getX() - 15 && map.iceTiles.get(iceNumber).getX() <= player.playerTank.getX() + 31) {
                    upCollision = true;
                    break;
                }
                if (player.down && map.iceTiles.get(iceNumber).getY() > player.playerTank.getY() && map.iceTiles.get(iceNumber).getX() >= player.playerTank.getX() - 15 && map.iceTiles.get(iceNumber).getX() <= player.playerTank.getX() + 31) {
                    downCollision = true;
                    break;
                }
                if (player.left && map.iceTiles.get(iceNumber).getX() < player.playerTank.getX() && map.iceTiles.get(iceNumber).getY() >= player.playerTank.getY() - 15 && map.iceTiles.get(iceNumber).getY() <= player.playerTank.getY() + 31) {
                    leftCollision = true;
                    break;
                }
                if (player.right && map.iceTiles.get(iceNumber).getX() > player.playerTank.getX() && map.iceTiles.get(iceNumber).getY() >= player.playerTank.getY() - 15 && map.iceTiles.get(iceNumber).getY() <= player.playerTank.getY() + 31) {
                    rightCollision = true;
                    break;
                }
            }
        }
        if (enemy.enemyTank.intersects(player.playerTank.getX(), player.playerTank.getY(), 32, 32)) {
            if (enemy.up) {
                upCollision = true;
            }
            if (enemy.down) {
                downCollision = true;
            }
            if (enemy.left) {
                leftCollision = true;
            }
            if (enemy.right) {
                rightCollision = true;
            }
        }
        if (player.up && !upCollision) {
            player.move();
        }
        if (player.down && !downCollision) {
            player.move();
        }
        if (player.left && !leftCollision) {
            player.move();
        }
        if (player.right && !rightCollision) {
            player.move();
        }
        upCollision = false;
        downCollision = false;
        leftCollision = false;
        rightCollision = false;
    }

    public void tankCollisions(Player player, Enemy enemy, Replay replay) {
        for (int brickNumber = 0; brickNumber < map.brickTiles.size(); brickNumber++) {
            if (player.playerTank.intersects(map.brickTiles.get(brickNumber).getX(), map.brickTiles.get(brickNumber).getY(), map.SIZE, map.SIZE)) {
                if (player.up && map.brickTiles.get(brickNumber).getY() < player.playerTank.getY() && map.brickTiles.get(brickNumber).getX() >= player.playerTank.getX() - 15 && map.brickTiles.get(brickNumber).getX() <= player.playerTank.getX() + 31) {
                    upCollision = true;
                    break;
                }
                if (player.down && map.brickTiles.get(brickNumber).getY() > player.playerTank.getY() && map.brickTiles.get(brickNumber).getX() >= player.playerTank.getX() - 15 && map.brickTiles.get(brickNumber).getX() <= player.playerTank.getX() + 31) {
                    downCollision = true;
                    break;
                }
                if (player.left && map.brickTiles.get(brickNumber).getX() < player.playerTank.getX() && map.brickTiles.get(brickNumber).getY() >= player.playerTank.getY() - 15 && map.brickTiles.get(brickNumber).getY() <= player.playerTank.getY() + 31) {
                    leftCollision = true;
                    break;
                }
                if (player.right && map.brickTiles.get(brickNumber).getX() > player.playerTank.getX() && map.brickTiles.get(brickNumber).getY() >= player.playerTank.getY() - 15 && map.brickTiles.get(brickNumber).getY() <= player.playerTank.getY() + 31) {
                    rightCollision = true;
                    break;
                }
            }
        }
        for (int waterNumber = 0; waterNumber < map.waterTiles.size(); waterNumber++) {
            if (player.playerTank.intersects(map.waterTiles.get(waterNumber).getX(), map.waterTiles.get(waterNumber).getY(), map.SIZE, map.SIZE)) {
                if (player.up && map.waterTiles.get(waterNumber).getY() < player.playerTank.getY() && map.waterTiles.get(waterNumber).getX() >= player.playerTank.getX() - 15 && map.waterTiles.get(waterNumber).getX() <= player.playerTank.getX() + 31) {
                    upCollision = true;
                    break;
                }
                if (player.down && map.waterTiles.get(waterNumber).getY() > player.playerTank.getY() && map.waterTiles.get(waterNumber).getX() >= player.playerTank.getX() - 15 && map.waterTiles.get(waterNumber).getX() <= player.playerTank.getX() + 31) {
                    downCollision = true;
                    break;
                }
                if (player.left && map.waterTiles.get(waterNumber).getX() < player.playerTank.getX() && map.waterTiles.get(waterNumber).getY() >= player.playerTank.getY() - 15 && map.waterTiles.get(waterNumber).getY() <= player.playerTank.getY() + 31) {
                    leftCollision = true;
                    break;
                }
                if (player.right && map.waterTiles.get(waterNumber).getX() > player.playerTank.getX() && map.waterTiles.get(waterNumber).getY() >= player.playerTank.getY() - 15 && map.waterTiles.get(waterNumber).getY() <= player.playerTank.getY() + 31) {
                    rightCollision = true;
                    break;
                }
            }
        }
        for (int metalNumber = 0; metalNumber < map.metalTiles.size(); metalNumber++) {
            if (player.playerTank.intersects(map.metalTiles.get(metalNumber).getX(), map.metalTiles.get(metalNumber).getY(), map.SIZE, map.SIZE)) {
                if (player.up && map.metalTiles.get(metalNumber).getY() < player.playerTank.getY() && map.metalTiles.get(metalNumber).getX() >= player.playerTank.getX() - 15 && map.metalTiles.get(metalNumber).getX() <= player.playerTank.getX() + 31) {
                    upCollision = true;
                    break;
                }
                if (player.down && map.metalTiles.get(metalNumber).getY() > player.playerTank.getY() && map.metalTiles.get(metalNumber).getX() >= player.playerTank.getX() - 15 && map.metalTiles.get(metalNumber).getX() <= player.playerTank.getX() + 31) {
                    downCollision = true;
                    break;
                }
                if (player.left && map.metalTiles.get(metalNumber).getX() < player.playerTank.getX() && map.metalTiles.get(metalNumber).getY() >= player.playerTank.getY() - 15 && map.metalTiles.get(metalNumber).getY() <= player.playerTank.getY() + 31) {
                    leftCollision = true;
                    break;
                }
                if (player.right && map.metalTiles.get(metalNumber).getX() > player.playerTank.getX() && map.metalTiles.get(metalNumber).getY() >= player.playerTank.getY() - 15 && map.metalTiles.get(metalNumber).getY() <= player.playerTank.getY() + 31) {
                    rightCollision = true;
                    break;
                }
            }
        }
        for (int iceNumber = 0; iceNumber < map.iceTiles.size(); iceNumber++) {
            if (player.playerTank.intersects(map.iceTiles.get(iceNumber).getX(), map.brickTiles.get(iceNumber).getY(), map.SIZE, map.SIZE)) {
                if (player.up && map.iceTiles.get(iceNumber).getY() < player.playerTank.getY() && map.iceTiles.get(iceNumber).getX() >= player.playerTank.getX() - 15 && map.iceTiles.get(iceNumber).getX() <= player.playerTank.getX() + 31) {
                    upCollision = true;
                    break;
                }
                if (player.down && map.iceTiles.get(iceNumber).getY() > player.playerTank.getY() && map.iceTiles.get(iceNumber).getX() >= player.playerTank.getX() - 15 && map.iceTiles.get(iceNumber).getX() <= player.playerTank.getX() + 31) {
                    downCollision = true;
                    break;
                }
                if (player.left && map.iceTiles.get(iceNumber).getX() < player.playerTank.getX() && map.iceTiles.get(iceNumber).getY() >= player.playerTank.getY() - 15 && map.iceTiles.get(iceNumber).getY() <= player.playerTank.getY() + 31) {
                    leftCollision = true;
                    break;
                }
                if (player.right && map.iceTiles.get(iceNumber).getX() > player.playerTank.getX() && map.iceTiles.get(iceNumber).getY() >= player.playerTank.getY() - 15 && map.iceTiles.get(iceNumber).getY() <= player.playerTank.getY() + 31) {
                    rightCollision = true;
                    break;
                }
            }
        }
        if (enemy.enemyTank.intersects(player.playerTank.getX(), player.playerTank.getY(), 32, 32)) {
            if (enemy.up) {
                upCollision = true;
            }
            if (enemy.down) {
                downCollision = true;
            }
            if (enemy.left) {
                leftCollision = true;
            }
            if (enemy.right) {
                rightCollision = true;
            }
        }
        if (player.up && !upCollision) {
            replay.writeReplayFile("PLAYER MOVED UP");
            player.move();
        }
        if (player.down && !downCollision) {
            replay.writeReplayFile("PLAYER MOVED DOWN");
            player.move();
        }
        if (player.left && !leftCollision) {
            replay.writeReplayFile("PLAYER MOVED LEFT");
            player.move();
        }
        if (player.right && !rightCollision) {
            replay.writeReplayFile("PLAYER MOVED RIGHT");
            player.move();
        }
        upCollision = false;
        downCollision = false;
        leftCollision = false;
        rightCollision = false;
    }

    public void shellsCollisions(Player player, Group root, Enemy enemy) {
        double upOffsetX = 640;
        double downOffsetX = 672;
        double leftOffsetX = 656;
        double rightOffsetX = 688;
        double offsetY = 200;
        boolean shootUp = (player.frame == 0 || player.frame == 1) && player.playerTank.getY() > 182;
        boolean shootDown = (player.frame == 4 || player.frame == 5) && player.playerTank.getY() < 566;
        boolean shootLeft = (player.frame == 2 || player.frame == 3) && player.playerTank.getX() > 442;
        boolean shootRight = (player.frame == 6 || player.frame == 7) && player.playerTank.getY() < 826;
        int brickNumber;
        if (player.shooted) {
            boolean shootUpCollision = false;
            boolean shootDownCollision = false;
            boolean shootLeftCollision = false;
            boolean shootRightCollision = false;
            player.shooted = false;
            if (shootUp || shootDown || shootLeft || shootRight) {
                for (brickNumber = 0; brickNumber < map.brickTiles.size(); brickNumber++) {
                    if (player.playerTank.intersects(map.brickTiles.get(brickNumber).getX(), map.brickTiles.get(brickNumber).getY(), map.SIZE, map.SIZE)) {
                        if (shootUp && map.brickTiles.get(brickNumber).getY() == player.playerTank.getY() - 16 && map.brickTiles.get(brickNumber).getX() >= player.playerTank.getX() - 7 && map.brickTiles.get(brickNumber).getX() <= player.playerTank.getX() + 23) {
                            shootUpCollision = true;
                            break;
                        }
                        if (shootDown && map.brickTiles.get(brickNumber).getY() == player.playerTank.getY() + 32 && map.brickTiles.get(brickNumber).getX() >= player.playerTank.getX() - 7 && map.brickTiles.get(brickNumber).getX() <= player.playerTank.getX() + 23) {
                            shootDownCollision = true;
                            break;
                        }
                        if (shootLeft && map.brickTiles.get(brickNumber).getX() == player.playerTank.getX() - 16 && map.brickTiles.get(brickNumber).getY() >= player.playerTank.getY() - 7 && map.brickTiles.get(brickNumber).getY() <= player.playerTank.getY() + 23) {
                            shootLeftCollision = true;
                            break;
                        }
                        if (shootRight && map.brickTiles.get(brickNumber).getX() == player.playerTank.getX() + 32 && map.brickTiles.get(brickNumber).getY() >= player.playerTank.getY() - 7 && map.brickTiles.get(brickNumber).getY() <= player.playerTank.getY() + 23) {
                            shootRightCollision = true;
                            break;
                        }
                    }
                }
                if (shootUp && shootUpCollision) {
                    deleteBrick(brickNumber);
                    return;
                }
                if (shootDown && shootDownCollision) {
                    deleteBrick(brickNumber);
                    return;
                }
                if (shootLeft && shootLeftCollision) {
                    deleteBrick(brickNumber);
                    return;
                }
                if (shootRight && shootRightCollision) {
                    deleteBrick(brickNumber);
                    return;
                }
                player.shells.add(new ImageView(new Image(Tanks.class.getResourceAsStream("imgonline-com-ua-Transparent-backgr-5KGwsJZpkwVzR71.png"), 800, 512, false, true)));
                if (shootUp) {
                    player.shells.get(player.shells.size() - 1).setViewport(new Rectangle2D(upOffsetX, offsetY, 16, 16));
                    player.shells.get(player.shells.size() - 1).setX(player.playerTank.getX() + 8);
                    player.shells.get(player.shells.size() - 1).setY(player.playerTank.getY() - 16);
                }
                if (shootDown) {
                    player.shells.get(player.shells.size() - 1).setViewport(new Rectangle2D(downOffsetX, offsetY, 16, 16));
                    player.shells.get(player.shells.size() - 1).setX(player.playerTank.getX() + 8);
                    player.shells.get(player.shells.size() - 1).setY(player.playerTank.getY() + 32);
                }
                if (shootLeft) {
                    player.shells.get(player.shells.size() - 1).setViewport(new Rectangle2D(leftOffsetX, offsetY, 16, 16));
                    player.shells.get(player.shells.size() - 1).setX(player.playerTank.getX() - 16);
                    player.shells.get(player.shells.size() - 1).setY(player.playerTank.getY() + 8);
                }
                if (shootRight) {
                    player.shells.get(player.shells.size() - 1).setViewport(new Rectangle2D(rightOffsetX, offsetY, 16, 16));
                    player.shells.get(player.shells.size() - 1).setX(player.playerTank.getX() + 32);
                    player.shells.get(player.shells.size() - 1).setY(player.playerTank.getY() + 8);
                }
                root.getChildren().add(player.shells.get(player.shells.size() - 1));
            }
        }
        ListIterator<ImageView> shellsIterator = player.shells.listIterator();
        ListIterator<ImageView> bricksIterator;
        ListIterator<ImageView> metalIterator;
        ImageView bufferShell;
        ImageView bufferBrick;
        ImageView bufferMetal;
        while (shellsIterator.hasNext()) {
            bufferShell = shellsIterator.next();
            bricksIterator = map.brickTiles.listIterator();
            metalIterator = map.metalTiles.listIterator();
            while (bricksIterator.hasNext()) {
                bufferBrick = bricksIterator.next();
                if (bufferShell.intersects(bufferBrick.getX(), bufferBrick.getY(), map.SIZE, map.SIZE)) {
                    if (bufferShell.getViewport().intersects(new Rectangle2D(upOffsetX, offsetY, map.SIZE, map.SIZE))) {
                        shootUp = false;
                    }
                    if (bufferShell.getViewport().intersects(new Rectangle2D(downOffsetX, offsetY, 16, 16))) {
                        shootDown = false;
                    }
                    if (bufferShell.getViewport().intersects(new Rectangle2D(leftOffsetX, offsetY, 16, 16))) {
                        shootLeft = false;
                    }
                    if (bufferShell.getViewport().intersects(new Rectangle2D(rightOffsetX, offsetY, 16, 16))) {
                        shootRight = false;
                    }
                    map.tiles.get(map.tiles.indexOf(bufferBrick)).setViewport(new Rectangle2D(map.SPACEOFFSETX, map.SPACEOFFSETY, map.SIZE, 16));
                    bufferShell.setViewport(new Rectangle2D(map.SPACEOFFSETX, map.SPACEOFFSETY, map.SIZE, 16));
                    root.getChildren().remove(bufferShell);
                    map.tileMap[(int) (bufferBrick.getY() - map.STARTY) / map.SIZE].insert((int) (bufferBrick.getX() - map.STARTX) / map.SIZE, map.SPACE);
                    if (bricksIterator.hasPrevious()) {
                        bricksIterator.previous();
                        bricksIterator.remove();
                    }
                    if (shellsIterator.hasPrevious()) {
                        shellsIterator.previous();
                        shellsIterator.remove();
                    }
                    break;
                }
                if (bufferShell.getViewport().intersects(new Rectangle2D(upOffsetX, offsetY, map.SIZE, map.SIZE))) {
                    shootUp = true;
                }
                if (bufferShell.getViewport().intersects(new Rectangle2D(downOffsetX, offsetY, 16, 16))) {
                    shootDown = true;
                }
                if (bufferShell.getViewport().intersects(new Rectangle2D(leftOffsetX, offsetY, 16, 16))) {
                    shootLeft = true;
                }
                if (bufferShell.getViewport().intersects(new Rectangle2D(rightOffsetX, offsetY, 16, 16))) {
                    shootRight = true;
                }
            }
            while (metalIterator.hasNext()) {
                bufferMetal = metalIterator.next();
                if (bufferShell.intersects(bufferMetal.getX(), bufferMetal.getY(), map.SIZE, map.SIZE)) {
                    if (bufferShell.getViewport().intersects(new Rectangle2D(upOffsetX, offsetY, map.SIZE, map.SIZE))) {
                        shootUp = false;
                    }
                    if (bufferShell.getViewport().intersects(new Rectangle2D(downOffsetX, offsetY, 16, 16))) {
                        shootDown = false;
                    }
                    if (bufferShell.getViewport().intersects(new Rectangle2D(leftOffsetX, offsetY, 16, 16))) {
                        shootLeft = false;
                    }
                    if (bufferShell.getViewport().intersects(new Rectangle2D(rightOffsetX, offsetY, 16, 16))) {
                        shootRight = false;
                    }
                    bufferShell.setViewport(new Rectangle2D(map.SPACEOFFSETX, map.SPACEOFFSETY, map.SIZE, 16));
                    root.getChildren().remove(bufferShell);
                    if (shellsIterator.hasPrevious()) {
                        shellsIterator.previous();
                        shellsIterator.remove();
                    }
                    break;
                }
                if (bufferShell.getViewport().intersects(new Rectangle2D(upOffsetX, offsetY, map.SIZE, map.SIZE))) {
                    shootUp = true;
                }
                if (bufferShell.getViewport().intersects(new Rectangle2D(downOffsetX, offsetY, 16, 16))) {
                    shootDown = true;
                }
                if (bufferShell.getViewport().intersects(new Rectangle2D(leftOffsetX, offsetY, 16, 16))) {
                    shootLeft = true;
                }
                if (bufferShell.getViewport().intersects(new Rectangle2D(rightOffsetX, offsetY, 16, 16))) {
                    shootRight = true;
                }
            }
            if (bufferShell.intersects(enemy.enemyTank.getX(), enemy.enemyTank.getY(), 32, 32)) {
                bufferShell.setViewport(new Rectangle2D(map.SPACEOFFSETX, map.SPACEOFFSETY, map.SIZE, 16));
                root.getChildren().remove(bufferShell);
                if (shellsIterator.hasPrevious()) {
                    shellsIterator.previous();
                    shellsIterator.remove();
                }
                root.getChildren().remove(enemy.enemyTank);
                enemy.alive = false;
                break;
            }
            if (bufferShell.getX() >= 842 || bufferShell.getX() <= 442 || bufferShell.getY() >= 582 || bufferShell.getY() <= 182) {
                if (bufferShell.getViewport().intersects(new Rectangle2D(upOffsetX, offsetY, map.SIZE, map.SIZE))) {
                    shootUp = false;
                }
                if (bufferShell.getViewport().intersects(new Rectangle2D(downOffsetX, offsetY, 16, 16))) {
                    shootDown = false;
                }
                if (bufferShell.getViewport().intersects(new Rectangle2D(leftOffsetX, offsetY, 16, 16))) {
                    shootLeft = false;
                }
                if (bufferShell.getViewport().intersects(new Rectangle2D(rightOffsetX, offsetY, 16, 16))) {
                    shootRight = false;
                }
                bufferShell.setViewport(new Rectangle2D(map.SPACEOFFSETX, map.SPACEOFFSETY, map.SIZE, 16));
                root.getChildren().remove(bufferShell);
                if (shellsIterator.hasPrevious()) {
                    shellsIterator.previous();
                    shellsIterator.remove();
                }
            }
            shootUp = shootUp && bufferShell.getViewport().intersects(new Rectangle2D(upOffsetX, offsetY, map.SIZE, map.SIZE)) && bufferShell.getY() > 182;
            if (shootUp) {
                bufferShell.setY(bufferShell.getY() - 10);
            }
            shootDown = shootDown && bufferShell.getViewport().intersects(new Rectangle2D(downOffsetX, offsetY, 16, 16)) && bufferShell.getY() < 582;
            if (shootDown) {
                bufferShell.setY(bufferShell.getY() + 10);
            }
            shootLeft = shootLeft && bufferShell.getViewport().intersects(new Rectangle2D(leftOffsetX, offsetY, 16, 16)) && bufferShell.getX() > 442;
            if (shootLeft) {
                bufferShell.setX(bufferShell.getX() - 10);
            }
            shootRight = shootRight && bufferShell.getViewport().intersects(new Rectangle2D(rightOffsetX, offsetY, 16, 16)) && bufferShell.getX() < 842;
            if (shootRight) {
                bufferShell.setX(bufferShell.getX() + 10);
            }
        }
    }

    public void shellsCollisions(Player player, Group root, Enemy enemy, Replay replay) {
        double upOffsetX = 640;
        double downOffsetX = 672;
        double leftOffsetX = 656;
        double rightOffsetX = 688;
        double offsetY = 200;
        boolean shootUp = (player.frame == 0 || player.frame == 1) && player.playerTank.getY() > 182;
        boolean shootDown = (player.frame == 4 || player.frame == 5) && player.playerTank.getY() < 566;
        boolean shootLeft = (player.frame == 2 || player.frame == 3) && player.playerTank.getX() > 442;
        boolean shootRight = (player.frame == 6 || player.frame == 7) && player.playerTank.getY() < 826;
        int brickNumber;
        if (player.shooted) {
            replay.writeReplayFile("PLAYER SHOOTED");
            boolean shootUpCollision = false;
            boolean shootDownCollision = false;
            boolean shootLeftCollision = false;
            boolean shootRightCollision = false;
            player.shooted = false;
            if (shootUp || shootDown || shootLeft || shootRight) {
                for (brickNumber = 0; brickNumber < map.brickTiles.size(); brickNumber++) {
                    if (player.playerTank.intersects(map.brickTiles.get(brickNumber).getX(), map.brickTiles.get(brickNumber).getY(), map.SIZE, map.SIZE)) {
                        if (shootUp && map.brickTiles.get(brickNumber).getY() == player.playerTank.getY() - 16 && map.brickTiles.get(brickNumber).getX() >= player.playerTank.getX() - 7 && map.brickTiles.get(brickNumber).getX() <= player.playerTank.getX() + 23) {
                            shootUpCollision = true;
                            break;
                        }
                        if (shootDown && map.brickTiles.get(brickNumber).getY() == player.playerTank.getY() + 32 && map.brickTiles.get(brickNumber).getX() >= player.playerTank.getX() - 7 && map.brickTiles.get(brickNumber).getX() <= player.playerTank.getX() + 23) {
                            shootDownCollision = true;
                            break;
                        }
                        if (shootLeft && map.brickTiles.get(brickNumber).getX() == player.playerTank.getX() - 16 && map.brickTiles.get(brickNumber).getY() >= player.playerTank.getY() - 7 && map.brickTiles.get(brickNumber).getY() <= player.playerTank.getY() + 23) {
                            shootLeftCollision = true;
                            break;
                        }
                        if (shootRight && map.brickTiles.get(brickNumber).getX() == player.playerTank.getX() + 32 && map.brickTiles.get(brickNumber).getY() >= player.playerTank.getY() - 7 && map.brickTiles.get(brickNumber).getY() <= player.playerTank.getY() + 23) {
                            shootRightCollision = true;
                            break;
                        }
                    }
                }
                if (shootUp && shootUpCollision) {
                    deleteBrick(brickNumber);
                    return;
                }
                if (shootDown && shootDownCollision) {
                    deleteBrick(brickNumber);
                    return;
                }
                if (shootLeft && shootLeftCollision) {
                    deleteBrick(brickNumber);
                    return;
                }
                if (shootRight && shootRightCollision) {
                    deleteBrick(brickNumber);
                    return;
                }
                player.shells.add(new ImageView(new Image(Tanks.class.getResourceAsStream("imgonline-com-ua-Transparent-backgr-5KGwsJZpkwVzR71.png"), 800, 512, false, true)));
                if (shootUp) {
                    player.shells.get(player.shells.size() - 1).setViewport(new Rectangle2D(upOffsetX, offsetY, 16, 16));
                    player.shells.get(player.shells.size() - 1).setX(player.playerTank.getX() + 8);
                    player.shells.get(player.shells.size() - 1).setY(player.playerTank.getY() - 16);
                }
                if (shootDown) {
                    player.shells.get(player.shells.size() - 1).setViewport(new Rectangle2D(downOffsetX, offsetY, 16, 16));
                    player.shells.get(player.shells.size() - 1).setX(player.playerTank.getX() + 8);
                    player.shells.get(player.shells.size() - 1).setY(player.playerTank.getY() + 32);
                }
                if (shootLeft) {
                    player.shells.get(player.shells.size() - 1).setViewport(new Rectangle2D(leftOffsetX, offsetY, 16, 16));
                    player.shells.get(player.shells.size() - 1).setX(player.playerTank.getX() - 16);
                    player.shells.get(player.shells.size() - 1).setY(player.playerTank.getY() + 8);
                }
                if (shootRight) {
                    player.shells.get(player.shells.size() - 1).setViewport(new Rectangle2D(rightOffsetX, offsetY, 16, 16));
                    player.shells.get(player.shells.size() - 1).setX(player.playerTank.getX() + 32);
                    player.shells.get(player.shells.size() - 1).setY(player.playerTank.getY() + 8);
                }
                root.getChildren().add(player.shells.get(player.shells.size() - 1));
            }
        }
        ListIterator<ImageView> shellsIterator = player.shells.listIterator();
        ListIterator<ImageView> bricksIterator;
        ListIterator<ImageView> metalIterator;
        ImageView bufferShell;
        ImageView bufferBrick;
        ImageView bufferMetal;
        while (shellsIterator.hasNext()) {
            bufferShell = shellsIterator.next();
            bricksIterator = map.brickTiles.listIterator();
            metalIterator = map.metalTiles.listIterator();
            while (bricksIterator.hasNext()) {
                bufferBrick = bricksIterator.next();
                if (bufferShell.intersects(bufferBrick.getX(), bufferBrick.getY(), map.SIZE, map.SIZE)) {
                    if (bufferShell.getViewport().intersects(new Rectangle2D(upOffsetX, offsetY, map.SIZE, map.SIZE))) {
                        shootUp = false;
                    }
                    if (bufferShell.getViewport().intersects(new Rectangle2D(downOffsetX, offsetY, 16, 16))) {
                        shootDown = false;
                    }
                    if (bufferShell.getViewport().intersects(new Rectangle2D(leftOffsetX, offsetY, 16, 16))) {
                        shootLeft = false;
                    }
                    if (bufferShell.getViewport().intersects(new Rectangle2D(rightOffsetX, offsetY, 16, 16))) {
                        shootRight = false;
                    }
                    map.tiles.get(map.tiles.indexOf(bufferBrick)).setViewport(new Rectangle2D(map.SPACEOFFSETX, map.SPACEOFFSETY, map.SIZE, 16));
                    bufferShell.setViewport(new Rectangle2D(map.SPACEOFFSETX, map.SPACEOFFSETY, map.SIZE, 16));
                    root.getChildren().remove(bufferShell);
                    map.tileMap[(int) (bufferBrick.getY() - map.STARTY) / map.SIZE].insert((int) (bufferBrick.getX() - map.STARTX) / map.SIZE, map.SPACE);
                    if (bricksIterator.hasPrevious()) {
                        bricksIterator.previous();
                        bricksIterator.remove();
                    }
                    if (shellsIterator.hasPrevious()) {
                        shellsIterator.previous();
                        shellsIterator.remove();
                    }
                    break;
                }
                if (bufferShell.getViewport().intersects(new Rectangle2D(upOffsetX, offsetY, map.SIZE, map.SIZE))) {
                    shootUp = true;
                }
                if (bufferShell.getViewport().intersects(new Rectangle2D(downOffsetX, offsetY, 16, 16))) {
                    shootDown = true;
                }
                if (bufferShell.getViewport().intersects(new Rectangle2D(leftOffsetX, offsetY, 16, 16))) {
                    shootLeft = true;
                }
                if (bufferShell.getViewport().intersects(new Rectangle2D(rightOffsetX, offsetY, 16, 16))) {
                    shootRight = true;
                }
            }
            while (metalIterator.hasNext()) {
                bufferMetal = metalIterator.next();
                if (bufferShell.intersects(bufferMetal.getX(), bufferMetal.getY(), map.SIZE, map.SIZE)) {
                    if (bufferShell.getViewport().intersects(new Rectangle2D(upOffsetX, offsetY, map.SIZE, map.SIZE))) {
                        shootUp = false;
                    }
                    if (bufferShell.getViewport().intersects(new Rectangle2D(downOffsetX, offsetY, 16, 16))) {
                        shootDown = false;
                    }
                    if (bufferShell.getViewport().intersects(new Rectangle2D(leftOffsetX, offsetY, 16, 16))) {
                        shootLeft = false;
                    }
                    if (bufferShell.getViewport().intersects(new Rectangle2D(rightOffsetX, offsetY, 16, 16))) {
                        shootRight = false;
                    }
                    bufferShell.setViewport(new Rectangle2D(map.SPACEOFFSETX, map.SPACEOFFSETY, map.SIZE, 16));
                    root.getChildren().remove(bufferShell);
                    if (shellsIterator.hasPrevious()) {
                        shellsIterator.previous();
                        shellsIterator.remove();
                    }
                    break;
                }
                if (bufferShell.getViewport().intersects(new Rectangle2D(upOffsetX, offsetY, map.SIZE, map.SIZE))) {
                    shootUp = true;
                }
                if (bufferShell.getViewport().intersects(new Rectangle2D(downOffsetX, offsetY, 16, 16))) {
                    shootDown = true;
                }
                if (bufferShell.getViewport().intersects(new Rectangle2D(leftOffsetX, offsetY, 16, 16))) {
                    shootLeft = true;
                }
                if (bufferShell.getViewport().intersects(new Rectangle2D(rightOffsetX, offsetY, 16, 16))) {
                    shootRight = true;
                }
            }
            if (bufferShell.intersects(enemy.enemyTank.getX(), enemy.enemyTank.getY(), 32, 32)) {
                bufferShell.setViewport(new Rectangle2D(map.SPACEOFFSETX, map.SPACEOFFSETY, map.SIZE, 16));
                root.getChildren().remove(bufferShell);
                if (shellsIterator.hasPrevious()) {
                    shellsIterator.previous();
                    shellsIterator.remove();
                }
                root.getChildren().remove(enemy.enemyTank);
                enemy.alive = false;
                break;
            }
            if (bufferShell.getX() >= 842 || bufferShell.getX() <= 442 || bufferShell.getY() >= 582 || bufferShell.getY() <= 182) {
                if (bufferShell.getViewport().intersects(new Rectangle2D(upOffsetX, offsetY, map.SIZE, map.SIZE))) {
                    shootUp = false;
                }
                if (bufferShell.getViewport().intersects(new Rectangle2D(downOffsetX, offsetY, 16, 16))) {
                    shootDown = false;
                }
                if (bufferShell.getViewport().intersects(new Rectangle2D(leftOffsetX, offsetY, 16, 16))) {
                    shootLeft = false;
                }
                if (bufferShell.getViewport().intersects(new Rectangle2D(rightOffsetX, offsetY, 16, 16))) {
                    shootRight = false;
                }
                bufferShell.setViewport(new Rectangle2D(map.SPACEOFFSETX, map.SPACEOFFSETY, map.SIZE, 16));
                root.getChildren().remove(bufferShell);
                if (shellsIterator.hasPrevious()) {
                    shellsIterator.previous();
                    shellsIterator.remove();
                }
            }
            shootUp = shootUp && bufferShell.getViewport().intersects(new Rectangle2D(upOffsetX, offsetY, map.SIZE, map.SIZE)) && bufferShell.getY() > 182;
            if (shootUp) {
                bufferShell.setY(bufferShell.getY() - 10);
            }
            shootDown = shootDown && bufferShell.getViewport().intersects(new Rectangle2D(downOffsetX, offsetY, 16, 16)) && bufferShell.getY() < 582;
            if (shootDown) {
                bufferShell.setY(bufferShell.getY() + 10);
            }
            shootLeft = shootLeft && bufferShell.getViewport().intersects(new Rectangle2D(leftOffsetX, offsetY, 16, 16)) && bufferShell.getX() > 442;
            if (shootLeft) {
                bufferShell.setX(bufferShell.getX() - 10);
            }
            shootRight = shootRight && bufferShell.getViewport().intersects(new Rectangle2D(rightOffsetX, offsetY, 16, 16)) && bufferShell.getX() < 842;
            if (shootRight) {
                bufferShell.setX(bufferShell.getX() + 10);
            }
        }
    }

    public void enemyTankCollisions(Enemy enemy, Player player) {
        for (int brickNumber = 0; brickNumber < map.brickTiles.size(); brickNumber++) {
            if (enemy.enemyTank.intersects(map.brickTiles.get(brickNumber).getX(), map.brickTiles.get(brickNumber).getY(), map.SIZE, map.SIZE)) {
                if (enemy.up && map.brickTiles.get(brickNumber).getY() < enemy.enemyTank.getY() && map.brickTiles.get(brickNumber).getX() >= enemy.enemyTank.getX() - 15 && map.brickTiles.get(brickNumber).getX() <= enemy.enemyTank.getX() + 31) {
                    upCollision = true;
                    break;
                }
                if (enemy.down && map.brickTiles.get(brickNumber).getY() > enemy.enemyTank.getY() && map.brickTiles.get(brickNumber).getX() >= enemy.enemyTank.getX() - 15 && map.brickTiles.get(brickNumber).getX() <= enemy.enemyTank.getX() + 31) {
                    downCollision = true;
                    break;
                }
                if (enemy.left && map.brickTiles.get(brickNumber).getX() < enemy.enemyTank.getX() && map.brickTiles.get(brickNumber).getY() >= enemy.enemyTank.getY() - 15 && map.brickTiles.get(brickNumber).getY() <= enemy.enemyTank.getY() + 31) {
                    leftCollision = true;
                    break;
                }
                if (enemy.right && map.brickTiles.get(brickNumber).getX() > enemy.enemyTank.getX() && map.brickTiles.get(brickNumber).getY() >= enemy.enemyTank.getY() - 15 && map.brickTiles.get(brickNumber).getY() <= enemy.enemyTank.getY() + 31) {
                    rightCollision = true;
                    break;
                }
            }
        }
        for (int waterNumber = 0; waterNumber < map.waterTiles.size(); waterNumber++) {
            if (enemy.enemyTank.intersects(map.waterTiles.get(waterNumber).getX(), map.waterTiles.get(waterNumber).getY(), map.SIZE, map.SIZE)) {
                if (enemy.up && map.waterTiles.get(waterNumber).getY() < enemy.enemyTank.getY() && map.waterTiles.get(waterNumber).getX() >= enemy.enemyTank.getX() - 15 && map.waterTiles.get(waterNumber).getX() <= enemy.enemyTank.getX() + 31) {
                    upCollision = true;
                    break;
                }
                if (enemy.down && map.waterTiles.get(waterNumber).getY() > enemy.enemyTank.getY() && map.waterTiles.get(waterNumber).getX() >= enemy.enemyTank.getX() - 15 && map.waterTiles.get(waterNumber).getX() <= enemy.enemyTank.getX() + 31) {
                    downCollision = true;
                    break;
                }
                if (enemy.left && map.waterTiles.get(waterNumber).getX() < enemy.enemyTank.getX() && map.waterTiles.get(waterNumber).getY() >= enemy.enemyTank.getY() - 15 && map.waterTiles.get(waterNumber).getY() <= enemy.enemyTank.getY() + 31) {
                    leftCollision = true;
                    break;
                }
                if (enemy.right && map.waterTiles.get(waterNumber).getX() > enemy.enemyTank.getX() && map.waterTiles.get(waterNumber).getY() >= enemy.enemyTank.getY() - 15 && map.waterTiles.get(waterNumber).getY() <= enemy.enemyTank.getY() + 31) {
                    rightCollision = true;
                    break;
                }
            }
        }
        for (int metalNumber = 0; metalNumber < map.metalTiles.size(); metalNumber++) {
            if (enemy.enemyTank.intersects(map.metalTiles.get(metalNumber).getX(), map.metalTiles.get(metalNumber).getY(), map.SIZE, map.SIZE)) {
                if (enemy.up && map.metalTiles.get(metalNumber).getY() < enemy.enemyTank.getY() && map.metalTiles.get(metalNumber).getX() >= enemy.enemyTank.getX() - 15 && map.metalTiles.get(metalNumber).getX() <= enemy.enemyTank.getX() + 31) {
                    upCollision = true;
                    break;
                }
                if (enemy.down && map.metalTiles.get(metalNumber).getY() > enemy.enemyTank.getY() && map.metalTiles.get(metalNumber).getX() >= enemy.enemyTank.getX() - 15 && map.metalTiles.get(metalNumber).getX() <= enemy.enemyTank.getX() + 31) {
                    downCollision = true;
                    break;
                }
                if (enemy.left && map.metalTiles.get(metalNumber).getX() < enemy.enemyTank.getX() && map.metalTiles.get(metalNumber).getY() >= enemy.enemyTank.getY() - 15 && map.metalTiles.get(metalNumber).getY() <= enemy.enemyTank.getY() + 31) {
                    leftCollision = true;
                    break;
                }
                if (enemy.right && map.metalTiles.get(metalNumber).getX() > enemy.enemyTank.getX() && map.metalTiles.get(metalNumber).getY() >= enemy.enemyTank.getY() - 15 && map.metalTiles.get(metalNumber).getY() <= enemy.enemyTank.getY() + 31) {
                    rightCollision = true;
                    break;
                }
            }
        }
        for (int iceNumber = 0; iceNumber < map.iceTiles.size(); iceNumber++) {
            if (enemy.enemyTank.intersects(map.iceTiles.get(iceNumber).getX(), map.brickTiles.get(iceNumber).getY(), map.SIZE, map.SIZE)) {
                if (enemy.up && map.iceTiles.get(iceNumber).getY() < enemy.enemyTank.getY() && map.iceTiles.get(iceNumber).getX() >= enemy.enemyTank.getX() - 15 && map.iceTiles.get(iceNumber).getX() <= enemy.enemyTank.getX() + 31) {
                    upCollision = true;
                    break;
                }
                if (enemy.down && map.iceTiles.get(iceNumber).getY() > enemy.enemyTank.getY() && map.iceTiles.get(iceNumber).getX() >= enemy.enemyTank.getX() - 15 && map.iceTiles.get(iceNumber).getX() <= enemy.enemyTank.getX() + 31) {
                    downCollision = true;
                    break;
                }
                if (enemy.left && map.iceTiles.get(iceNumber).getX() < enemy.enemyTank.getX() && map.iceTiles.get(iceNumber).getY() >= enemy.enemyTank.getY() - 15 && map.iceTiles.get(iceNumber).getY() <= enemy.enemyTank.getY() + 31) {
                    leftCollision = true;
                    break;
                }
                if (enemy.right && map.iceTiles.get(iceNumber).getX() > enemy.enemyTank.getX() && map.iceTiles.get(iceNumber).getY() >= enemy.enemyTank.getY() - 15 && map.iceTiles.get(iceNumber).getY() <= enemy.enemyTank.getY() + 31) {
                    rightCollision = true;
                    break;
                }
            }
        }
        if (enemy.enemyTank.intersects(player.playerTank.getX(), player.playerTank.getY(), 32, 32)) {
            if (enemy.up) {
                upCollision = true;
            }
            if (enemy.down) {
                downCollision = true;
            }
            if (enemy.left) {
                leftCollision = true;
            }
            if (enemy.right) {
                rightCollision = true;
            }
        }
        if (enemy.up && !upCollision) {
            enemy.move();
        }
        if (enemy.down && !downCollision) {
            enemy.move();
        }
        if (enemy.left && !leftCollision) {
            enemy.move();
        }
        if (enemy.right && !rightCollision) {
            enemy.move();
        }
        upCollision = false;
        downCollision = false;
        leftCollision = false;
        rightCollision = false;
    }

    public void enemyTankCollisions(Enemy enemy, Player player, Replay replay) {
        for (int brickNumber = 0; brickNumber < map.brickTiles.size(); brickNumber++) {
            if (enemy.enemyTank.intersects(map.brickTiles.get(brickNumber).getX(), map.brickTiles.get(brickNumber).getY(), map.SIZE, map.SIZE)) {
                if (enemy.up && map.brickTiles.get(brickNumber).getY() < enemy.enemyTank.getY() && map.brickTiles.get(brickNumber).getX() >= enemy.enemyTank.getX() - 15 && map.brickTiles.get(brickNumber).getX() <= enemy.enemyTank.getX() + 31) {
                    upCollision = true;
                    break;
                }
                if (enemy.down && map.brickTiles.get(brickNumber).getY() > enemy.enemyTank.getY() && map.brickTiles.get(brickNumber).getX() >= enemy.enemyTank.getX() - 15 && map.brickTiles.get(brickNumber).getX() <= enemy.enemyTank.getX() + 31) {
                    downCollision = true;
                    break;
                }
                if (enemy.left && map.brickTiles.get(brickNumber).getX() < enemy.enemyTank.getX() && map.brickTiles.get(brickNumber).getY() >= enemy.enemyTank.getY() - 15 && map.brickTiles.get(brickNumber).getY() <= enemy.enemyTank.getY() + 31) {
                    leftCollision = true;
                    break;
                }
                if (enemy.right && map.brickTiles.get(brickNumber).getX() > enemy.enemyTank.getX() && map.brickTiles.get(brickNumber).getY() >= enemy.enemyTank.getY() - 15 && map.brickTiles.get(brickNumber).getY() <= enemy.enemyTank.getY() + 31) {
                    rightCollision = true;
                    break;
                }
            }
        }
        for (int waterNumber = 0; waterNumber < map.waterTiles.size(); waterNumber++) {
            if (enemy.enemyTank.intersects(map.waterTiles.get(waterNumber).getX(), map.waterTiles.get(waterNumber).getY(), map.SIZE, map.SIZE)) {
                if (enemy.up && map.waterTiles.get(waterNumber).getY() < enemy.enemyTank.getY() && map.waterTiles.get(waterNumber).getX() >= enemy.enemyTank.getX() - 15 && map.waterTiles.get(waterNumber).getX() <= enemy.enemyTank.getX() + 31) {
                    upCollision = true;
                    break;
                }
                if (enemy.down && map.waterTiles.get(waterNumber).getY() > enemy.enemyTank.getY() && map.waterTiles.get(waterNumber).getX() >= enemy.enemyTank.getX() - 15 && map.waterTiles.get(waterNumber).getX() <= enemy.enemyTank.getX() + 31) {
                    downCollision = true;
                    break;
                }
                if (enemy.left && map.waterTiles.get(waterNumber).getX() < enemy.enemyTank.getX() && map.waterTiles.get(waterNumber).getY() >= enemy.enemyTank.getY() - 15 && map.waterTiles.get(waterNumber).getY() <= enemy.enemyTank.getY() + 31) {
                    leftCollision = true;
                    break;
                }
                if (enemy.right && map.waterTiles.get(waterNumber).getX() > enemy.enemyTank.getX() && map.waterTiles.get(waterNumber).getY() >= enemy.enemyTank.getY() - 15 && map.waterTiles.get(waterNumber).getY() <= enemy.enemyTank.getY() + 31) {
                    rightCollision = true;
                    break;
                }
            }
        }
        for (int metalNumber = 0; metalNumber < map.metalTiles.size(); metalNumber++) {
            if (enemy.enemyTank.intersects(map.metalTiles.get(metalNumber).getX(), map.metalTiles.get(metalNumber).getY(), map.SIZE, map.SIZE)) {
                if (enemy.up && map.metalTiles.get(metalNumber).getY() < enemy.enemyTank.getY() && map.metalTiles.get(metalNumber).getX() >= enemy.enemyTank.getX() - 15 && map.metalTiles.get(metalNumber).getX() <= enemy.enemyTank.getX() + 31) {
                    upCollision = true;
                    break;
                }
                if (enemy.down && map.metalTiles.get(metalNumber).getY() > enemy.enemyTank.getY() && map.metalTiles.get(metalNumber).getX() >= enemy.enemyTank.getX() - 15 && map.metalTiles.get(metalNumber).getX() <= enemy.enemyTank.getX() + 31) {
                    downCollision = true;
                    break;
                }
                if (enemy.left && map.metalTiles.get(metalNumber).getX() < enemy.enemyTank.getX() && map.metalTiles.get(metalNumber).getY() >= enemy.enemyTank.getY() - 15 && map.metalTiles.get(metalNumber).getY() <= enemy.enemyTank.getY() + 31) {
                    leftCollision = true;
                    break;
                }
                if (enemy.right && map.metalTiles.get(metalNumber).getX() > enemy.enemyTank.getX() && map.metalTiles.get(metalNumber).getY() >= enemy.enemyTank.getY() - 15 && map.metalTiles.get(metalNumber).getY() <= enemy.enemyTank.getY() + 31) {
                    rightCollision = true;
                    break;
                }
            }
        }
        for (int iceNumber = 0; iceNumber < map.iceTiles.size(); iceNumber++) {
            if (enemy.enemyTank.intersects(map.iceTiles.get(iceNumber).getX(), map.brickTiles.get(iceNumber).getY(), map.SIZE, map.SIZE)) {
                if (enemy.up && map.iceTiles.get(iceNumber).getY() < enemy.enemyTank.getY() && map.iceTiles.get(iceNumber).getX() >= enemy.enemyTank.getX() - 15 && map.iceTiles.get(iceNumber).getX() <= enemy.enemyTank.getX() + 31) {
                    upCollision = true;
                    break;
                }
                if (enemy.down && map.iceTiles.get(iceNumber).getY() > enemy.enemyTank.getY() && map.iceTiles.get(iceNumber).getX() >= enemy.enemyTank.getX() - 15 && map.iceTiles.get(iceNumber).getX() <= enemy.enemyTank.getX() + 31) {
                    downCollision = true;
                    break;
                }
                if (enemy.left && map.iceTiles.get(iceNumber).getX() < enemy.enemyTank.getX() && map.iceTiles.get(iceNumber).getY() >= enemy.enemyTank.getY() - 15 && map.iceTiles.get(iceNumber).getY() <= enemy.enemyTank.getY() + 31) {
                    leftCollision = true;
                    break;
                }
                if (enemy.right && map.iceTiles.get(iceNumber).getX() > enemy.enemyTank.getX() && map.iceTiles.get(iceNumber).getY() >= enemy.enemyTank.getY() - 15 && map.iceTiles.get(iceNumber).getY() <= enemy.enemyTank.getY() + 31) {
                    rightCollision = true;
                    break;
                }
            }
        }
        if (enemy.enemyTank.intersects(player.playerTank.getX(), player.playerTank.getY(), 32, 32)) {
            if (enemy.up) {
                upCollision = true;
            }
            if (enemy.down) {
                downCollision = true;
            }
            if (enemy.left) {
                leftCollision = true;
            }
            if (enemy.right) {
                rightCollision = true;
            }
        }
        if (enemy.up && !upCollision) {
            replay.writeReplayFile("ENEMY MOVED UP");
            enemy.move();
        }
        if (enemy.down && !downCollision) {
            replay.writeReplayFile("ENEMY MOVED DOWN");
            enemy.move();
        }
        if (enemy.left && !leftCollision) {
            replay.writeReplayFile("ENEMY MOVED LEFT");
            enemy.move();
        }
        if (enemy.right && !rightCollision) {
            replay.writeReplayFile("ENEMY MOVED RIGHT");
            enemy.move();
        }
        upCollision = false;
        downCollision = false;
        leftCollision = false;
        rightCollision = false;
    }

    public void enemyShellsCollisions(Enemy enemy, Group root, Player player) {
        double upOffsetX = 640;
        double downOffsetX = 672;
        double leftOffsetX = 656;
        double rightOffsetX = 688;
        double offsetY = 200;
        boolean shootUp = (enemy.frame == 0 || enemy.frame == 1) && enemy.enemyTank.getY() > 182;
        boolean shootDown = (enemy.frame == 4 || enemy.frame == 5) && enemy.enemyTank.getY() < 566;
        boolean shootLeft = (enemy.frame == 2 || enemy.frame == 3) && enemy.enemyTank.getX() > 442;
        boolean shootRight = (enemy.frame == 6 || enemy.frame == 7) && enemy.enemyTank.getY() < 826;
        int brickNumber;
        if (enemy.shooted) {
            boolean shootUpCollision = false;
            boolean shootDownCollision = false;
            boolean shootLeftCollision = false;
            boolean shootRightCollision = false;
            enemy.shooted = false;
            if (shootUp || shootDown || shootLeft || shootRight) {
                for (brickNumber = 0; brickNumber < map.brickTiles.size(); brickNumber++) {
                    if (enemy.enemyTank.intersects(map.brickTiles.get(brickNumber).getX(), map.brickTiles.get(brickNumber).getY(), map.SIZE, map.SIZE)) {
                        if (shootUp && map.brickTiles.get(brickNumber).getY() == enemy.enemyTank.getY() - 16 && map.brickTiles.get(brickNumber).getX() >= enemy.enemyTank.getX() - 7 && map.brickTiles.get(brickNumber).getX() <= enemy.enemyTank.getX() + 23) {
                            shootUpCollision = true;
                            break;
                        }
                        if (shootDown && map.brickTiles.get(brickNumber).getY() == enemy.enemyTank.getY() + 32 && map.brickTiles.get(brickNumber).getX() >= enemy.enemyTank.getX() - 7 && map.brickTiles.get(brickNumber).getX() <= enemy.enemyTank.getX() + 23) {
                            shootDownCollision = true;
                            break;
                        }
                        if (shootLeft && map.brickTiles.get(brickNumber).getX() == enemy.enemyTank.getX() - 16 && map.brickTiles.get(brickNumber).getY() >= enemy.enemyTank.getY() - 7 && map.brickTiles.get(brickNumber).getY() <= enemy.enemyTank.getY() + 23) {
                            shootLeftCollision = true;
                            break;
                        }
                        if (shootRight && map.brickTiles.get(brickNumber).getX() == enemy.enemyTank.getX() + 32 && map.brickTiles.get(brickNumber).getY() >= enemy.enemyTank.getY() - 7 && map.brickTiles.get(brickNumber).getY() <= enemy.enemyTank.getY() + 23) {
                            shootRightCollision = true;
                            break;
                        }
                    }
                }
                if (shootUp && shootUpCollision) {
                    deleteBrick(brickNumber);
                    return;
                }
                if (shootDown && shootDownCollision) {
                    deleteBrick(brickNumber);
                    return;
                }
                if (shootLeft && shootLeftCollision) {
                    deleteBrick(brickNumber);
                    return;
                }
                if (shootRight && shootRightCollision) {
                    deleteBrick(brickNumber);
                    return;
                }
                enemy.shells.add(new ImageView(new Image(Tanks.class.getResourceAsStream("imgonline-com-ua-Transparent-backgr-5KGwsJZpkwVzR71.png"), 800, 512, false, true)));
                if (shootUp) {
                    enemy.shells.get(enemy.shells.size() - 1).setViewport(new Rectangle2D(upOffsetX, offsetY, 16, 16));
                    enemy.shells.get(enemy.shells.size() - 1).setX(enemy.enemyTank.getX() + 8);
                    enemy.shells.get(enemy.shells.size() - 1).setY(enemy.enemyTank.getY() - 16);
                }
                if (shootDown) {
                    enemy.shells.get(enemy.shells.size() - 1).setViewport(new Rectangle2D(downOffsetX, offsetY, 16, 16));
                    enemy.shells.get(enemy.shells.size() - 1).setX(enemy.enemyTank.getX() + 8);
                    enemy.shells.get(enemy.shells.size() - 1).setY(enemy.enemyTank.getY() + 32);
                }
                if (shootLeft) {
                    enemy.shells.get(enemy.shells.size() - 1).setViewport(new Rectangle2D(leftOffsetX, offsetY, 16, 16));
                    enemy.shells.get(enemy.shells.size() - 1).setX(enemy.enemyTank.getX() - 16);
                    enemy.shells.get(enemy.shells.size() - 1).setY(enemy.enemyTank.getY() + 8);
                }
                if (shootRight) {
                    enemy.shells.get(enemy.shells.size() - 1).setViewport(new Rectangle2D(rightOffsetX, offsetY, 16, 16));
                    enemy.shells.get(enemy.shells.size() - 1).setX(enemy.enemyTank.getX() + 32);
                    enemy.shells.get(enemy.shells.size() - 1).setY(enemy.enemyTank.getY() + 8);
                }
                root.getChildren().add(enemy.shells.get(enemy.shells.size() - 1));
            }
        }
        ListIterator<ImageView> shellsIterator = enemy.shells.listIterator();
        ListIterator<ImageView> bricksIterator;
        ListIterator<ImageView> metalIterator;
        ImageView bufferShell;
        ImageView bufferBrick;
        ImageView bufferMetal;
        while (shellsIterator.hasNext()) {
            bufferShell = shellsIterator.next();
            bricksIterator = map.brickTiles.listIterator();
            metalIterator = map.metalTiles.listIterator();
            while (bricksIterator.hasNext()) {
                bufferBrick = bricksIterator.next();
                if (bufferShell.intersects(bufferBrick.getX(), bufferBrick.getY(), map.SIZE, map.SIZE)) {
                    if (bufferShell.getViewport().intersects(new Rectangle2D(upOffsetX, offsetY, map.SIZE, map.SIZE))) {
                        shootUp = false;
                    }
                    if (bufferShell.getViewport().intersects(new Rectangle2D(downOffsetX, offsetY, 16, 16))) {
                        shootDown = false;
                    }
                    if (bufferShell.getViewport().intersects(new Rectangle2D(leftOffsetX, offsetY, 16, 16))) {
                        shootLeft = false;
                    }
                    if (bufferShell.getViewport().intersects(new Rectangle2D(rightOffsetX, offsetY, 16, 16))) {
                        shootRight = false;
                    }
                    bufferBrick.setViewport(new Rectangle2D(map.SPACEOFFSETX, map.SPACEOFFSETY, map.SIZE, 16));
                    bufferShell.setViewport(new Rectangle2D(map.SPACEOFFSETX, map.SPACEOFFSETY, map.SIZE, 16));
                    root.getChildren().remove(bufferShell);
                    map.tileMap[(int) (map.brickTiles.get(map.brickTiles.indexOf(bufferBrick)).getY() - map.STARTY) / map.SIZE].insert((int) (map.brickTiles.get(map.brickTiles.indexOf(bufferBrick)).getX() - map.STARTX) / map.SIZE, map.SPACE);
                    if (bricksIterator.hasPrevious()) {
                        bricksIterator.previous();
                        bricksIterator.remove();
                    }
                    if (shellsIterator.hasPrevious()) {
                        shellsIterator.previous();
                        shellsIterator.remove();
                    }
                    break;
                }
                if (bufferShell.getViewport().intersects(new Rectangle2D(upOffsetX, offsetY, map.SIZE, map.SIZE))) {
                    shootUp = true;
                }
                if (bufferShell.getViewport().intersects(new Rectangle2D(downOffsetX, offsetY, 16, 16))) {
                    shootDown = true;
                }
                if (bufferShell.getViewport().intersects(new Rectangle2D(leftOffsetX, offsetY, 16, 16))) {
                    shootLeft = true;
                }
                if (bufferShell.getViewport().intersects(new Rectangle2D(rightOffsetX, offsetY, 16, 16))) {
                    shootRight = true;
                }
            }
            while (metalIterator.hasNext()) {
                bufferMetal = metalIterator.next();
                if (bufferShell.intersects(bufferMetal.getX(), bufferMetal.getY(), map.SIZE, map.SIZE)) {
                    if (bufferShell.getViewport().intersects(new Rectangle2D(upOffsetX, offsetY, map.SIZE, map.SIZE))) {
                        shootUp = false;
                    }
                    if (bufferShell.getViewport().intersects(new Rectangle2D(downOffsetX, offsetY, 16, 16))) {
                        shootDown = false;
                    }
                    if (bufferShell.getViewport().intersects(new Rectangle2D(leftOffsetX, offsetY, 16, 16))) {
                        shootLeft = false;
                    }
                    if (bufferShell.getViewport().intersects(new Rectangle2D(rightOffsetX, offsetY, 16, 16))) {
                        shootRight = false;
                    }
                    bufferShell.setViewport(new Rectangle2D(map.SPACEOFFSETX, map.SPACEOFFSETY, map.SIZE, 16));
                    root.getChildren().remove(bufferShell);
                    if (shellsIterator.hasPrevious()) {
                        shellsIterator.previous();
                        shellsIterator.remove();
                    }
                    break;
                }
                if (bufferShell.getViewport().intersects(new Rectangle2D(upOffsetX, offsetY, map.SIZE, map.SIZE))) {
                    shootUp = true;
                }
                if (bufferShell.getViewport().intersects(new Rectangle2D(downOffsetX, offsetY, 16, 16))) {
                    shootDown = true;
                }
                if (bufferShell.getViewport().intersects(new Rectangle2D(leftOffsetX, offsetY, 16, 16))) {
                    shootLeft = true;
                }
                if (bufferShell.getViewport().intersects(new Rectangle2D(rightOffsetX, offsetY, 16, 16))) {
                    shootRight = true;
                }
            }
            if (bufferShell.intersects(player.playerTank.getX(), player.playerTank.getY(), 32, 32)) {
                bufferShell.setViewport(new Rectangle2D(map.SPACEOFFSETX, map.SPACEOFFSETY, map.SIZE, 16));
                root.getChildren().remove(bufferShell);
                if (shellsIterator.hasPrevious()) {
                    shellsIterator.previous();
                    shellsIterator.remove();
                }
                root.getChildren().remove(player.playerTank);
                break;
            }
            if (bufferShell.getX() >= 842 || bufferShell.getX() <= 442 || bufferShell.getY() >= 582 || bufferShell.getY() <= 182) {
                if (bufferShell.getViewport().intersects(new Rectangle2D(upOffsetX, offsetY, map.SIZE, map.SIZE))) {
                    shootUp = false;
                }
                if (bufferShell.getViewport().intersects(new Rectangle2D(downOffsetX, offsetY, 16, 16))) {
                    shootDown = false;
                }
                if (bufferShell.getViewport().intersects(new Rectangle2D(leftOffsetX, offsetY, 16, 16))) {
                    shootLeft = false;
                }
                if (bufferShell.getViewport().intersects(new Rectangle2D(rightOffsetX, offsetY, 16, 16))) {
                    shootRight = false;
                }
                bufferShell.setViewport(new Rectangle2D(map.SPACEOFFSETX, map.SPACEOFFSETY, map.SIZE, 16));
                root.getChildren().remove(bufferShell);
                if (shellsIterator.hasPrevious()) {
                    shellsIterator.previous();
                    shellsIterator.remove();
                }
                continue;
            }
            shootUp = shootUp && bufferShell.getViewport().intersects(new Rectangle2D(upOffsetX, offsetY, map.SIZE, map.SIZE)) && bufferShell.getY() > 182;
            if (shootUp) {
                bufferShell.setY(bufferShell.getY() - 10);
            }
            shootDown = shootDown && bufferShell.getViewport().intersects(new Rectangle2D(downOffsetX, offsetY, 16, 16)) && bufferShell.getY() < 582;
            if (shootDown) {
                bufferShell.setY(bufferShell.getY() + 10);
            }
            shootLeft = shootLeft && bufferShell.getViewport().intersects(new Rectangle2D(leftOffsetX, offsetY, 16, 16)) && bufferShell.getX() > 442;
            if (shootLeft) {
                bufferShell.setX(bufferShell.getX() - 10);
            }
            shootRight = shootRight && bufferShell.getViewport().intersects(new Rectangle2D(rightOffsetX, offsetY, 16, 16)) && bufferShell.getX() < 842;
            if (shootRight) {
                bufferShell.setX(bufferShell.getX() + 10);
            }
        }
    }

    public void enemyShellsCollisions(Enemy enemy, Group root, Player player, Replay replay) {
        double upOffsetX = 640;
        double downOffsetX = 672;
        double leftOffsetX = 656;
        double rightOffsetX = 688;
        double offsetY = 200;
        boolean shootUp = (enemy.frame == 0 || enemy.frame == 1) && enemy.enemyTank.getY() > 182;
        boolean shootDown = (enemy.frame == 4 || enemy.frame == 5) && enemy.enemyTank.getY() < 566;
        boolean shootLeft = (enemy.frame == 2 || enemy.frame == 3) && enemy.enemyTank.getX() > 442;
        boolean shootRight = (enemy.frame == 6 || enemy.frame == 7) && enemy.enemyTank.getY() < 826;
        int brickNumber;
        if (enemy.shooted) {
            replay.writeReplayFile("ENEMY SHOOTED");
            boolean shootUpCollision = false;
            boolean shootDownCollision = false;
            boolean shootLeftCollision = false;
            boolean shootRightCollision = false;
            enemy.shooted = false;
            if (shootUp || shootDown || shootLeft || shootRight) {
                for (brickNumber = 0; brickNumber < map.brickTiles.size(); brickNumber++) {
                    if (enemy.enemyTank.intersects(map.brickTiles.get(brickNumber).getX(), map.brickTiles.get(brickNumber).getY(), map.SIZE, map.SIZE)) {
                        if (shootUp && map.brickTiles.get(brickNumber).getY() == enemy.enemyTank.getY() - 16 && map.brickTiles.get(brickNumber).getX() >= enemy.enemyTank.getX() - 7 && map.brickTiles.get(brickNumber).getX() <= enemy.enemyTank.getX() + 23) {
                            shootUpCollision = true;
                            break;
                        }
                        if (shootDown && map.brickTiles.get(brickNumber).getY() == enemy.enemyTank.getY() + 32 && map.brickTiles.get(brickNumber).getX() >= enemy.enemyTank.getX() - 7 && map.brickTiles.get(brickNumber).getX() <= enemy.enemyTank.getX() + 23) {
                            shootDownCollision = true;
                            break;
                        }
                        if (shootLeft && map.brickTiles.get(brickNumber).getX() == enemy.enemyTank.getX() - 16 && map.brickTiles.get(brickNumber).getY() >= enemy.enemyTank.getY() - 7 && map.brickTiles.get(brickNumber).getY() <= enemy.enemyTank.getY() + 23) {
                            shootLeftCollision = true;
                            break;
                        }
                        if (shootRight && map.brickTiles.get(brickNumber).getX() == enemy.enemyTank.getX() + 32 && map.brickTiles.get(brickNumber).getY() >= enemy.enemyTank.getY() - 7 && map.brickTiles.get(brickNumber).getY() <= enemy.enemyTank.getY() + 23) {
                            shootRightCollision = true;
                            break;
                        }
                    }
                }
                if (shootUp && shootUpCollision) {
                    deleteBrick(brickNumber);
                    return;
                }
                if (shootDown && shootDownCollision) {
                    deleteBrick(brickNumber);
                    return;
                }
                if (shootLeft && shootLeftCollision) {
                    deleteBrick(brickNumber);
                    return;
                }
                if (shootRight && shootRightCollision) {
                    deleteBrick(brickNumber);
                    return;
                }
                enemy.shells.add(new ImageView(new Image(Tanks.class.getResourceAsStream("imgonline-com-ua-Transparent-backgr-5KGwsJZpkwVzR71.png"), 800, 512, false, true)));
                if (shootUp) {
                    enemy.shells.get(enemy.shells.size() - 1).setViewport(new Rectangle2D(upOffsetX, offsetY, 16, 16));
                    enemy.shells.get(enemy.shells.size() - 1).setX(enemy.enemyTank.getX() + 8);
                    enemy.shells.get(enemy.shells.size() - 1).setY(enemy.enemyTank.getY() - 16);
                }
                if (shootDown) {
                    enemy.shells.get(enemy.shells.size() - 1).setViewport(new Rectangle2D(downOffsetX, offsetY, 16, 16));
                    enemy.shells.get(enemy.shells.size() - 1).setX(enemy.enemyTank.getX() + 8);
                    enemy.shells.get(enemy.shells.size() - 1).setY(enemy.enemyTank.getY() + 32);
                }
                if (shootLeft) {
                    enemy.shells.get(enemy.shells.size() - 1).setViewport(new Rectangle2D(leftOffsetX, offsetY, 16, 16));
                    enemy.shells.get(enemy.shells.size() - 1).setX(enemy.enemyTank.getX() - 16);
                    enemy.shells.get(enemy.shells.size() - 1).setY(enemy.enemyTank.getY() + 8);
                }
                if (shootRight) {
                    enemy.shells.get(enemy.shells.size() - 1).setViewport(new Rectangle2D(rightOffsetX, offsetY, 16, 16));
                    enemy.shells.get(enemy.shells.size() - 1).setX(enemy.enemyTank.getX() + 32);
                    enemy.shells.get(enemy.shells.size() - 1).setY(enemy.enemyTank.getY() + 8);
                }
                root.getChildren().add(enemy.shells.get(enemy.shells.size() - 1));
            }
        }
        ListIterator<ImageView> shellsIterator = enemy.shells.listIterator();
        ListIterator<ImageView> bricksIterator;
        ListIterator<ImageView> metalIterator;
        ImageView bufferShell;
        ImageView bufferBrick;
        ImageView bufferMetal;
        while (shellsIterator.hasNext()) {
            bufferShell = shellsIterator.next();
            bricksIterator = map.brickTiles.listIterator();
            metalIterator = map.metalTiles.listIterator();
            while (bricksIterator.hasNext()) {
                bufferBrick = bricksIterator.next();
                if (bufferShell.intersects(bufferBrick.getX(), bufferBrick.getY(), map.SIZE, map.SIZE)) {
                    if (bufferShell.getViewport().intersects(new Rectangle2D(upOffsetX, offsetY, map.SIZE, map.SIZE))) {
                        shootUp = false;
                    }
                    if (bufferShell.getViewport().intersects(new Rectangle2D(downOffsetX, offsetY, 16, 16))) {
                        shootDown = false;
                    }
                    if (bufferShell.getViewport().intersects(new Rectangle2D(leftOffsetX, offsetY, 16, 16))) {
                        shootLeft = false;
                    }
                    if (bufferShell.getViewport().intersects(new Rectangle2D(rightOffsetX, offsetY, 16, 16))) {
                        shootRight = false;
                    }
                    bufferBrick.setViewport(new Rectangle2D(map.SPACEOFFSETX, map.SPACEOFFSETY, map.SIZE, 16));
                    bufferShell.setViewport(new Rectangle2D(map.SPACEOFFSETX, map.SPACEOFFSETY, map.SIZE, 16));
                    root.getChildren().remove(bufferShell);
                    map.tileMap[(int) (map.brickTiles.get(map.brickTiles.indexOf(bufferBrick)).getY() - map.STARTY) / map.SIZE].insert((int) (map.brickTiles.get(map.brickTiles.indexOf(bufferBrick)).getX() - map.STARTX) / map.SIZE, map.SPACE);
                    if (bricksIterator.hasPrevious()) {
                        bricksIterator.previous();
                        bricksIterator.remove();
                    }
                    if (shellsIterator.hasPrevious()) {
                        shellsIterator.previous();
                        shellsIterator.remove();
                    }
                    break;
                }
                if (bufferShell.getViewport().intersects(new Rectangle2D(upOffsetX, offsetY, map.SIZE, map.SIZE))) {
                    shootUp = true;
                }
                if (bufferShell.getViewport().intersects(new Rectangle2D(downOffsetX, offsetY, 16, 16))) {
                    shootDown = true;
                }
                if (bufferShell.getViewport().intersects(new Rectangle2D(leftOffsetX, offsetY, 16, 16))) {
                    shootLeft = true;
                }
                if (bufferShell.getViewport().intersects(new Rectangle2D(rightOffsetX, offsetY, 16, 16))) {
                    shootRight = true;
                }
            }
            while (metalIterator.hasNext()) {
                bufferMetal = metalIterator.next();
                if (bufferShell.intersects(bufferMetal.getX(), bufferMetal.getY(), map.SIZE, map.SIZE)) {
                    if (bufferShell.getViewport().intersects(new Rectangle2D(upOffsetX, offsetY, map.SIZE, map.SIZE))) {
                        shootUp = false;
                    }
                    if (bufferShell.getViewport().intersects(new Rectangle2D(downOffsetX, offsetY, 16, 16))) {
                        shootDown = false;
                    }
                    if (bufferShell.getViewport().intersects(new Rectangle2D(leftOffsetX, offsetY, 16, 16))) {
                        shootLeft = false;
                    }
                    if (bufferShell.getViewport().intersects(new Rectangle2D(rightOffsetX, offsetY, 16, 16))) {
                        shootRight = false;
                    }
                    bufferShell.setViewport(new Rectangle2D(map.SPACEOFFSETX, map.SPACEOFFSETY, map.SIZE, 16));
                    root.getChildren().remove(bufferShell);
                    if (shellsIterator.hasPrevious()) {
                        shellsIterator.previous();
                        shellsIterator.remove();
                    }
                    break;
                }
                if (bufferShell.getViewport().intersects(new Rectangle2D(upOffsetX, offsetY, map.SIZE, map.SIZE))) {
                    shootUp = true;
                }
                if (bufferShell.getViewport().intersects(new Rectangle2D(downOffsetX, offsetY, 16, 16))) {
                    shootDown = true;
                }
                if (bufferShell.getViewport().intersects(new Rectangle2D(leftOffsetX, offsetY, 16, 16))) {
                    shootLeft = true;
                }
                if (bufferShell.getViewport().intersects(new Rectangle2D(rightOffsetX, offsetY, 16, 16))) {
                    shootRight = true;
                }
            }
            if (bufferShell.intersects(player.playerTank.getX(), player.playerTank.getY(), 32, 32)) {
                bufferShell.setViewport(new Rectangle2D(map.SPACEOFFSETX, map.SPACEOFFSETY, map.SIZE, 16));
                root.getChildren().remove(bufferShell);
                if (shellsIterator.hasPrevious()) {
                    shellsIterator.previous();
                    shellsIterator.remove();
                }
                root.getChildren().remove(player.playerTank);
                break;
            }
            if (bufferShell.getX() >= 842 || bufferShell.getX() <= 442 || bufferShell.getY() >= 582 || bufferShell.getY() <= 182) {
                if (bufferShell.getViewport().intersects(new Rectangle2D(upOffsetX, offsetY, map.SIZE, map.SIZE))) {
                    shootUp = false;
                }
                if (bufferShell.getViewport().intersects(new Rectangle2D(downOffsetX, offsetY, 16, 16))) {
                    shootDown = false;
                }
                if (bufferShell.getViewport().intersects(new Rectangle2D(leftOffsetX, offsetY, 16, 16))) {
                    shootLeft = false;
                }
                if (bufferShell.getViewport().intersects(new Rectangle2D(rightOffsetX, offsetY, 16, 16))) {
                    shootRight = false;
                }
                bufferShell.setViewport(new Rectangle2D(map.SPACEOFFSETX, map.SPACEOFFSETY, map.SIZE, 16));
                root.getChildren().remove(bufferShell);
                if (shellsIterator.hasPrevious()) {
                    shellsIterator.previous();
                    shellsIterator.remove();
                }
                continue;
            }
            shootUp = shootUp && bufferShell.getViewport().intersects(new Rectangle2D(upOffsetX, offsetY, map.SIZE, map.SIZE)) && bufferShell.getY() > 182;
            if (shootUp) {
                bufferShell.setY(bufferShell.getY() - 10);
            }
            shootDown = shootDown && bufferShell.getViewport().intersects(new Rectangle2D(downOffsetX, offsetY, 16, 16)) && bufferShell.getY() < 582;
            if (shootDown) {
                bufferShell.setY(bufferShell.getY() + 10);
            }
            shootLeft = shootLeft && bufferShell.getViewport().intersects(new Rectangle2D(leftOffsetX, offsetY, 16, 16)) && bufferShell.getX() > 442;
            if (shootLeft) {
                bufferShell.setX(bufferShell.getX() - 10);
            }
            shootRight = shootRight && bufferShell.getViewport().intersects(new Rectangle2D(rightOffsetX, offsetY, 16, 16)) && bufferShell.getX() < 842;
            if (shootRight) {
                bufferShell.setX(bufferShell.getX() + 10);
            }
        }
    }

    public void deleteBrick(int brickNumber) {
        map.tiles.get(map.tiles.indexOf(map.brickTiles.get(brickNumber))).setViewport(new Rectangle2D(map.SPACEOFFSETX, map.SPACEOFFSETY, map.SIZE, 16));
        map.tileMap[(int) (map.brickTiles.get(brickNumber).getY() - map.STARTY) / map.SIZE].insert((int) (map.brickTiles.get(brickNumber).getX() - map.STARTX) / map.SIZE, map.SPACE);
        map.brickTiles.remove(brickNumber);
    }
}