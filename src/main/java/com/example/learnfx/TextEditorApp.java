package com.example.learnfx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class TextEditorApp extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(TextEditorApp.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        // not really necessary anymore, program handles resizing BUT better for aesthetics
        stage.setResizable(false);
        stage.setTitle("Basic Text Editor");

        Image appIcon = new Image(getClass().getResourceAsStream("/com/example/learnfx/icons/pencil.png"));
        stage.getIcons().add(appIcon);

        stage.setScene(scene);
        stage.show();
    }

    public static void launchApplication(String[] args) {
        launch();
    }
}