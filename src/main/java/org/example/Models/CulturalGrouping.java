package org.example.Models;

import org.example.Models.AbstractEntities.Company;
import org.example.Models.EntitiesOperations.IDiscountable;
import org.example.Models.EntitiesOperations.IReportable;

import java.time.LocalDate;

public class CulturalGrouping extends Company implements IReportable, IDiscountable {

    private String description;

    public CulturalGrouping(Integer id, String nit, String name, String location, String description) {
        super(id, nit, name, location);
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public String generateReportCSV() {
        StringBuilder csvBuilder = new StringBuilder();

        csvBuilder.append("id,nit,name,location,description\n");
        csvBuilder.append(formatUserCSV(this));

        return csvBuilder.toString();
    }

    private static String formatUserCSV(CulturalGrouping culturalGrouping) {
        return String.format(
                "%d,%s,%s,%s,%s\n",
                culturalGrouping.getId(),
                culturalGrouping.getNit(),
                culturalGrouping.getName(),
                culturalGrouping.getLocation(),
                culturalGrouping.getDescription()
        );
    }

    @Override
    public Double generateDiscount() {
        return anualCost - monthlyCost * 0.25;
    }
}
