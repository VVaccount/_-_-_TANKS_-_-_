package com.project;

import javafx.application.Platform;
import javafx.scene.Group;

import java.util.ArrayList;
import java.util.Random;

public class EnemyThreads implements Runnable {
    Enemy enemy;
    //ArrayList<Enemy> enemies;
    //boolean enemiesEnded;
    //int totalNumOfEnemies = 14;
    //int numOfSpawned;
    //boolean canSpawn;
    //int maxEnemyOnField = 3;
    Collisions collisions;
    Group root;
    int enemyStartX;
    int enemyStartY;

    //    public EnemyThread(ArrayList<Enemy> enemies){
//        this.enemies = enemies;
//        enemiesEnded = false;
//        numOfSpawned = 1;
//        canSpawn = new boolean[GameMapView.enemyStartPos.length];
//        for(int spawnIndex = 0; spawnIndex < GameMapView.enemyStartPos.length; spawnIndex++){
//            canSpawn[spawnIndex] = true;
//        }
//    }
    public EnemyThreads(Enemy enemy, Group root, Collisions collisions) {
        enemyStartX = 442;
        enemyStartY = 182;
        this.enemy = enemy;
        this.collisions = collisions;
        this.root = root;
    }

//    @Override
//    public void run(){
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        while(!enemiesEnded){
//            if(numOfSpawned + 4 >= totalNumOfEnemies){
//                enemiesEnded = true;
//            }
//            if(enemies.size() < maxEnemyOnField){
//                System.out.println("Spawn");
//                Random rand = new Random();
//                //boolean findFree = true;
//                boolean foundedObstacle = true;
//                int pos = rand.nextInt(GameMapView.enemyStartPos.length);
//                while(foundedObstacle){
//                    foundedObstacle = false;
//                    for(int index = 0; index < GameMapView.enemyStartPos.length; index++){
//                        if (pos == index && !canSpawn[index]) {
//                            rand = new Random();
//                            pos = rand.nextInt(GameMapView.enemyStartPos.length);
//                            System.out.println("----Try to find new point----");
//                            foundedObstacle = true;
//                            break;
//                        }
//                    }
//                }
//                //int posToSet = pos;
//                if(!pause){
//                    EnemyTank enemyTank = new EnemyTank(GameMapView.enemyStartPos[pos][0], GameMapView.enemyStartPos[pos][1]);
//                    enemyTank.sprite.setImage(enemyTank.getTank1DownImg());
//                    enemyTank.sprite.setPosition(GameMapView.enemyStartPos[pos][0], GameMapView.enemyStartPos[pos][1]);
//                    enemyTank.sprite.setSize(EnemyTank.tankSize);
//                    enemies.add(enemyTank);
//                    numOfSpawned++;
//                }
//                try {
//                    Thread.sleep(3000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//    }
//
//    public void setCanSpawn(boolean status, int index){
//        canSpawn[index] = status;
//    }

    @Override
    public void run() {
        //Platform.runLater();
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        while (true) {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            enemy.update(collisions, root);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
//        }
//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }
}