package com.example.car_park.controller;

import com.example.car_park.entities.Car;
import com.example.car_park.entities.dto.CarDTO;
import com.example.car_park.service.CarService;
import com.example.car_park.service.ParkinglotService;
import com.example.car_park.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/car")
public class CarController {
    @Autowired
    private CarService carService;

    @GetMapping
    public List<CarDTO> getAllCar(){
        return carService.selectAllCar();
    }

    @GetMapping("/licenseplage/{licensePlate}")
    public CarDTO getCarByLicensePlate(@PathVariable String licensePlate){
        return carService.selectByLicensePlateDTO(licensePlate);
    }

    @PostMapping("/parkinglot/{id}")
    public CarDTO addCar(@RequestBody Car car, @PathVariable long id){
        return carService.addCar(car, id);
    }

    @DeleteMapping("/{licensePlate}")
    public String deleteCar(@PathVariable String licensePlate) {
        return carService.deleteCar(licensePlate);
    }

    @GetMapping("/filter")
    public List<CarDTO> filter(@RequestParam(name = "offset", defaultValue = "0", required = true) int offset,
                            @RequestParam(name = "limit", defaultValue = "2", required = true) int limit,
                            @RequestParam(name = "searchField", defaultValue = "company", required = true) String field,
                            @RequestParam(name = "searchValue", defaultValue = "%%", required = false) String searchName){
        return carService.getAllCars("%"+searchName+"%", field, offset, limit);
    }
}
