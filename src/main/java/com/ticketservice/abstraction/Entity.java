package com.ticketservice.abstraction;

public abstract class Entity {

    private long id;

    public Entity() {

    }

    public Entity(long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void print(){
        System.out.println("print content in console: ");
    }
}
