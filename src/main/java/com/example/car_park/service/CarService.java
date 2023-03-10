package com.example.car_park.service;

import com.example.car_park.entities.Car;
import com.example.car_park.entities.dto.CarDTO;
import com.example.car_park.exception.NotFoundException;
import com.example.car_park.repository.CarRepository;
import com.example.car_park.repository.ParkinglotRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.parser.Entity;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CarService {
    @Autowired
    private CarRepository carRepository;

    @Autowired
    private EntityManager em;

    @Autowired
    private ParkinglotService parkinglotService;

    // Select tất cả các Car
    public List<CarDTO> selectAllCar(){
        List<Car> cars = carRepository.findAll();
        List<CarDTO> carDTOS = new ArrayList<>();
        for(Car c : cars){
            carDTOS.add(new CarDTO(c));
        }
        return  carDTOS;
    }

    // Select theo BLX
    public CarDTO selectByLicensePlateDTO(String licensePlate){
        Optional<Car> carOptional = carRepository.findById(licensePlate);
        if(carOptional.isPresent()){
            return new CarDTO(carOptional.get());
        } else {
            throw new NotFoundException("Car license plate = " + licensePlate + " not found");
        }
    }

    public Car selectByLicensePlate(String licensePlate){
        Optional<Car> carOptional = carRepository.findById(licensePlate);
        if(carOptional.isPresent()){
            return carOptional.get();
        } else {
            throw new NotFoundException("Car license plate = " + licensePlate + " not found");
        }
    }

    // Add
    public CarDTO addCar(Car car, long id){
        if(parkinglotService.selectParkinglotByIdToDTO(id).equals(null)){
            throw new NotFoundException("Parking lot id = " + id + " not found");
        } else {
            car.setParkingLot(parkinglotService.selectParkingLotById(id));
            carRepository.save(car);
            return new CarDTO(car);
        }
    }

    public String deleteCar(String licensePlate){
        Car c = carRepository.findById(licensePlate).orElseThrow(
                () -> new NotFoundException("Car license plate = " + licensePlate + " not found"));

        carRepository.deleteById(licensePlate);
        return "Deleted";
    }

    public List<CarDTO> getAllCars(String searchName, String field, int offset, int limit) {
        String sql = "select c from Car c where " + field + " like :search";
        StringBuilder query = new StringBuilder(sql);

        TypedQuery<Car> cars = em.createQuery(query.toString(), Car.class);
        cars.setParameter("search", searchName);
        cars.setFirstResult(offset);
        cars.setMaxResults(limit);
        List<Car> carList = cars.getResultList();
        List<CarDTO> carDTOS = new ArrayList<>();
        for(Car c : carList){
            carDTOS.add(new CarDTO(c));
        }
        return  carDTOS;
    }
}
