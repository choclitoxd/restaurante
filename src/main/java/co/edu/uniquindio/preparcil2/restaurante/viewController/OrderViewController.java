package co.edu.uniquindio.preparcil2.restaurante.viewController;
import co.edu.uniquindio.preparcil2.restaurante.controller.OrderController;
import co.edu.uniquindio.preparcil2.restaurante.model.Costumer;
import co.edu.uniquindio.preparcil2.restaurante.model.Order;
import co.edu.uniquindio.preparcil2.restaurante.model.Product;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.time.ZoneId;
import java.util.Date;
import java.util.List;

public class OrderViewController {
    OrderController orderController;
    ObservableList<Product> prodcutsOrder = FXCollections.observableArrayList();

    @FXML
    void initialize() {
        orderController = new OrderController();
        initCombo();
        initSpinner();
    }

    private void initSpinner() {
        SpinnerValueFactory<Integer> valueFactory =
                new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 100, 1); // Valor inicial en 1
        spinnerProduct.setValueFactory(valueFactory);
    }

    private void initCombo() {
        initComboBoxCostumer();
        initComboBoxProduct();
    }

    private void initComboBoxProduct() {
        ObservableList<String> comboBoxProduct = FXCollections.observableArrayList();
        List<Product> productList = orderController.getProducts();
        comboBoxProduct.addAll("--Selection--");
        for (Product product : productList) {
            String contenido = product.getName()+"$" + product.getPrice();
            comboBoxProduct.add(contenido);
        }
        comboBoxProducts.setItems(comboBoxProduct);
        comboBoxProducts.getSelectionModel().select("--Selection--");
    }

    private void initComboBoxCostumer() {
        ObservableList<String> comboBoxCostumers = FXCollections.observableArrayList();
        List<Costumer> costumerList = orderController.getCostumers();
        comboBoxCostumers.addAll("--Selection--");
        for (Costumer costumer:costumerList){
            comboBoxCostumers.add(costumer.getName());
        }
        comboBoxCostumer.setItems(comboBoxCostumers);
        comboBoxCostumer.getSelectionModel().select("--Selection--");
    }

    @FXML
    void onAddProduct(ActionEvent event) {
        if (!comboBoxProducts.getValue().equalsIgnoreCase("--Selection--")) {
            for (int i = 0; i < spinnerProduct.getValue(); i++) {
                if (orderController.getProduct(comboBoxProducts.getValue()) != null){
                    prodcutsOrder.add(orderController.getProduct(comboBoxProducts.getValue().split("\\$")[0]));
                }else{
                    break;
                }
            }
            comboBoxProducts.getSelectionModel().select("--Selection--");
            mostrarMensaje("Notification Add Product", "Product added", "The product was added successfully", Alert.AlertType.INFORMATION);
        }
    }
    private boolean validData() {
        return !comboBoxCostumer.getValue().equalsIgnoreCase("--Selection--")
                || !comboBoxProducts.getValue().equalsIgnoreCase("--Selection--")
                &&  datePickerOrder.getValue() != null;
    }

    private void mostrarMensaje(String titulo, String header, String contenido, Alert.AlertType alertType) {
        Alert aler = new Alert(alertType);
        aler.setTitle(titulo);
        aler.setHeaderText(header);
        aler.setContentText(contenido);
        aler.showAndWait();
    }

    @FXML
    void onMakePurchase(ActionEvent event) {
        try {
            if (validData()) {
                Order order = buildOrder();
                orderController.addOrder(order);
                mostrarMensaje("Notification Add Order", "Oder added", "The order was added successfully", Alert.AlertType.INFORMATION);
                cleanFields();
            }
            else{
                mostrarMensaje("Notification Add Product", "Order not added", "The data entered is invalid", Alert.AlertType.INFORMATION);
            }
        }catch (Exception e) {
            System.out.println("Ocurrió un error al intentar agregar la cita: " + e.getMessage());
        }
    }

    private void cleanFields() {
        comboBoxProducts.getSelectionModel().select("--Selection--");
        comboBoxCostumer.getSelectionModel().select("--Selection--");
        datePickerOrder.setValue(null);
        prodcutsOrder.clear();
    }

    private Order buildOrder() {
        Order order = new Order();
        if (!comboBoxProducts.getValue().equalsIgnoreCase("--Selection--")) {
            System.out.println(comboBoxProducts.getValue().split("\\$")[0]);
            prodcutsOrder.add(orderController.getProduct(comboBoxProducts.getValue().split("\\$")[0]));
        }
        order.setOrderProductoList(prodcutsOrder);
        order.setCostumer(orderController.getCostumer(comboBoxCostumer.getValue()));
        order.setDateOrder(Date.from(datePickerOrder.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant()));
        order.setTotal(sumProduct());
        return order;
    }

    private double sumProduct() {
        double sum = 0;
        for (int i = 0; i < prodcutsOrder.size(); i++) {
            sum += prodcutsOrder.get(i).getPrice();
        }
        return sum;
    }

    @FXML
    private Spinner<Integer> spinnerProduct;

    @FXML
    private ComboBox<String> comboBoxCostumer;

    @FXML
    private ComboBox<String> comboBoxProducts;

    @FXML
    private DatePicker datePickerOrder;

}
