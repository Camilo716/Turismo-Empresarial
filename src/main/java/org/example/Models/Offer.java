package org.example.Models;
import org.example.Validators.DateValidator;
import org.example.Validators.IValidable;
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
    private IValidable<String> formatDateValidator;

    public Offer(Integer id, String tittle, String description, LocalDate startDate, LocalDate endDate, Double costPerPerson, Integer idLocal) {
        this.id = id;
        this.tittle = tittle;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.costPerPerson = costPerPerson;

        lengthBetween0And20Validator = new StringRangeValidator(0,20);
        formatDateValidator = new DateValidator();
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
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        try{
            formatDateValidator.validate(startDate);
            this.startDate = LocalDate.parse(startDate, dateFormatter);
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        try{
            formatDateValidator.validate(endDate);
            LocalDate parsedDate = LocalDate.parse(endDate, dateFormatter);

            if (parsedDate.isAfter(this.startDate))
                this.endDate = parsedDate;
            else throw new Exception("End date should be after start date");
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    public Double getCostPerPerson() {
        return costPerPerson;
    }

    public void setCostPerPerson(Double costPerPerson) {
        this.costPerPerson = costPerPerson;
    }

    public Integer getLocalId() {
        return localId;
    }

    public void setLocalId(Integer localId) {
        this.localId = localId;
    }
}

