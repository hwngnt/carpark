package com.example.car_park.entities.dto;

import com.example.car_park.entities.BookingOffice;

import java.util.Date;

public class BookingOfficeDTO {
    private int officeId;
    private Date endContractDeadline;
    private String officeName;
    private String officePhone;
    private String officePlace;
    private int officePrice;
    private Date startContractDeadline;
    private Long tripId;

    public BookingOfficeDTO(BookingOffice bookingOffice){
        this.officeId = bookingOffice.getOfficeId();
        this.endContractDeadline = bookingOffice.getEndContractDeadline();
        this.officeName = bookingOffice.getOfficeName();
        this.officePhone = bookingOffice.getOfficePhone();
        this.officePlace = bookingOffice.getOfficePlace();
        this.officePrice = bookingOffice.getOfficePrice();
        this.startContractDeadline = bookingOffice.getStartContractDeadline();
        this.tripId = bookingOffice.getTrip().getTripId();
    }

    public int getOfficeId() {
        return officeId;
    }

    public void setOfficeId(int officeId) {
        this.officeId = officeId;
    }

    public Date getEndContractDeadline() {
        return endContractDeadline;
    }

    public void setEndContractDeadline(Date endContractDeadline) {
        this.endContractDeadline = endContractDeadline;
    }

    public String getOfficeName() {
        return officeName;
    }

    public void setOfficeName(String officeName) {
        this.officeName = officeName;
    }

    public String getOfficePhone() {
        return officePhone;
    }

    public void setOfficePhone(String officePhone) {
        this.officePhone = officePhone;
    }

    public String getOfficePlace() {
        return officePlace;
    }

    public void setOfficePlace(String officePlace) {
        this.officePlace = officePlace;
    }

    public int getOfficePrice() {
        return officePrice;
    }

    public void setOfficePrice(int officePrice) {
        this.officePrice = officePrice;
    }

    public Date getStartContractDeadline() {
        return startContractDeadline;
    }

    public void setStartContractDeadline(Date startContractDeadline) {
        this.startContractDeadline = startContractDeadline;
    }

    public Long getTripId() {
        return tripId;
    }

    public void setTripId(Long tripId) {
        this.tripId = tripId;
    }
}
