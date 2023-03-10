package com.example.car_park.repository;

import com.example.car_park.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, String>{

}
