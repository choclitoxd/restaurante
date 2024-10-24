package co.edu.uniquindio.preparcil2.restaurante.controller;

public class LoginController {
    ModelFactoryController modelFactoryController;

    public LoginController() {
        modelFactoryController = ModelFactoryController.getInstance();
    }

    public boolean validation(String user, String password) {
        return modelFactoryController.validation(user,password);
    }
}
