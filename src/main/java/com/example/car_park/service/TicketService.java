package com.example.car_park.service;

import com.example.car_park.entities.Car;
import com.example.car_park.entities.Ticket;
import com.example.car_park.entities.dto.CarDTO;
import com.example.car_park.entities.dto.TicketDTO;
import com.example.car_park.exception.NotFoundException;
import com.example.car_park.repository.TicketRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TicketService {
    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private TripService tripService;

    @Autowired
    private CarService carService;

    @Autowired
    private EntityManager em;

    // Select all
    public List<TicketDTO> selectAllTicket(){
        List<Ticket> tickets = ticketRepository.findAll();
        List<TicketDTO> ticketDTOS = new ArrayList<>();
        for(Ticket ticket : tickets){
            ticketDTOS.add(new TicketDTO(ticket));
        }
        return ticketDTOS;
    }

    // Select theo id
    public TicketDTO selectTicketById(long id){
        Optional<Ticket> ticketOptional = ticketRepository.findById(id);
        if(ticketOptional.isPresent()){
            return new TicketDTO(ticketOptional.get());
        } else {
            throw new NotFoundException("Ticket not found");
        }
    }

    // Add
    public TicketDTO addTicket(Ticket ticket, long tripId, String licensePlate){
        if(tripService.selectById(tripId).equals(null)){
            throw new NotFoundException("Trip id = " + tripId + " not found");
        } else if (carService.selectByLicensePlate(licensePlate).equals(null)){
            throw new NotFoundException("Car license plate = " + licensePlate + " not found");
        } else {
            ticket.setTrip(tripService.selectById(tripId));
            ticket.setCar(carService.selectByLicensePlate(licensePlate));
            ticketRepository.save(ticket);
            return new TicketDTO(ticket);
        }
    }

    // Delete ticket theo id
    public void deleteTicket(long id){
        Optional<Ticket> ticketOptional = ticketRepository.findById(id);
        if(ticketOptional.isPresent()){
            ticketRepository.delete(ticketOptional.get());
        } else {
            throw new NotFoundException("Ticket not found");
        }
    }

    public List<TicketDTO> getAllTicket(String searchName, String field, int offset, int limit) {
        String sql = "select t from Ticket t where " + field + " like :search";
        StringBuilder query = new StringBuilder(sql);

        TypedQuery<Ticket> ticketTypedQuery = em.createQuery(query.toString(), Ticket.class);
        ticketTypedQuery.setParameter("search", searchName);
        ticketTypedQuery.setFirstResult(offset);
        ticketTypedQuery.setMaxResults(limit);
        List<Ticket> tickets = ticketTypedQuery.getResultList();
        List<TicketDTO> ticketDTOS = new ArrayList<>();
        for(Ticket t : tickets){
            ticketDTOS.add(new TicketDTO(t));
        }
        return  ticketDTOS;
    }
}
