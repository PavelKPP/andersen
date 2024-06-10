package com.ticketservice.abstraction;

public abstract class User extends Entity {
    public User() {

    }

    public User(Long id) {
        super(id);
    }

    public void displayRole() {
        System.out.println("role of current user is: ");
    }
}
