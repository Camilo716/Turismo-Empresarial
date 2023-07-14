package org.example.Models;

import org.example.Validators.IValidable;
import org.example.Validators.StringRangeValidator;

import java.time.LocalDate;

public class Company {
    private Integer id;
    private String nit;
    private String description;
    private String name;
    private LocalDate location;

    private IValidable<String> lengthBetween0And10Validator;
    private IValidable<String> lengthBetween0And30Validator;

    public Company(Integer id, String nit, String name, LocalDate location, String description) {
        this.id = id;
        this.nit = nit;
        this.name = name;
        this.location = location;
        this.description = description;

        lengthBetween0And10Validator = new StringRangeValidator(0,10);
        lengthBetween0And30Validator = new StringRangeValidator(0,30);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        try {
            lengthBetween0And10Validator.validate(nit);
            this.nit = nit;
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        try {
            lengthBetween0And30Validator.validate(nit);
            this.name = name;
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    public LocalDate getLocation() {
        return location;
    }

    public void setLocation(LocalDate location) {
        this.location = location;
    }
}
