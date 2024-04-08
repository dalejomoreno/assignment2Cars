package org.assignment.carassignment.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.assignment.carassignment.Main;
import org.assignment.carassignment.model.Car;

import java.io.IOException;

public class CarDetailsController extends VBox {
    @FXML
    private Label combinedMpgLabel;
    @FXML
    private Label modelLabel;
    @FXML
    private Label makeLabel;
    @FXML
    private Label classLabel;
    @FXML
    private Label yearLabel;
    @FXML
    private Label cityMpgLabel;
    @FXML
    private Label combinationMpgLabel;
    @FXML
    private Label cylindersLabel;
    @FXML
    private Label displacementLabel;
    @FXML
    private Label driveLabel;
    @FXML
    private Label fuelTypeLabel;
    @FXML
    private Label highwayMpgLabel;
    @FXML
    private Label transmissionLabel;


    // Set car details
    public void setCarDetails(Car car) {
        if (car != null) {
            makeLabel.setText("Make: " + car.getMake());
            modelLabel.setText("Model: " + car.getModel());
            classLabel.setText("Class: " + car.getCarClass());
            yearLabel.setText("Year: " + car.getYear());
            cityMpgLabel.setText("City MPG: " + car.getCityMpg());
            highwayMpgLabel.setText("Highway MPG: " + car.getHighwayMpg());
//            combinedMpgLabel.setText("Combined MPG: " + car.getCombinationMpgLabel());
            cylindersLabel.setText("Cylinders: " + car.getCylinders());
            displacementLabel.setText("Displacement: " + car.getDisplacement());
            driveLabel.setText("Drive: " + car.getDrive());
            fuelTypeLabel.setText("Fuel Type: " + car.getFuelType());
            transmissionLabel.setText("Transmission: " + car.getTransmission());
        }
    }

    // Handle back button action
    @FXML
    private void handleBackButton() {
        Stage stage = (Stage) makeLabel.getScene().getWindow();
        stage.close(); // Close the current stage (car details scene)
    }
}