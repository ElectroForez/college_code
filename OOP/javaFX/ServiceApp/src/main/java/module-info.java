module com.example.serviceapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.serviceapp to javafx.fxml;
    exports com.example.serviceapp;
}