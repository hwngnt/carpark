package com.example.car_park.controller;

import com.example.car_park.entities.BookingOffice;
import com.example.car_park.entities.dto.BookingOfficeDTO;
import com.example.car_park.entities.dto.EmployeeDTO;
import com.example.car_park.service.BookingOfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bookoffice")
public class BookingOfficeController {
    @Autowired
    private BookingOfficeService bookingOfficeService;

    @GetMapping
    public List<BookingOfficeDTO> getAllBookingOffice(){
        return bookingOfficeService.selectAllBookingOffice();
    }

    @GetMapping("/{id}")
    public BookingOfficeDTO getBookingOfficeById(long id){
        return bookingOfficeService.selectById(id);
    }
    @PostMapping("/trip/{id}")
    public BookingOfficeDTO addBookingOffice(@RequestBody BookingOffice bookingOffice,
                                          @PathVariable long id){

        return bookingOfficeService.addBookingOffice(bookingOffice, id);
    }

    @DeleteMapping("/{id}")
    public String deleteBookinOffice(@PathVariable long id){
        return bookingOfficeService.deleteBookingOffice(id);
    }
    @GetMapping("/filter")
    public List<BookingOfficeDTO> filter(@RequestParam(name = "offset", defaultValue = "0", required = true) int offset,
                                    @RequestParam(name = "limit", defaultValue = "2", required = true) int limit,
                                    @RequestParam(name = "searchField", defaultValue = "office_name", required = true) String field,
                                    @RequestParam(name = "searchValue", defaultValue = "%%", required = false) String searchName){
        return bookingOfficeService.getAllBookingOffice("%"+searchName+"%", field, offset, limit);
    }
}
