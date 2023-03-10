package com.example.car_park.entities.dto;

import com.example.car_park.entities.Trip;

import java.sql.Time;
import java.util.Date;

public class TripDTO {
    private long tripId;
    private int bookedTicketNumber;
    private String carType;
    private Date departureDate;
    private Time departureTime;
    private String destination;
    private String driver;
    private int maximumOnlineTicketNumber;
    private int tickets;
    private int bookingOffice;

    public TripDTO(Trip trip){
        this.tripId = trip.getTripId();
        this.bookedTicketNumber = trip.getBookedTicketNumber();
        this.carType = trip.getCarType();
        this.departureDate = trip.getDepartureDate();
        this.departureTime = trip.getDepartureTime();
        this.destination = trip.getDestination();
        this.driver = trip.getDriver();
        this.maximumOnlineTicketNumber = trip.getMaximumOnlineTicketNumber();
        if(trip.getTickets() == null){
            this.tickets = 0;
        } else {
            this.tickets = trip.getTickets().size();
        }
        if(trip.getBookingOffices() == null){
            this.bookingOffice = 0;
        } else {
            this.bookingOffice = trip.getBookingOffices().size();
        }
    }

    public int getTickets() {
        return tickets;
    }

    public void setTickets(int tickets) {
        this.tickets = tickets;
    }

    public int getBookingOffice() {
        return bookingOffice;
    }

    public void setBookingOffice(int bookingOffice) {
        this.bookingOffice = bookingOffice;
    }

    public long getTripId() {
        return tripId;
    }

    public void setTripId(long tripId) {
        this.tripId = tripId;
    }

    public int getBookedTicketNumber() {
        return bookedTicketNumber;
    }

    public void setBookedTicketNumber(int bookedTicketNumber) {
        this.bookedTicketNumber = bookedTicketNumber;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public Time getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Time departureTime) {
        this.departureTime = departureTime;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public int getMaximumOnlineTicketNumber() {
        return maximumOnlineTicketNumber;
    }

    public void setMaximumOnlineTicketNumber(int maximumOnlineTicketNumber) {
        this.maximumOnlineTicketNumber = maximumOnlineTicketNumber;
    }
}
