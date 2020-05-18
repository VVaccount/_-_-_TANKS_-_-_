package com.project;

import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.*;
import java.util.ArrayList;

public class Map {
    File map;
    StringBuilder[] tileMap;
    //ArrayList<Integer> waterRows;
    //ArrayList<Integer> waterColumns;
    final char SPACE = ' ';
    final char BRICK = '1';
    final char METAL = '2';
    final char GRASS = '3';
    final char ICE = '4';
    final char WATER = '5';
    final int size = 16;
    final int startX = 442;
    final int startY = 182;
    final int brickOffsetX = 512;
    final int metalOffsetX = 512;
    final int waterOffsetX = 512;
    final int grassOffsetX = 528;
    final int iceOffsetX = 544;
    final int spaceOffsetX = 688;
    final int brickOffsetY = 128;
    final int metalOffsetY = 144;
    final int waterOffsetY = 160;
    final int grassOffsetY = 144;
    final int iceOffsetY = 144;
    final int spaceOffsetY = 0;
    int frame;
    ArrayList<ImageView> tiles;
    ArrayList<ImageView> brickTiles;
    ArrayList<ImageView> metalTiles;
    ArrayList<ImageView> waterTiles;
    ArrayList<ImageView> iceTiles;

    Map() {
        //waterRows = new ArrayList<>();
        //waterColumns = new ArrayList<>();
        tiles = new ArrayList<>();
        brickTiles = new ArrayList<>();
        metalTiles = new ArrayList<>();
        waterTiles = new ArrayList<>();
        iceTiles = new ArrayList<>();
        //tile = new Tile();
        map = new File("src/com/project/map1.txt");
        tileMap = new StringBuilder[(int) map.length() - 700];
        for(int index = 0; index < tileMap.length; index++){
            tileMap[index] = new StringBuilder();
        }
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(map.getAbsoluteFile()));
            for (StringBuilder stringBuilder : tileMap) {
                try {
                    stringBuilder.insert(0, bufferedReader.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        frame = 0;
    }

    public void draw(Group root) {
        for (int row = 0; row < tileMap.length; row++) {
            for (int column = 0; column < tileMap[row].length(); column++) {
                switch (tileMap[row].charAt(column)) {
                    case SPACE:
                        tiles.add(new ImageView(new Image(Tanks.class.getResourceAsStream("imgonline-com-ua-Transparent-backgr-5KGwsJZpkwVzR71.png"), 800, 512, false, true)));
                        tiles.get(tiles.size() - 1).setViewport(new Rectangle2D(spaceOffsetX, spaceOffsetY, size, size));
                        tiles.get(tiles.size() - 1).setX(getCoordinate(column, size, startX));
                        tiles.get(tiles.size() - 1).setY(getCoordinate(row, size, startY));
                        root.getChildren().add(tiles.get(tiles.size() - 1));
                        break;
                    case BRICK:
                        //tile.draw(root, getCoordinate(column, size, startX), getCoordinate(row, size, startY), brickOffsetX, brickOffsetY);
                        addTile(root, getCoordinate(column, size, startX), getCoordinate(row, size, startY), brickOffsetX, brickOffsetY);
                        brickTiles.add(tiles.get(tiles.size() - 1));
                        break;
                    case METAL:
                        //tile.draw(root, getCoordinate(column, size, startX), getCoordinate(row, size, startY), metalOffsetX, metalOffsetY);
                        addTile(root, getCoordinate(column, size, startX), getCoordinate(row, size, startY), metalOffsetX, metalOffsetY);
                        metalTiles.add(tiles.get(tiles.size() - 1));
                        break;
                    case GRASS:
                        //tile.draw(root, getCoordinate(column, size, startX), getCoordinate(row, size, startY), grassOffsetX, grassOffsetY);
                        addTile(root, getCoordinate(column, size, startX), getCoordinate(row, size, startY), grassOffsetX, grassOffsetY);
                        break;
                    case ICE:
                        //tile.draw(root, getCoordinate(column, size, startX), getCoordinate(row, size, startY), iceOffsetX, iceOffsetY);
                        addTile(root, getCoordinate(column, size, startX), getCoordinate(row, size, startY), iceOffsetX, iceOffsetY);
                        iceTiles.add(tiles.get(tiles.size() - 1));
                        break;
                    case WATER:
                        //waterRows.add(row);
                        //waterColumns.add(column);
                        //tile.draw(root, getCoordinate(column, size, startX), getCoordinate(row, size, startY), waterOffsetX, waterOffsetY);
                        addTile(root, getCoordinate(column, size, startX), getCoordinate(row, size, startY), waterOffsetX, waterOffsetY);
                        waterTiles.add(tiles.get(tiles.size() - 1));
                        break;
                }
            }
        }
    }

    public int getCoordinate(int direction, int size, int startCoordinate) {
        return direction * size + startCoordinate;
    }
    public void addTile(Group root, int x, int y, double offsetX, double offsetY){
        tiles.add(new ImageView(new Image(Tanks.class.getResourceAsStream("sprites.jpg"), 800, 512, false, true)));
        tiles.get(tiles.size() - 1).setViewport(new Rectangle2D(offsetX, offsetY, size, size));
        tiles.get(tiles.size() - 1).setX(x);
        tiles.get(tiles.size() - 1).setY(y);
        root.getChildren().add(tiles.get(tiles.size() - 1));
    }

    /*public void update(Group root) {
        if (frame < 2) {
            frame++;
        } else {
            frame = 0;
        }
        for (int index = 0; index < waterColumns.size(); index++) {
            tile.draw(root, getCoordinate(waterColumns.get(index),size, startX),getCoordinate(waterRows.get(index),size, startY),
            waterOffsetX + frame * size, waterOffsetY);
        }
    }*/
}