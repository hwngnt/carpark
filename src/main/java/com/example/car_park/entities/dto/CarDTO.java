package com.example.car_park.entities.dto;

import com.example.car_park.entities.Car;

public class CarDTO {
    private String licensePlate;    //Biển xe
    private String carColor;    //Màu xe
    private String carType;     //Lọai xe
    private String company;     //Công ty
    private Long parkinglotId;

    public CarDTO(Car car){
        this.licensePlate = car.getLicensePlate();
        this.carColor = car.getCarColor();
        this.carType = car.getCarType();
        this.company = car.getCompany();
        this.parkinglotId = car.getParkingLot().getParkId();
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getCarColor() {
        return carColor;
    }

    public void setCarColor(String carColor) {
        this.carColor = carColor;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Long getParkinglotId() {
        return parkinglotId;
    }

    public void setParkinglotId(Long parkinglotId) {
        this.parkinglotId = parkinglotId;
    }
}
