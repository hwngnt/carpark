package com.example.car_park.service;

import com.example.car_park.entities.Car;
import com.example.car_park.entities.Parkinglot;
import com.example.car_park.entities.dto.CarDTO;
import com.example.car_park.entities.dto.ParkinglotDTO;
import com.example.car_park.exception.NotFoundException;
import com.example.car_park.repository.ParkinglotRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ParkinglotService {
    @Autowired
    private ParkinglotRepository parkinglotRepository;

    @Autowired
    private EntityManager em;

    //Select all parking lot
    public List<ParkinglotDTO> selectAllParkingLot(){
        List<Parkinglot> parkinglots = parkinglotRepository.findAll();
        List<ParkinglotDTO> parkinglotDTOS = new ArrayList<>();
        for(Parkinglot parkinglot : parkinglots){
            parkinglotDTOS.add(new ParkinglotDTO(parkinglot));
        }
        return parkinglotDTOS;
    }

    // Select theo id
    public ParkinglotDTO selectParkinglotByIdToDTO(long id){
        Optional<Parkinglot> parkinglotOptional = parkinglotRepository.findById(id);
        if(parkinglotOptional.isPresent()){
            return new ParkinglotDTO(parkinglotOptional.get());
        } else {
            throw new NotFoundException("Parkinglot not found");
        }
    }

    public Parkinglot selectParkingLotById(long id){
        Optional<Parkinglot> parkinglotOptional = parkinglotRepository.findById(id);
        if (parkinglotOptional.isPresent()){
            return parkinglotOptional.get();
        } else {
            throw new NotFoundException("Parkinglot not found");
        }
    }



    // Add
    public ParkinglotDTO addParkinglot(Parkinglot parkinglot){
        parkinglotRepository.save(parkinglot);
        return new ParkinglotDTO(parkinglot);
    }

    public String deleteParkinglot(long id){
        parkinglotRepository.deleteById(id);
        return "Deleted";
    }

    public List<ParkinglotDTO> getAllParkinglot(String searchName, String field, int offset, int limit) {
        String sql = "select p from Parkinglot p where " + field + " like :search";
        StringBuilder query = new StringBuilder(sql);

        TypedQuery<Parkinglot> parkinglotTypedQuery = em.createQuery(query.toString(), Parkinglot.class);
        parkinglotTypedQuery.setParameter("search", searchName);
        parkinglotTypedQuery.setFirstResult(offset);
        parkinglotTypedQuery.setMaxResults(limit);
        List<Parkinglot> parkinglots = parkinglotTypedQuery.getResultList();
        List<ParkinglotDTO> parkinglotDTOS = new ArrayList<>();
        for(Parkinglot p : parkinglots){
            parkinglotDTOS.add(new ParkinglotDTO(p));
        }
        return  parkinglotDTOS;
    }
}
