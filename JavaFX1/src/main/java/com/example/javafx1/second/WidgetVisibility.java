package com.example.javafx1.second;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class WidgetVisibility extends Application {
    @Override
    public void start(Stage primaryStage) {
        Label label1 = new Label("Widget 1");
        Label label2 = new Label("Widget 2");
        Label label3 = new Label("Widget 3");

        CheckBox checkBox1 = new CheckBox("Show/Hide Widget 1");
        CheckBox checkBox2 = new CheckBox("Show/Hide Widget 2");
        CheckBox checkBox3 = new CheckBox("Show/Hide Widget 3");

        checkBox1.setOnAction(e -> label1.setVisible(checkBox1.isSelected()));
        checkBox2.setOnAction(e -> label2.setVisible(checkBox2.isSelected()));
        checkBox3.setOnAction(e -> label3.setVisible(checkBox3.isSelected()));

        VBox vbox = new VBox(10, label1, checkBox1, label2, checkBox2, label3, checkBox3);
        Scene scene = new Scene(vbox, 300, 200);
        primaryStage.setTitle("Widget Visibility");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}