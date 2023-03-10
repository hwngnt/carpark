package com.example.car_park.entities.dto;

import com.example.car_park.entities.Ticket;

import java.sql.Time;

public class TicketDTO {
    private int ticketId;
    private Time bookingTime;
    private String customerName;
    private String licensePlate;
    private Long tripId;

    public TicketDTO(Ticket ticket){
        this.ticketId = ticket.getTicketId();
        this.bookingTime = ticket.getBookingTime();
        this.customerName = ticket.getCustomerName();
        this.licensePlate = ticket.getCar().getLicensePlate();
        this.tripId = ticket.getTrip().getTripId();
    }

    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public Time getBookingTime() {
        return bookingTime;
    }

    public void setBookingTime(Time bookingTime) {
        this.bookingTime = bookingTime;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public Long getTripId() {
        return tripId;
    }

    public void setTripId(Long tripId) {
        this.tripId = tripId;
    }
}
