package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/** Customer Class.
 * This class with be used to create our Customers.
 * @author Peter.
 */
public class Customer {
    private ObservableList<Product> associatedProducts = FXCollections.observableArrayList();
    private int id;
    private String name;

    public Customer (int id, String name){
        this.id = id;
        this.name = name;

    }





}