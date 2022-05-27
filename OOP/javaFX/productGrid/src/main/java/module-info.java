module com.yadren.mysqlsimple {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.yadren.mysqlsimple to javafx.fxml;
    exports com.yadren.mysqlsimple;
}