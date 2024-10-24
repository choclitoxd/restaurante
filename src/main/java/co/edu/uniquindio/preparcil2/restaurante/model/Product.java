package co.edu.uniquindio.preparcil2.restaurante.model;

public class Product {
    private static int adder = 0;
    private int code;
    private String name;
    private double price;
    public Product(){
        code = adder++;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
