module co.edu.uniquindio.preparcil2.restaurante {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires java.logging;


    opens co.edu.uniquindio.preparcil2.restaurante to javafx.fxml;
    exports co.edu.uniquindio.preparcil2.restaurante;
    exports co.edu.uniquindio.preparcil2.restaurante.viewController;
    opens co.edu.uniquindio.preparcil2.restaurante.viewController to javafx.fxml;
    exports co.edu.uniquindio.preparcil2.restaurante.controller;
    opens co.edu.uniquindio.preparcil2.restaurante.controller to javafx.fxml;
    exports co.edu.uniquindio.preparcil2.restaurante.model;
    opens co.edu.uniquindio.preparcil2.restaurante.model to javafx.fxml;

}