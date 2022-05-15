module com.yadren.hvbox {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.yadren.hvbox to javafx.fxml;
    exports com.yadren.hvbox;
}