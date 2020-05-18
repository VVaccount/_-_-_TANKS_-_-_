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
//        enemyThreads.run();
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                //map.update(root);
                player.update(collisions, root);
                //enemyThreads.run();
                enemy.update(collisions, root);
            }
        };
        timer.start();
    }
}