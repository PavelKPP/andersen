package com.ticketservice.abstraction;

public interface Share {

    public void shareByPhone(String phoneNumber);

    public void shareByEmail(String emailAddress, String subjectOfEmail, String textOfEmail);
}
