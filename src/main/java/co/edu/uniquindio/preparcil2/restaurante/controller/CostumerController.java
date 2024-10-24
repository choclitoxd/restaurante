package co.edu.uniquindio.preparcil2.restaurante.controller;

import co.edu.uniquindio.preparcil2.restaurante.model.Costumer;

import java.util.List;

public class CostumerController {
    ModelFactoryController modelFactoryController;

    public CostumerController() {
        modelFactoryController = ModelFactoryController.getInstance();
    }
    public List<Costumer> getCostumers() {
        return modelFactoryController.getCostumers();
    }
}
