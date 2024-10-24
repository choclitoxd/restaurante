package co.edu.uniquindio.preparcil2.restaurante.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order implements Serializable {
    private static final long serialVersionUID = 1L;
    private static int adder = 0;
    private int code;
    private List<Product> orderProductoList = new ArrayList<>();
    private Costumer costumer;
    private Date dateOrder;
    private double total;

    public Order() {
        this.code = adder++;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<Product> getOrderProductoList() {
        return orderProductoList;
    }

    public void setOrderProductoList(List<Product> orderProductoList) {
        this.orderProductoList = orderProductoList;
    }

    public Costumer getCostumer() {
        return costumer;
    }

    public void setCostumer(Costumer costumer) {
        this.costumer = costumer;
    }

    public Date getDateOrder() {
        return dateOrder;
    }

    public void setDateOrder(Date fechaCita) {
        this.dateOrder = fechaCita;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
