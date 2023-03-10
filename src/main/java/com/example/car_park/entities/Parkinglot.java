package com.example.car_park.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;

import java.util.Set;

@Entity
@Table(name = "parkinglot")
public class Parkinglot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long parkId;
    private int parkArea; // khu vực đỗ
    private String parkName; // tên chỗ đỗ
    private String parkPlace; // vị trí
    private int parkPrice; // giá
    private String parkStatus; // trạng thái
    @OneToMany(mappedBy = "parkingLot", cascade = CascadeType.REMOVE)
    private Set<Car> cars;

    public Set<Car> getCars() {
        return cars;
    }

    public void setCars(Set<Car> cars) {
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
