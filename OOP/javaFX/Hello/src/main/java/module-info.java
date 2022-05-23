module com.yadren.hello {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.yadren.hello to javafx.fxml;
    exports com.yadren.hello;
}