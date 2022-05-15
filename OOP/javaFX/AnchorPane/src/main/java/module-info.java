module com.yadren.anchorpane {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.yadren.anchorpane to javafx.fxml;
    exports com.yadren.anchorpane;
}