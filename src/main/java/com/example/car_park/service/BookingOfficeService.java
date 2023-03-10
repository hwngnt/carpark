package com.example.car_park.service;

import com.example.car_park.entities.BookingOffice;
import com.example.car_park.entities.dto.BookingOfficeDTO;
import com.example.car_park.exception.NotFoundException;
import com.example.car_park.repository.BookingOfficeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookingOfficeService {
    @Autowired
    private BookingOfficeRepository bookingOfficeRepository;

    @Autowired
    private TripService tripService;

    // Select toàn bộ BookingOffice
    public List<BookingOfficeDTO> selectAllBookingOffice(){
        List<BookingOffice> bookingOffices = bookingOfficeRepository.findAll();
        List<BookingOfficeDTO> bookingOfficeDTOS = new ArrayList<>();
        for(BookingOffice bookingOffice : bookingOffices){
            bookingOfficeDTOS.add(new BookingOfficeDTO(bookingOffice));
        }
        return bookingOfficeDTOS;
    }

    // Select theo Id
    public BookingOfficeDTO selectById(long id){
        Optional<BookingOffice> bookingOfficeOptional = bookingOfficeRepository.findById(id);
        if(bookingOfficeOptional.isPresent()){
            return new BookingOfficeDTO(bookingOfficeOptional.get());
        } else {
            throw new NotFoundException("BookingOffice id = " + id + " not found");
        }
    }

    // Add
    public BookingOfficeDTO addBookingOffice(BookingOffice bookingOffice, long id){
        if(tripService.selectById(id).equals(null)){
            throw new NotFoundException("Trip id = " + id + " not found");
        } else {
            bookingOffice.setTrip(tripService.selectById(id));
            bookingOfficeRepository.save(bookingOffice);
            return new BookingOfficeDTO(bookingOffice);
        }
    }

    public String deleteBookingOffice(long id){
        bookingOfficeRepository.deleteById(id);
        return "Deleted";
    }
}
