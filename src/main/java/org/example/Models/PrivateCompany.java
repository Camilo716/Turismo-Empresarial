package org.example.Models;

import org.example.Models.AbstractEntities.Company;

import java.time.LocalDate;

public class PrivateCompany extends Company {

    private Integer IdLegalRepresentative;
    private String NameLegalRepresentative;

    public PrivateCompany(Integer id, String nit, String name, LocalDate location,
                          Integer idLegalRepresentative, String nameLegalRepresentative) {
        super(id, nit, name, location);
        IdLegalRepresentative = idLegalRepresentative;
        NameLegalRepresentative = nameLegalRepresentative;
    }


    public Integer getIdLegalRepresentative() {
        return IdLegalRepresentative;
    }

    public void setIdLegalRepresentative(Integer idLegalRepresentative) {
        IdLegalRepresentative = idLegalRepresentative;
    }

    public String getNameLegalRepresentative() {
        return NameLegalRepresentative;
    }

    public void setNameLegalRepresentative(String nameLegalRepresentative) {
        NameLegalRepresentative = nameLegalRepresentative;
    }
}
