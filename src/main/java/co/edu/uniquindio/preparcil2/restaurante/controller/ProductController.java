package co.edu.uniquindio.preparcil2.restaurante.controller;

import co.edu.uniquindio.preparcil2.restaurante.model.Product;

import java.util.List;

public class ProductController {
    ModelFactoryController modelFactoryController;

    public ProductController() {
        modelFactoryController = ModelFactoryController.getInstance();
    }
    public List<Product> getProducts() {
        return modelFactoryController.getProducts();
    }
}
