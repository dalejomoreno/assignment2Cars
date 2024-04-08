package org.assignment.carassignment.model;

import com.google.gson.annotations.SerializedName;

public class Car {
    @SerializedName("city_mpg")
    private int cityMpg;

    @SerializedName("class")
    private String carClass;

    @SerializedName("combination_mpg")
    private int combinationMpg;

    private int cylinders;
    private double displacement;
    private String drive;

    @SerializedName("fuel_type")
    private String fuelType;

    @SerializedName("highway_mpg")
    private int highwayMpg;

    private String make;
    private String model;
    private String transmission;
    private int year;

    public Car() {
    }

    public Car(String make, String model, String carClass, int year) {
    }

    public int getCityMpg() {
        return cityMpg;
    }

    public void setCityMpg(int cityMpg) {
        this.cityMpg = cityMpg;
    }

    public String getCarClass() {
        return carClass;
    }

    public void setCarClass(String carClass) {
        this.carClass = carClass;
    }

    public int getCombinationMpg() {
        return combinationMpg;
    }

    public void setCombinationMpg(int combinationMpg) {
        this.combinationMpg = combinationMpg;
    }

    public int getCylinders() {
        return cylinders;
    }

    public void setCylinders(int cylinders) {
        this.cylinders = cylinders;
    }

    public double getDisplacement() {
        return displacement;
    }

    public void setDisplacement(double displacement) {
        this.displacement = displacement;
    }

    public String getDrive() {
        return drive;
    }

    public void setDrive(String drive) {
        this.drive = drive;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public int getHighwayMpg() {
        return highwayMpg;
    }

    public void setHighwayMpg(int highwayMpg) {
        this.highwayMpg = highwayMpg;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
