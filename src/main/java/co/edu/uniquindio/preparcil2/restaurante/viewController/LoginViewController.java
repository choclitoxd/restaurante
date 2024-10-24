package co.edu.uniquindio.preparcil2.restaurante.viewController;

import co.edu.uniquindio.preparcil2.restaurante.LoginApplication;
import co.edu.uniquindio.preparcil2.restaurante.controller.LoginController;
import javafx.fxml.FXML;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;

public class LoginViewController {
    LoginController loginController;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private TextField txtUser;
    @FXML
    void initialize() {
        loginController = new LoginController();
    }

    @FXML
    void onEnter(ActionEvent event) throws IOException {
        if (!txtPassword.getText().isEmpty() || !txtUser.getText().isEmpty()) {
            if(loginController.validation(txtUser.getText(),txtPassword.getText())){
                try {
                    // Cargar el archivo FXML
                    FXMLLoader loader = new FXMLLoader(LoginApplication.class.getResource("gestion-view.fxml"));

                    // Crear la nueva escena
                    Parent root = loader.load();
                    Scene newScene = new Scene(root);

                    // Obtener el stage actual y setear la nueva escena
                    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow(); // asumiendo que tienes acceso a 'event'
                    stage.setScene(newScene);
                    stage.show();

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }else{
            txtPassword.requestFocus();
        }
    }

}