package co.edu.uniquindio.preparcil2.restaurante.controller;

import co.edu.uniquindio.preparcil2.restaurante.model.Costumer;
import co.edu.uniquindio.preparcil2.restaurante.model.Order;
import co.edu.uniquindio.preparcil2.restaurante.model.Product;

import java.util.List;

public class OrderController {
    ModelFactoryController modelFactoryController;

    public OrderController() {
        modelFactoryController = ModelFactoryController.getInstance();
    }
    public List<Costumer> getCostumers() {
        return modelFactoryController.getCostumers();
    }

    public List<Product> getProducts() {
        return modelFactoryController.getProducts();
    }

    public Product getProduct(String value) {
        return modelFactoryController.getProduct(value);
    }

    public Costumer getCostumer(String value) {
        return modelFactoryController.getCostumer(value);
    }

    public void addOrder(Order order) {
        modelFactoryController.addOrder(order);
    }
}
