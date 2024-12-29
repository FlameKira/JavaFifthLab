package com.example.javafx1.fourth;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Calculator extends Application {
    private double result = 0;
    private String operator = "";
    private boolean start = true;

    @Override
    public void start(Stage primaryStage) {
        TextField display = new TextField();
        display.setEditable(false);

        Button[] numberButtons = new Button[10];
        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new Button(String.valueOf(i));
            int finalI = i;
            numberButtons[i].setOnAction(e -> {
                if (start) {
                    display.setText("");
                    start = false;
                }
                display.setText(display.getText() + finalI);
            });
        }

        Button addButton = new Button("+");
        Button subtractButton = new Button("-");
        Button multiplyButton = new Button("*");
        Button divideButton = new Button("/");
        Button equalsButton = new Button("=");
        Button clearButton = new Button("C");

        addButton.setOnAction(e -> handleOperator(display, "+"));
        subtractButton.setOnAction(e -> handleOperator(display, "-"));
        multiplyButton.setOnAction(e -> handleOperator(display, "*"));
        divideButton.setOnAction(e -> handleOperator(display, "/"));
        equalsButton.setOnAction(e -> calculate(display));
        clearButton.setOnAction(e -> {
            display.clear();
            result = 0;
            operator = "";
            start = true;
        });

        GridPane grid = new GridPane();
        grid.add(display, 0, 0, 4, 1);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                grid.add(numberButtons[i * 3 + j + 1], j, i + 1);
            }
        }
        grid.add(numberButtons[0], 1, 4);
        grid.add(addButton, 3, 1);
        grid.add(subtractButton, 3, 2);
        grid.add(multiplyButton, 3, 3);
        grid.add(divideButton, 3, 4);
        grid.add(equalsButton, 2, 4);
        grid.add(clearButton, 0, 4);

        Scene scene = new Scene(grid, 300, 250);
        primaryStage.setTitle("Калькулятор");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void handleOperator(TextField display, String op) {
        if (!operator.isEmpty()) {
            calculate(display);
        }
        operator = op;
        result = Double.parseDouble(display.getText());
        display.clear();
    }

    private void calculate(TextField display) {
        if (operator.isEmpty()) return;
        double secondOperand = Double.parseDouble(display.getText());
        switch (operator) {
            case "+" -> result += secondOperand;
            case "-" -> result -= secondOperand;
            case "*" -> result *= secondOperand;
            case "/" -> {
                if (secondOperand == 0) {
                    display.setText("Ошибка: деление на 0");
                    return;
                }
                result /= secondOperand;
            }
        }
        display.setText(String.valueOf(result));
        operator = "";
        start = true;
    }

    public static void main(String[] args) {
        launch(args);
    }
}