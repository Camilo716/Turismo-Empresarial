package org.example.Models;

import org.example.Models.AbstractEntities.Company;
import org.example.Validators.IValidable;
import org.example.Validators.NumRangeValidator;
import org.example.Validators.StringRangeValidator;

import java.time.LocalDate;

public class PrivateCompany extends Company {

    private Integer idLegalRepresentative;
    private String nameLegalRepresentative;

    private final IValidable<Double> positiveNumberValidator;
    private final IValidable<String> min15CharValidator;

    public PrivateCompany(Integer id, String nit, String name, String location,
                          Integer idLegalRepresentative, String nameLegalRepresentative) {
        super(id, nit, name, location);
        this.idLegalRepresentative = idLegalRepresentative;
        this.nameLegalRepresentative = nameLegalRepresentative;

        positiveNumberValidator = new NumRangeValidator(1.0, Double.MAX_VALUE);
        min15CharValidator = new StringRangeValidator(16, Integer.MAX_VALUE);
    }


    public Integer getIdLegalRepresentative() {
        return idLegalRepresentative;
    }

    public void setIdLegalRepresentative(Integer idLegalRepresentative) {
        try{
            positiveNumberValidator.validate(idLegalRepresentative.doubleValue());
            this.idLegalRepresentative = idLegalRepresentative;
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public String getNameLegalRepresentative() {
        return nameLegalRepresentative;
    }

    public void setNameLegalRepresentative(String nameLegalRepresentative) {
        try{
            min15CharValidator.validate(nameLegalRepresentative);
            this.nameLegalRepresentative = nameLegalRepresentative;
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public String generateReportCSV() {
        StringBuilder csvBuilder = new StringBuilder();

        csvBuilder.append("id,nit,name,location,idLegalRepresentative,nameLegalRepresentative\n");
        csvBuilder.append(formatUserCSV(this));

        return csvBuilder.toString();
    }

    private static String formatUserCSV(PrivateCompany company) {
        return String.format(
                "%d,%s,%s,%s,%d,%s\n",
                company.getId(),
                company.getNit(),
                company.getName(),
                company.getLocation(),
                company.getIdLegalRepresentative(),
                company.getNameLegalRepresentative()
        );
    }
}
