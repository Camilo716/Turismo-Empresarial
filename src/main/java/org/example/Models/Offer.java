package org.example.Models;
import org.example.Util.DateParser;
import org.example.Validators.DateValidator;
import org.example.Validators.IValidable;
import org.example.Validators.NumRangeValidator;
import org.example.Validators.StringRangeValidator;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;


public class Offer {
    private Integer id;
    private  String tittle;
    private  String description;
    private LocalDate startDate;
    private LocalDate endDate;
    private Double costPerPerson;

    private Integer localId;

    private final IValidable<String> lengthBetween0And20Validator;
    private final IValidable<String> formatDateValidator;
    private final IValidable<Double> positiveNumberValidator;

    public Offer(Integer id, String tittle, String description, LocalDate startDate, LocalDate endDate, Double costPerPerson, Integer idLocal) {
        this.id = id;
        this.tittle = tittle;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.costPerPerson = costPerPerson;

        lengthBetween0And20Validator = new StringRangeValidator(0,20);
        formatDateValidator = new DateValidator();
        positiveNumberValidator = new NumRangeValidator(0.0, Double.MAX_VALUE);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        try{
            lengthBetween0And20Validator.validate(tittle);
            this.tittle = tittle;
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        try{
            formatDateValidator.validate(startDate);
            this.startDate = DateParser.fromStringToDate(startDate, "dd/MM/yyyy");
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        try{
            formatDateValidator.validate(endDate);
            LocalDate parsedDate = DateParser.fromStringToDate(endDate, "dd/MM/yyyy");
            DateValidator.date1_isAfter_date2(parsedDate, this.startDate);
            this.endDate = parsedDate;
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    public Double getCostPerPerson() {
        return costPerPerson;
    }

    public void setCostPerPerson(Double costPerPerson) {
        try{
            positiveNumberValidator.validate(costPerPerson);
            this.costPerPerson = costPerPerson;
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    public Integer getLocalId() {
        return localId;
    }

    public void setLocalId(Integer localId) {
        this.localId = localId;
    }
}

