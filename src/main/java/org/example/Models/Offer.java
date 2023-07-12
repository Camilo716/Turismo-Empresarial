package org.example.Models;
import java.time.LocalDate;


public class Offer {
    private Integer id;

    private  String tittle;

    private  String description;

    private LocalDate startDate;

    private LocalDate endDate;

    private Double costPerPerson;


    public Offer(Integer id, String tittle, String description, LocalDate startDate, LocalDate endDate, Double costPerPerson, Integer idLocal) {
        this.id = id;
        this.tittle = tittle;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.costPerPerson = costPerPerson;
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
        this.tittle = tittle;
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

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Double getCostPerPerson() {
        return costPerPerson;
    }

    public void setCostPerPerson(Double costPerPerson) {
        this.costPerPerson = costPerPerson;
    }
}

