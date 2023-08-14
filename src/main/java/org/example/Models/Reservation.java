package org.example.Models;

import org.example.Models.AbstractEntities.User;
import org.example.Util.DateParser;
import org.example.Validators.DateValidator;
import org.example.Validators.IValidable;
import org.example.Validators.ListSizeRangeValidator;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Reservation {

    private Integer id;
    private Double totalCost;
    private LocalDate reservationDate;

    private Integer userId;
    private Integer offerId;

    private List<User> users = new ArrayList<>();

    IValidable<String> dateFormatValidator;
    IValidable<List<User>> max4UsersValidator;

    public Reservation(Integer id, Integer userId, Integer offerId, Double totalCost, LocalDate reservationDate) {
        this.id = id;
        this.userId = userId;
        this.offerId = offerId;
        this.totalCost = totalCost;
        this.reservationDate = reservationDate;

        dateFormatValidator = new DateValidator();
        max4UsersValidator = new ListSizeRangeValidator(0, 4);
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
        final double IVA = 0.19;

        for (User user : this.users) {
            totalCost+=offerId; // Price search per person according to offer id not implemented
        }
        this.totalCost = totalCost * IVA;
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

    public List<User> getUsers() {
        return users;
    }

    public void SetNewUser(User user) throws Exception {
        try {
            max4UsersValidator.validate(this.users);
            users.add(user);
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}
