package co.edu.uniquindio.preparcil2.restaurante.controller;

import co.edu.uniquindio.preparcil2.restaurante.model.Costumer;
import co.edu.uniquindio.preparcil2.restaurante.model.Order;
import co.edu.uniquindio.preparcil2.restaurante.model.Product;
import co.edu.uniquindio.preparcil2.restaurante.model.Restaurant;
import co.edu.uniquindio.preparcil2.restaurante.utils.Persistence;

import java.io.IOException;
import java.util.List;

public class ModelFactoryController {
    Restaurant restaurant;

    private static class SingletonHolder {
        private final static ModelFactoryController eINSTANCE = new ModelFactoryController();
    }

    public static ModelFactoryController getInstance() {
        return SingletonHolder.eINSTANCE;
    }

    public ModelFactoryController(){
        cargarDatosDesdeArchivos();
    }

    public boolean validation(String user, String password) {
        return Persistence.validation(user,password);
    }

    public List<Costumer> getCostumers() {
        return restaurant.getCostumers();
    }

    public List<Product> getProducts() {
        return restaurant.getProducts();
    }

    private void cargarDatosDesdeArchivos() {
        restaurant = new Restaurant();
        try {
            Persistence.loadData(restaurant);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Product getProduct(String value) {
        return restaurant.getProduct(value);
    }

    public Costumer getCostumer(String value) {
        return restaurant.getCostumer(value);
    }

    public void addOrder(Order order) {
        restaurant.addProduct(order);
        saveResourceWalletXML();
    }
    private void saveResourceWalletXML() {
        Persistence.saveResourceWalletXML(restaurant);
    }
}
