package com.ticketservice.model;

import com.ticketservice.abstraction.Entity;
import com.ticketservice.abstraction.Share;
import com.ticketservice.validators.EmailAdressValidator;
import com.ticketservice.validators.PhoneNumberValidator;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ticket extends Entity implements Share {

    private String concertHall;
    private short eventCode;//
    private LocalDateTime creationDateTime;//
    private boolean isPromo;//
    private char stadiumSector;//
    private double maxBackpackWeight;
    private BigDecimal price;//


    public Ticket() {

    }

    public Ticket(Long id, String concertHall, short eventCode,
                  LocalDateTime creationDateTime, boolean isPromo, char stadiumSector,
                  double maxBackpackWeight, BigDecimal price) {

        super(id);
        if(concertHall.length() > 10) {
            throw new IllegalArgumentException("max chars of concertHall should be les than 10");
        } else {
            this.concertHall = concertHall;
        }
        if (eventCode / 100 > 9) {
            throw new IllegalArgumentException("event code should be less than 4 digits");
        } else {
            this.eventCode = eventCode;
        }
        if (stadiumSector > 'C' || stadiumSector < 'A') {
            throw new IllegalArgumentException("sector should be in between of A to C");
        } else {
            this.stadiumSector = stadiumSector;
        }

        this.creationDateTime = LocalDateTime.now();
        this.isPromo = isPromo;
        this.maxBackpackWeight = maxBackpackWeight;
        this.price = price;
    }

    public Ticket(boolean isPromo, char stadiumSector, BigDecimal price){
        this.isPromo = isPromo;
        this.stadiumSector = stadiumSector;
        this.price = price;
    }


    public String getConcertHall() {
        return concertHall;
    }

    public short getEventCode() {
        return eventCode;
    }

    public LocalDateTime getCreationDateTime() {
        return creationDateTime;
    }

    public void setCreationDateTime(LocalDateTime creationDateTime) {
        this.creationDateTime = creationDateTime;
    }

    public boolean isPromo() {
        return isPromo;
    }

    public char getStadiumSector() {
        return stadiumSector;
    }

    public void setStadiumSector(char stadiumSector) {
        if (stadiumSector < 'A' || stadiumSector > 'C' ) {
            throw new IllegalArgumentException("sector should be in between of A to C");
        }
        this.stadiumSector = stadiumSector;
    }

    public double getMaxBackpackWeight() {
        return maxBackpackWeight;
    }


    public BigDecimal getPrice() {
        return price;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ticket ticket = (Ticket) o;

        return (Objects.equals(ticket.concertHall, concertHall)) &&
        (Objects.equals(ticket.eventCode, eventCode)) &&
        (Objects.equals(ticket.creationDateTime, creationDateTime)) &&
        (Objects.equals(ticket.price, price)) &&
        (ticket.stadiumSector == stadiumSector) &&
        (ticket.isPromo == isPromo) &&
        Double.compare(ticket.maxBackpackWeight, maxBackpackWeight) == 0;


    }

    @Override
    public int hashCode() {
         int result = 0;
         result = 31 * result + (creationDateTime != null ? creationDateTime.hashCode() : 0);
         result = 31 * result + (isPromo ? 1 : 0);
         result = 31 * result + (price != null ? price.hashCode() : 0);
         result = 31 * result + (concertHall != null ? concertHall.hashCode() : 0);
         if (Objects.nonNull(eventCode)) {
            result = 31 * result + Short.hashCode(eventCode);
         } else {
             result = 0;
         }
         if (Objects.nonNull(stadiumSector)) {
             result = 31 * result + Character.hashCode(stadiumSector);
         } else {
             result = 0;
         }
         if (Objects.nonNull(maxBackpackWeight)) {
             result = 31 * result + Double.hashCode(maxBackpackWeight);
         } else {
             result = 0;
         }

         return result;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" +
                ", concertHall='" + concertHall + '\'' +
                ", eventCode=" + eventCode +
                ", creationDateTime=" + creationDateTime +
                ", isPromo=" + isPromo +
                ", stadiumSector=" + stadiumSector +
                ", maxBackpackWeight=" + maxBackpackWeight +
                ", price=" + price +
                '}';
    }


    @Override
    public void shareByPhone(String phoneNumber) {
        if(PhoneNumberValidator.validatePhoneNumber(phoneNumber)){
            System.out.println("Ticket was successfully sent via Phone Number: " + phoneNumber);
        } else {
            throw new IllegalArgumentException("Phone number does not exists!");
        }

    }

    @Override
    public void shareByEmail(String emailAddress, String subjectOfEmail, String textOfEmail) {
        if(EmailAdressValidator.validateEmail(emailAddress)){
            System.out.println("Ticket was successfully sent via Email: " + emailAddress);
        } else {
            throw new IllegalArgumentException("Email address does not exists");
        }
    }
}
