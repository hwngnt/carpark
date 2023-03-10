package com.example.car_park.controller;

import com.example.car_park.entities.Trip;
import com.example.car_park.entities.dto.EmployeeDTO;
import com.example.car_park.entities.dto.TripDTO;
import com.example.car_park.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trip")
public class TripController {
    @Autowired
    private TripService tripService;

    @GetMapping
    public List<TripDTO> getAllTrip(){
        return tripService.selectAllTrip();
    }

    @GetMapping("/trip/{id}")
    public TripDTO getTripById(@PathVariable long id){
        return tripService.selectByIdDTO(id);
    }

    @PostMapping
    public TripDTO addTrip(@RequestBody Trip trip){
        return tripService.addTrip(trip);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable long id) {
        return tripService.deleteTrip(id);
    }

    @GetMapping("/filter")
    public List<TripDTO> filter(@RequestParam(name = "offset", defaultValue = "0", required = true) int offset,
                                    @RequestParam(name = "limit", defaultValue = "2", required = true) int limit,
                                    @RequestParam(name = "searchField", defaultValue = "car_type", required = true) String field,
                                    @RequestParam(name = "searchValue", defaultValue = "%%", required = false) String searchName){
        return tripService.getAllTrips("%"+searchName+"%", field, offset, limit);
    }
}
