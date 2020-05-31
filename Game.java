package com.project;

import javafx.animation.AnimationTimer;
import javafx.application.Platform;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

import static java.lang.Thread.sleep;

public class Game {
    Scene gameScene;
    //boolean gameIsRunning;
    Collisions collisions;
    Player player;
    Enemy enemy;
    Group root;
    Map map;
    EnemyThreads enemyThreads;

    Game(Stage stage, Replay replay) {
        //gameIsRunning = true;
        root = new Group();
        map = new Map();
        map.writeMap(replay);
        collisions = new Collisions(map);
        gameScene = new Scene(root);
        player = new Player(root, replay);
        enemy = new Enemy(root, player);
        enemyThreads = new EnemyThreads(enemy, root, collisions);
        player.setEnemy(enemy);
        map.draw(root);
        gameScene.setFill(Color.BLACK);
        stage.setScene(gameScene);
    }

    Game(Stage stage, String fileName, Replay replay) {
        //gameIsRunning = true;
        root = new Group();
        map = new Map(fileName);
        collisions = new Collisions(map);
        gameScene = new Scene(root);
        player = new Player(root);
        enemy = new Enemy(root, player);
        enemyThreads = new EnemyThreads(enemy, root, collisions);
        player.setEnemy(enemy);
        map.draw(root);
        gameScene.setFill(Color.BLACK);
        stage.setScene(gameScene);
    }

    public void getGameEvents(Replay replay) {
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                //map.update(root);
                player.update(collisions, root, replay);
                enemyThreads.enemyUpdate(replay);
            }
        };
        timer.start();
    }

    public void getGameEvents(Replay replay, int argument) {
        StringBuilder controlLine = new StringBuilder();
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                //map.update(root);
                controlLine.append(replay.readReplayFile().toString());
                if (controlLine.toString().equals("PLAYER SHOOTED") || controlLine.toString().equals("PLAYER MOVED UP") || controlLine.toString().equals("PLAYER MOVED DOWN") || controlLine.toString().equals("PLAYER MOVED LEFT") || controlLine.toString().equals("PLAYER MOVED RIGHT")) {
                    player.update(collisions, root, controlLine.toString());
                }
                if (controlLine.toString().equals("ENEMY SHOOTED") || controlLine.toString().equals("ENEMY MOVED UP") || controlLine.toString().equals("ENEMY MOVED DOWN") || controlLine.toString().equals("ENEMY MOVED LEFT") || controlLine.toString().equals("ENEMY MOVED RIGHT")) {
                    enemyThreads.enemyUpdate(controlLine.toString());
                }
                if (controlLine.toString().equals("END")) {
                    try {
                        replay.replayReader.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    replay.replayScanner.close();
                    Platform.exit();
                }
                controlLine.delete(0, controlLine.length());
//                try {
//                    sleep(10);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
            }
        };
        timer.start();
    }
//    void restartGame() {
//    }
}