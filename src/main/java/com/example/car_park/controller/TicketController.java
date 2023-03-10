package com.example.car_park.controller;

import com.example.car_park.entities.Ticket;
import com.example.car_park.entities.dto.TicketDTO;
import com.example.car_park.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ticket")
public class TicketController {
    @Autowired
    private TicketService ticketService;

    @GetMapping
    public List<TicketDTO> getAllTicket(){
        return ticketService.selectAllTicket();
    }

    @GetMapping("/ticket/{id}")
    public TicketDTO getTicketById(@PathVariable long id){
        return ticketService.selectTicketById(id);
    }

    @PostMapping("/trip/{tripId}/car/{licensePlate}")
    public TicketDTO addTicket(@RequestBody Ticket ticket,
                            @PathVariable long tripId,
                            @PathVariable String licensePlate){
        return ticketService.addTicket(ticket, tripId, licensePlate);
    }

    @DeleteMapping("/{id}")
    public String deleteTicket(@PathVariable long id){
        ticketService.deleteTicket(id);
        return "Deleted";
    }
}
