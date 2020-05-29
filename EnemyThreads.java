package com.project;

import javafx.application.Platform;
import javafx.scene.Group;

import java.util.ArrayList;
import java.util.Random;

import static java.lang.Thread.sleep;

public class EnemyThreads {
    Enemy enemy;
    Collisions collisions;
    Group root;
    int enemyStartX;
    int enemyStartY;

    public EnemyThreads(Enemy enemy, Group root, Collisions collisions) {
        enemyStartX = 442;
        enemyStartY = 182;
        this.enemy = enemy;
        this.collisions = collisions;
        this.root = root;
    }

    public void enemyUpdate() {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                enemy.update(collisions, root);
            }
        });
    }
}