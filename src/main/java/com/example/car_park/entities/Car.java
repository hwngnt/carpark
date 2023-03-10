package com.example.car_park.entities;

import com.example.car_park.entities.dto.CarDTO;
import com.example.car_park.service.ParkinglotService;
import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;

import java.util.Set;

@Entity
@Table(name = "car")
public class Car {
    @Id
    private String licensePlate;    //Biển xe
    private String carColor;    //Màu xe
    private String carType;     //Lọai xe
    private String company;     //Công ty

    //car - parkinglot quan hệ (n - 1)
    @ManyToOne
    @JoinColumn(name = "parkId")    //parkId: khóa ngoại của table car
    private Parkinglot parkingLot;

    //car - ticket quan hệ (1 - n)
    @OneToMany(mappedBy = "car", cascade = CascadeType.REMOVE)    //Map với thuộc tính car trong Ticket
    private Set<Ticket> tickets;

    public String getLicensePlate() {
        return licensePlate;
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

    public Parkinglot getParkingLot() {
        return parkingLot;
    }

    public void setParkingLot(Parkinglot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public Set<Ticket> getTicketList() {
        return tickets;
    }

    public void setTicketList(Set<Ticket> ticketList) {
        this.tickets = ticketList;
    }
}
