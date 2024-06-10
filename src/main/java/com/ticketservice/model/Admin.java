package com.ticketservice.model;

import com.ticketservice.abstraction.User;
import com.ticketservice.enums.Role;

public class Admin extends User {

    private Role role;
    private Ticket tikcet;

    public Admin() {
    }

    public Admin(Long id) {
        super(id);
        this.role = Role.ADMIN;
    }

    @Override
    public void displayRole(){
        System.out.println("role of current user is:" + role);
    }

    public void validateTicket(Ticket ticket) {
        if(ticket.isPromo()){
            System.out.println("promo ticket");
        } else {
            System.out.println("regular ticket");
        }
    }

}
