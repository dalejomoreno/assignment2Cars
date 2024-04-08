package org.assignment.carassignment.controller;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.assignment.carassignment.model.Car;
import org.assignment.carassignment.Main;
import java.io.IOException;

public class MainViewController extends VBox {
    @FXML
    private TextField searchField;
    @FXML
    private RadioButton modelButton;
    @FXML
    private RadioButton manufacturerButton;
    @FXML
    private ListView<String> carListView;

    private Car[] carSearched;

    public MainViewController() {
        // This constructor is now empty since the initialization is done in the FXML file
    }

    @FXML
    private void initialize() {
        // Create a ToggleGroup to manage the radio buttons
        ToggleGroup selectionToggleGroup = new ToggleGroup();

        // Add radio buttons to the ToggleGroup
        manufacturerButton.setToggleGroup(selectionToggleGroup);
        modelButton.setToggleGroup(selectionToggleGroup);

        // Select one of the radio buttons by default
        manufacturerButton.setSelected(true);

        // Set up listeners for radio button selection changes
        selectionToggleGroup.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue == null) {
                // No radio button selected
                return;
            }

            RadioButton selectedRadioButton = (RadioButton) newValue;
            String selectedOption = (String) selectedRadioButton.getUserData();
            String model = selectedOption.equals("model") ? searchField.getText() : null;
            String manufacturer = selectedOption.equals("manufacturer") ? searchField.getText() : null;

        });

        // Set up double-click event handler for the ListView
        carListView.setOnMouseClicked(event -> {
            if (event.getButton() == MouseButton.PRIMARY && event.getClickCount() == 2) {
                String selectedItem = carListView.getSelectionModel().getSelectedItem();
                // Get the car details from the selected item
                Car selectedCar = getCarFromListViewItem(selectedItem);
                if (selectedCar != null) {
                    openCarDetailsScene(selectedCar);
                } else {
                    // Handle error if no car is selected
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText(null);
                    alert.setContentText("No car selected.");
                    alert.showAndWait();
                }
            }
        });
    }

    @FXML
    public void handleSearchButton(ActionEvent actionEvent) {
        // Get the selected radio button
        RadioButton selectedRadioButton = (RadioButton) manufacturerButton.getToggleGroup().getSelectedToggle();
        String selectedOption = (String) selectedRadioButton.getUserData();
        String model = selectedOption.equals("model") ? searchField.getText() : null;
        String manufacturer = selectedOption.equals("manufacturer") ? searchField.getText() : null;

        // Call fetchDataAndUpdateListView() with the selected options
        fetchDataAndUpdateListView(model, manufacturer);
    }

    private void fetchDataAndUpdateListView(String model, String manufacturer) {
        carListView.getItems().clear(); // Clear existing items
        carSearched = APIServiceController.fetchData(model, manufacturer);
        if (carSearched != null) {
            for (Car car : carSearched) {
                carListView.getItems().add(car.getMake() + " " + car.getModel() + " " + car.getCarClass() + " " + car.getYear());
            }
        } else {
            carListView.getItems().add("Error fetching car data");
        }
    }
    // Method to extract Car object from the ListView item string
    private Car getCarFromListViewItem(String selectedItem) {
        if (carSearched != null) {
            for (Car car : carSearched) {
                String carString = car.getMake() + " " + car.getModel() + " " + car.getCarClass() + " " + car.getYear();
                if (carString.equals(selectedItem)) {
                    return car;
                }
            }
        }
        return null; // Return null if no matching car is found
    }

    // Method to open the car details scene
    private void openCarDetailsScene(Car car) {
        try {
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("car-details.fxml"));
            Scene scene = new Scene(loader.load());
            CarDetailsController controller = loader.getController();
            controller.setCarDetails(car);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle(car.getMake() + " " + car.getModel() + " Details");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            // Handle error if unable to load car details scene
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Unable to load car details.");
            alert.showAndWait();
        }
    }
}
