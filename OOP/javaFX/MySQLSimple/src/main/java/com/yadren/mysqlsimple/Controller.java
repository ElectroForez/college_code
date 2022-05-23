package com.yadren.mysqlsimple;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField main_field;

    @FXML
    private VBox all_tasks;

    // Объект на основен нашего класса для работы с БД
    DB db = null;

    @FXML
    void initialize() {

        // Инициируем объект
        db = new DB();
        all_tasks.setSpacing(10);
        all_tasks.setMaxWidth(1000000);
        all_tasks.setPrefWidth(1000);
        // Метод для подгрузки заданий внутрь программы
        loadInfo();
    }

    // Метод для подгрузки заданий внутрь программы
    void loadInfo() {
        try {
            // Сначала очищаем от прошлых значений
            all_tasks.getChildren().clear();
            // Получаем все задания из базы данных
            ArrayList<String[]> tasks = db.getTasks();
            for (int i = 0; i < tasks.size(); i++) { // Перебираем их через цикл
                String serviceName = tasks.get(i)[0];
                int servicePrice = Integer.parseInt(tasks.get(i)[1]);
                int serviceDiscount = Integer.parseInt(tasks.get(i)[2]);

                Pane taskBox = getServicePane(serviceName, servicePrice, serviceDiscount);
                // Добавляем каждое задание в объект VBox (all_tasks)
                all_tasks.getChildren().add(taskBox);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Pane getServicePane(String serviceName, int price, int discount) {
        VBox taskBox = new VBox();
        taskBox.setMaxWidth(1000000);
        taskBox.setPrefWidth(10000);
        taskBox.setStyle("-fx-border-style: solid;"
                + "-fx-border-width: 1;"
                + "-fx-border-color: white");
        taskBox.setSpacing(5);

        Label labelServiceName = new Label(serviceName);
        taskBox.getChildren().add(labelServiceName);
        HBox priceBox = new HBox();
        Label discountLabel;
        if (discount != 0) {
            int newPrice = price - price / 100 * discount;
            Label labelOldPrice = new Label("" + price);
            labelOldPrice.setId("strikethrough");
            priceBox.getChildren().add(labelOldPrice);
            Label infoPriceLabel = new Label(" " + newPrice + " рублей");
            priceBox.getChildren().add(infoPriceLabel);
            taskBox.getChildren().add(priceBox);
            discountLabel = new Label("* скидка " + discount + "%");
            taskBox.getChildren().add(discountLabel);
        } else {
            Label infoPriceLabel = new Label(price + " рублей");
            priceBox.getChildren().add(infoPriceLabel);
            taskBox.getChildren().add(priceBox);
            discountLabel = new Label("");
            taskBox.getChildren().add(discountLabel);
        }
        HBox buttonBox = new HBox();
        buttonBox.setSpacing(3);
        Button editButton = new Button("Редактировать");
        Button deleteButton = new Button("Удалить");
        buttonBox.getChildren().add(editButton);
        buttonBox.getChildren().add(deleteButton);
        taskBox.getChildren().add(buttonBox);
        return taskBox;
    }
}


