package com.project;

import javafx.application.Platform;
import javafx.scene.Group;

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

    public void enemyUpdate(Replay replay) {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                enemy.update(collisions, root, replay);
            }
        });
    }

    public void enemyUpdate(String controlLine) {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                enemy.update(collisions, root, controlLine);
            }
        });
    }
}