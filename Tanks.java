package com.project;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class Tanks extends Application {
    @Override
    public void start(Stage stage)
    {
        Menu menu = new Menu(stage);
        Scene scene = new Scene(menu.getMenuGridpane());
        menu.getMenuEvents();
        scene.setFill(Color.BLACK);
        stage.setScene(scene);
        stage.getIcons().add(new Image(Tanks.class.getResourceAsStream("tank.jpg")));
        stage.setWidth(1920);
        stage.setHeight(1080);
        stage.centerOnScreen();
        stage.setResizable(false);
        stage.setTitle("TANKS");
        stage.show();
    }
    public static void main(String[] args) {
        Application.launch(args);
    }
}