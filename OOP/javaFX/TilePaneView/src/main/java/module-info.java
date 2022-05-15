module com.yadren.tilepaneview {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.yadren.tilepaneview to javafx.fxml;
    exports com.yadren.tilepaneview;
}