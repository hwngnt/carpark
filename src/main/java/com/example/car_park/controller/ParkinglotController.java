package com.example.car_park.controller;

import com.example.car_park.entities.Parkinglot;
import com.example.car_park.entities.dto.ParkinglotDTO;
import com.example.car_park.service.ParkinglotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/parkinglot")
public class ParkinglotController {
    @Autowired
    private ParkinglotService parkinglotService;

    //Select all parking lot
    @GetMapping
    public List<ParkinglotDTO> selectAllParkingLot(){
        return parkinglotService.selectAllParkingLot();
    }

    //Select by Id
    @GetMapping("/{id}")
    public ParkinglotDTO selectById(@PathVariable long id){
        return parkinglotService.selectParkinglotByIdToDTO(id);
    }

    //Add parking lot
    @PostMapping
    public ParkinglotDTO addParkingLot(@RequestBody Parkinglot parkingLot){
        return parkinglotService.addParkinglot(parkingLot);
    }

    @DeleteMapping("/{id}")
    public String deleteParkinglot(@PathVariable long id){
        return parkinglotService.deleteParkinglot(id);
    }
}
