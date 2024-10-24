package co.edu.uniquindio.preparcil2.restaurante.model;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    private List<Costumer> costumers = new ArrayList<>();
    private List<Product> products = new ArrayList<>();
    private List<Order> orders = new ArrayList<>();

    public List<Costumer> getCostumers() {
        return costumers;
    }

    public void setCostumers(List<Costumer> costumers) {
        this.costumers = costumers;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public Product getProduct(String value) {
       for (Product product : products) {
           if (product.getName().equalsIgnoreCase(value)) {
               return product;
           }
       }
       return null;
    }

    public Costumer getCostumer(String value) {
        for (Costumer costumer : costumers) {
            if (costumer.getName().equals(value)) {
                return costumer;
            }
        }
        return null;
    }

    public void addProduct(Order order) {
        orders.add(order);
    }
}
