package co.edu.uniquindio.preparcil2.restaurante.viewController;
import co.edu.uniquindio.preparcil2.restaurante.controller.CostumerController;
import co.edu.uniquindio.preparcil2.restaurante.controller.ProductController;
import co.edu.uniquindio.preparcil2.restaurante.model.Product;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
public class ProductViewController {
    ProductController productController;
    ObservableList<Product> products = FXCollections.observableArrayList();
    @FXML
    private TableColumn<Product, String> tbColCodeP;

    @FXML
    private TableColumn<Product, String> tbColNameP;

    @FXML
    private TableColumn<Product, String> tbColPrice;

    @FXML
    private TableView<Product> tbProducts;
    @FXML
    void initialize() {
        productController = new ProductController();
        initView();
    }
    private void initView() {
        initDataBinding();
        getProducts();
        tbProducts.getItems().clear();
        tbProducts.getItems().addAll(products);
    }
    private void initDataBinding() {
        tbColCodeP.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getCode())));
        tbColNameP.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getName()));
        tbColPrice.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getPrice())));
    }
    private void getProducts() {
        products.addAll(productController.getProducts());
    }
}
