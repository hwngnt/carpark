package com.example.car_park.entities.dto;

import com.example.car_park.entities.Parkinglot;

public class ParkinglotDTO {
    private Long parkId;
    private int parkArea; // khu vực đỗ
    private String parkName; // tên chỗ đỗ
    private String parkPlace; // vị trí
    private int parkPrice; // giá
    private String parkStatus; // trạng thái

    private int cars;

    public ParkinglotDTO(Parkinglot parkinglot){
        this.parkId = parkinglot.getParkId();
        this.parkArea = parkinglot.getParkArea();
        this.parkName = parkinglot.getParkName();
        this.parkPrice = parkinglot.getParkPrice();
        this.parkStatus = parkinglot.getParkName();
        this.parkPlace = parkinglot.getParkPlace();
        if(parkinglot.getCars() == null){
            this.cars = 0;
        } else {
            this.cars = parkinglot.getCars().size();
        }
    }

    public int getCars() {
        return cars;
    }

    public void setCars(int cars) {
        this.cars = cars;
    }

    public Long getParkId() {
        return parkId;
    }

    public void setParkId(Long parkId) {
        this.parkId = parkId;
    }

    public int getParkArea() {
        return parkArea;
    }

    public void setParkArea(int parkArea) {
        this.parkArea = parkArea;
    }

    public String getParkName() {
        return parkName;
    }

    public void setParkName(String parkName) {
        this.parkName = parkName;
    }

    public String getParkPlace() {
        return parkPlace;
    }

    public void setParkPlace(String parkPlace) {
        this.parkPlace = parkPlace;
    }

    public int getParkPrice() {
        return parkPrice;
    }

    public void setParkPrice(int parkPrice) {
        this.parkPrice = parkPrice;
    }

    public String getParkStatus() {
        return parkStatus;
    }

    public void setParkStatus(String parkStatus) {
        this.parkStatus = parkStatus;
    }
}
