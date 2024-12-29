package com.example.javafx1.third;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class RestaurantOrder extends Application {
    private final List<String> orderDetails = new ArrayList<>();
    private double totalCost = 0;

    @Override
    public void start(Stage primaryStage) {
        TextField dishField = new TextField();
        TextField quantityField = new TextField("1");
        Button orderButton = new Button("Оформить заказ");
        TextArea receiptArea = new TextArea();
        receiptArea.setEditable(false);

        orderButton.setOnAction(e -> {
            String dish = dishField.getText();
            int quantity = Integer.parseInt(quantityField.getText());
            double price = 10.0; // Примерная цена за блюдо
            double cost = price * quantity;

            orderDetails.add(dish + " x" + quantity + " = " + cost);
            totalCost += cost;

            StringBuilder receipt = new StringBuilder("Чек:\n");
            for (String detail : orderDetails) {
                receipt.append(detail).append("\n");
            }
            receipt.append("Итого: ").append(totalCost);
            receiptArea.setText(receipt.toString());
        });

        GridPane grid = new GridPane();
        grid.add(new Label("Блюдо:"), 0, 0);
        grid.add(dishField, 1, 0);
        grid.add(new Label("Количество:"), 0, 1);
        grid.add(quantityField, 1, 1);
        grid.add(orderButton, 0, 2);
        grid.add(receiptArea, 0, 3, 2, 1);

        Scene scene = new Scene(grid, 400, 300);
        primaryStage.setTitle("Заказ в ресторане");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}