package com.example.javafx1.fifth;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TextFlag extends Application {
    @Override
    public void start(Stage primaryStage) {
        ToggleGroup colorGroup1 = new ToggleGroup();
        ToggleGroup colorGroup2 = new ToggleGroup();
        ToggleGroup colorGroup3 = new ToggleGroup();

        RadioButton red1 = new RadioButton("Красный");
        RadioButton green1 = new RadioButton("Зеленый");
        RadioButton blue1 = new RadioButton("Синий");
        red1.setToggleGroup(colorGroup1);
        green1.setToggleGroup(colorGroup1);
        blue1.setToggleGroup(colorGroup1);

        RadioButton red2 = new RadioButton("Красный");
        RadioButton green2 = new RadioButton("Зеленый");
        RadioButton blue2 = new RadioButton("Синий");
        red2.setToggleGroup(colorGroup2);
        green2.setToggleGroup(colorGroup2);
        blue2.setToggleGroup(colorGroup2);

        RadioButton red3 = new RadioButton("Красный");
        RadioButton green3 = new RadioButton("Зеленый");
        RadioButton blue3 = new RadioButton("Синий");
        red3.setToggleGroup(colorGroup3);
        green3.setToggleGroup(colorGroup3);
        blue3.setToggleGroup(colorGroup3);

        Button drawButton = new Button("Нарисовать");
        TextArea outputArea = new TextArea();
        outputArea.setEditable(false);

        drawButton.setOnAction(e -> {
            try {
                String color1 = ((RadioButton) colorGroup1.getSelectedToggle()).getText();
                String color2 = ((RadioButton) colorGroup2.getSelectedToggle()).getText();
                String color3 = ((RadioButton) colorGroup3.getSelectedToggle()).getText();
                outputArea.setText(color1 + ", " + color2 + ", " + color3);
            } catch (NullPointerException ex) {
                outputArea.setText("Ошибка: Пожалуйста, выберите цвет для всех полос.");
            }
        });

        VBox vbox = new VBox(10, red1, green1, blue1, red2, green2, blue2, red3, green3, blue3, drawButton, outputArea);
        Scene scene = new Scene(vbox, 300, 400);
        primaryStage.setTitle("Текстовый флаг");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}