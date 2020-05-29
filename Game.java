package com.project;

import javafx.animation.AnimationTimer;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Game {
    Scene gameScene;
    //boolean gameIsRunning;
    Collisions collisions;
    Player player;
    Enemy enemy;
    Group root;
    Map map;
    EnemyThreads enemyThreads;

    Game(Stage stage) {
        //gameIsRunning = true;
        root = new Group();
        map = new Map();
        collisions = new Collisions(map);
        gameScene = new Scene(root);
        //map.draw(root);
        player = new Player(root);
        enemy = new Enemy(root, player);
        enemyThreads = new EnemyThreads(enemy, root, collisions);
        player.setEnemy(enemy);
        map.draw(root);
        gameScene.setFill(Color.BLACK);
        stage.setScene(gameScene);
    }

    public void getGameEvents() {
        //Thread enemyThread = new Thread(new EnemyThreads(enemy, root, collisions));
        //enemyThread.start();
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                //map.update(root);
                player.update(collisions, root);
                enemyThreads.enemyUpdate();
            }
        };
        timer.start();
    }
//    void restartGame() {
//        deadEnemies = 0;
//        tank.sprite.setPosition(GameMapView.tankStartPos[0], GameMapView.tankStartPos[1]);
//        tank.currentTankPosX = GameMapView.tankStartPos[0];
//        tank.currentTankPosY = GameMapView.tankStartPos[1];
//        tank.lives = 3;
//        tank.resetTankOrient();
//        bullets.clear();
//        enemies.clear();
//        map.drawBricks();
//        bricks = new ArrayList<>(map.bricksList);
//        map.drawMetal();
//        metals = new ArrayList<>(map.metalList);
//        spawnPoints = new ArrayList<>(map.spawnPoints);
//        map.drawBrokenBricks();
//        brokenBricks = new ArrayList<>(map.brokenBricksList);
//        resetEnemies();
//        addEnemyThread = new AddEnemyToField(enemies);
//        addEnemyThread.start();
//    }
}