module com.celular {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;
    requires java.sql;


    opens com.celular.controller to javafx.fxml;
    opens com.celular.model to javafx.fxml;
    opens com.celular to javafx.fxml;

    exports com.celular;
    exports com.celular.controller;
}