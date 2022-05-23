module com.example.teststyle {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.teststyle to javafx.fxml;
    exports com.example.teststyle;
}