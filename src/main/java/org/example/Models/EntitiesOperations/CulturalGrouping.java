package org.example.Models.EntitiesOperations;

import org.example.Models.AbstractEntities.Company;

import java.time.LocalDate;

public class CulturalGrouping extends Company {

    private String description;

    public CulturalGrouping(Integer id, String nit, String name, LocalDate location, String description) {
        super(id, nit, name, location);
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}
