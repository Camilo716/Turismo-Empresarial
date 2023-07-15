package org.example.Models;

import org.example.Util.DateParser;
import org.example.Validators.DateValidator;
import org.example.Validators.IValidable;

import java.time.LocalDate;

public class Reservation {

    private Integer id;
    private Double totalCost;
    private LocalDate reservationDate;

    private Integer userId;
    private Integer offerId;

    IValidable<String> dateFormatValidator;

    public Reservation(Integer id, Integer userId, Integer offerId, Double totalCost, LocalDate reservationDate) {
        this.id = id;
        this.userId = userId;
        this.offerId = offerId;
        this.totalCost = totalCost;
        this.reservationDate = reservationDate;

        dateFormatValidator = new DateValidator();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getOfferId() {
        return offerId;
    }

    public void setOfferId(Integer offerId) {
        this.offerId = offerId;
    }

    public Double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(Double totalCost) {
        this.totalCost = totalCost;
    }

    public LocalDate getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(String reservationDate) {
        try{
            dateFormatValidator.validate(reservationDate);
            this.reservationDate = DateParser.fromStringToDate(reservationDate, "dd/MM/yyyy");
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}
