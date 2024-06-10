package com.ticketservice.model;

import com.ticketservice.abstraction.User;
import com.ticketservice.enums.Role;

public class Client extends User {

    private Ticket ticket;
    private Role role;

    public Client() {

    }

    public Client(Long id) {
        super(id);
        this.role = Role.CLIENT;
    }

    @Override
    public void displayRole() {
        System.out.println("role of current user is:" + role);
    }

    public void getTicket(Ticket ticket) {
        this.ticket = ticket;
        System.out.println("Ticket of " + role + "is: " + ticket);
    }


}
