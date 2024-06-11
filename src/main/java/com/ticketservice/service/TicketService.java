package com.ticketservice.service;

import com.ticketservice.model.Ticket;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;


public class TicketService {

    private static HashMap<Long, Ticket> ticketsStorage;

    public TicketService() {
        this.ticketsStorage = new HashMap<>();
    }


    public static void main(String[] args) {

    }

    public Ticket findById(String idOfTheTicket) {
        if (ticketsStorage.containsKey(idOfTheTicket)) {
            return ticketsStorage.get(idOfTheTicket);
        } else {
            throw new IllegalArgumentException("Ticket with such id not found");
        }
    }

    public List<Ticket> findByStadiumSector(char stadiumSector) {
        return ticketsStorage.values()
                .stream()
                .filter(ticket -> ticket.getStadiumSector() == stadiumSector)
                .collect(Collectors.toList());
    }

}
