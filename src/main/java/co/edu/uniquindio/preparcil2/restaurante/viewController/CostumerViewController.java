package co.edu.uniquindio.preparcil2.restaurante.viewController;
import co.edu.uniquindio.preparcil2.restaurante.controller.CostumerController;
import co.edu.uniquindio.preparcil2.restaurante.model.Costumer;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
public class CostumerViewController {
    CostumerController controller;
    ObservableList<Costumer> costumers = FXCollections.observableArrayList();
    @FXML
    private TableColumn<Costumer, String> tbColCodeC;

    @FXML
    private TableColumn<Costumer, String> tbColID;

    @FXML
    private TableColumn<Costumer, String> tbColIType;

    @FXML
    private TableColumn<Costumer, String> tbColLastName;

    @FXML
    private TableColumn<Costumer, String> tbColNameC;

    @FXML
    private TableColumn<Costumer, String> tbColPhone;

    @FXML
    private TableView<Costumer> tbCostumer;
    @FXML
    void initialize() {
        controller = new CostumerController();
        initView();
    }
    private void initView() {
        initDataBinding();
        getCostumers();
        tbCostumer.getItems().clear();
        tbCostumer.getItems().addAll(costumers);
    }
    private void initDataBinding() {
        tbColCodeC.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getCode())));
        tbColID.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getId()));
        tbColIType.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getIdentificationType()));
        tbColNameC.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getName()));
        tbColLastName.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getLastName()));
        tbColPhone.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getPhone()));
    }
    private void getCostumers() {
        costumers.addAll(controller.getCostumers());
    }

}
