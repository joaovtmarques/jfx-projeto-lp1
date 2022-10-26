module com.celular {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;


    opens com.celular.controller to javafx.fxml;
    opens com.celular to javafx.fxml;

    exports com.celular;
    exports com.celular.controller;
}