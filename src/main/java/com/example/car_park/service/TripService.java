package com.example.car_park.service;

import com.example.car_park.entities.Employee;
import com.example.car_park.entities.Trip;
import com.example.car_park.entities.dto.EmployeeDTO;
import com.example.car_park.entities.dto.TripDTO;
import com.example.car_park.exception.NotFoundException;
import com.example.car_park.repository.TripRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TripService {
    @Autowired
    private TripRepository tripRepository;

    @Autowired
    private EntityManager em;

    public List<TripDTO> selectAllTrip(){
        List<Trip> trips = tripRepository.findAll();
        List<TripDTO> tripDTOS = new ArrayList<>();
        for(Trip trip : trips){
            tripDTOS.add(new TripDTO(trip));
        }
        return tripDTOS;
    }

    public TripDTO selectByIdDTO(long id){
        Optional<Trip> tripOptional = tripRepository.findById(id);
        if(tripOptional.isPresent()){
            return new TripDTO(tripOptional.get());
        }else{
            throw new NotFoundException("Trip id = " + id + " not found");
        }
    }

    public Trip selectById(long id){
        Optional<Trip> tripOptional = tripRepository.findById(id);
        if(tripOptional.isPresent()){
            return tripOptional.get();
        } else {
            throw new NotFoundException("Trip id = " + id + " not found");
        }
    }

    public TripDTO addTrip(Trip trip){
        tripRepository.save(trip);
        return new TripDTO(trip);
    }

    public String deleteTrip(long id){
        tripRepository.deleteById(id);
        return "Deleted";
    }

    public List<TripDTO> getAllTrips(String searchName, String field, int offset, int limit) {
        String sql = "select t from Trip t where " + field + " like :search";
        StringBuilder query = new StringBuilder(sql);

        TypedQuery<Trip> tripTypedQuery = em.createQuery(query.toString(), Trip.class);
        tripTypedQuery.setParameter("search", searchName);
        tripTypedQuery.setFirstResult(offset);
        tripTypedQuery.setMaxResults(limit);
        List<Trip> trips = tripTypedQuery.getResultList();
        List<TripDTO> tripDTOS = new ArrayList<>();
        for (Trip t : trips) {
            tripDTOS.add(new TripDTO(t));
        }
        return tripDTOS;
    }
}
