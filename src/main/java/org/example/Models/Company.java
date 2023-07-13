package org.example.Models;

import java.time.LocalDate;

public class Company {
    private Integer id;
    private String nit;
    private String description;
    private String name;
    private LocalDate location;

    public Company(Integer id, String nit, String name, LocalDate location, String description) {
        this.id = id;
        this.nit = nit;
        this.name = name;
        this.location = location;
        this.description = description;
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
        this.nit = nit;
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
        this.name = name;
    }

    public LocalDate getLocation() {
        return location;
    }

    public void setLocation(LocalDate location) {
        this.location = location;
    }
}
