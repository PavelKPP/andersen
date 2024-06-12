package com.ticketservice.service;

import com.ticketservice.annotation.NullableWarningAnnotation;
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

    public static void main(String[] args) {
        TicketService ticketService = new TicketService();
        NullableWarningAnnotation.checkFieldsForNull(new Ticket());
        Ticket ticketWitNoParams = new Ticket();
        Ticket ticket = new Ticket(1111L, "main", (short) 232, LocalDateTime.now(),
                false, 'C',
                0.0, new BigDecimal(99.9));
        ticketsStorage.put(ticketWitNoParams.getId(), ticketWitNoParams);
        ticketsStorage.put(ticket.getId(), ticket);

        ticketWitNoParams.shareByPhone("+1 438 394 3562");
        ticket.shareByEmail("kuzhelpavlo@gmail.com", "test", "test");

        NullableWarningAnnotation.checkFieldsForNull(new Ticket());






    }

}
