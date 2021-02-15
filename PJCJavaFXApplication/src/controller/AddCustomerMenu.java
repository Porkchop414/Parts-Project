package controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Customer;
import model.Inventory;
import model.Product;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AddCustomerMenu implements Initializable{
        Stage stage;
        Parent scene;
        Customer myCustomer = new Customer(1, "Bob");
        @FXML
        private TableView<Product> addProductTopTable;

        @FXML
        private TableColumn<Product, Integer> productIDCol;

        @FXML
        private TableColumn<Product, String> productNameCol;

        @FXML
        private TableColumn<Product, Integer> invLevelCol;

        @FXML
        private TableColumn<Product, Double> priceCostPerUnitCol;

        @FXML
        private TableView<Product> addProductBotTable;

        @FXML
        private TableColumn<Product, Integer> colProductID;

        @FXML
        private TableColumn<Product, String> colProductName;

        @FXML
        private TableColumn<Product, Integer> invCol;

        @FXML
        private TableColumn<Product, Double> colPrice;

        @FXML
        private TextField cusMenuProductSearchTxt;

        @FXML
        private TextField addCustomerIDTxt;

        @FXML
        private TextField addCustomerNameTxt;

        public void addSelectedProduct() {
                Product myProduct = addProductTopTable.getSelectionModel().getSelectedItem();
                myCustomer.addAssociatedProduct(myProduct);
                addProductBotTable.setItems(myCustomer.getAssociatedProduct());
        }
        @FXML
        void onActionAddProductToCustomer(ActionEvent event) {
        addSelectedProduct();
        }

        @FXML
        void onActionCancel(ActionEvent event) throws IOException {
                stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
                scene = FXMLLoader.load(getClass().getResource("/view/MainMenu.fxml"));
                stage.setScene(new Scene(scene));
                stage.show();
        }

        @FXML
        void onActionRemoveAssociatedProduct(ActionEvent event) {

        }

        @FXML
        void onActionSaveCustomer(ActionEvent event) {

        }

        @FXML
        void onActionSearchBox(ActionEvent event) {

        }

@Override
        public void initialize(URL url, ResourceBundle rb) {
                addProductTopTable.setItems(Inventory.getAllProducts());
                productIDCol.setCellValueFactory(new PropertyValueFactory<>("id"));
                productNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
                invLevelCol.setCellValueFactory(new PropertyValueFactory<>("stock"));
                priceCostPerUnitCol.setCellValueFactory(new PropertyValueFactory<>("price"));

                colProductID.setCellValueFactory(new PropertyValueFactory<>("id"));
                colProductName.setCellValueFactory(new PropertyValueFactory<>("name"));
                invCol.setCellValueFactory(new PropertyValueFactory<>("stock"));
                colPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        }
}