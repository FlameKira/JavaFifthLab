package com.example.javafx1.first;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class WordSwitcher extends Application {
    private boolean isFirstToSecond = true;

    @Override
    public void start(Stage primaryStage) {
        TextField textField1 = new TextField();
        TextField textField2 = new TextField();
        textField2.setEditable(false);

        Button switchButton = new Button("→");
        switchButton.setOnAction(e -> {
            if (isFirstToSecond) {
                textField2.setText(textField1.getText());
                textField1.clear();
                switchButton.setText("←");
            } else {
                textField1.setText(textField2.getText());
                textField2.clear();
                switchButton.setText("→");
            }
            isFirstToSecond = !isFirstToSecond;
        });

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10));
        grid.setVgap(10);
        grid.setHgap(10);
        grid.add(new Text("Input 1:"), 0, 0);
        grid.add(textField1, 1, 0);
        grid.add(switchButton, 2, 0);
        grid.add(new Text("Input 2:"), 0, 1);
        grid.add(textField2, 1, 1);

        Scene scene = new Scene(grid, 300, 150);
        primaryStage.setTitle("Word Switcher");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}