package org.example.Models;


import org.example.Validators.AlphaSpaceValidator;
import org.example.Validators.IValidable;
import org.example.Validators.NumRangeValidator;
import org.example.Validators.StringRangeValidator;

public class User {

    private Integer id;
    private String name;
    private String document;
    private Integer locationNum;
    private String mail;

    IValidable<String> alphaSpaceValidator;
    IValidable<String> stringRangeValidator;
    IValidable<Double> numberRangeValidator;

    public User(Integer id, String name, String document, Integer location, String mail) {
        this.id = id;
        this.name = name;
        this.document = document;
        this.locationNum = location;
        this.mail = mail;

        alphaSpaceValidator = new AlphaSpaceValidator();
        stringRangeValidator = new StringRangeValidator(10, Integer.MAX_VALUE);
        numberRangeValidator = new NumRangeValidator(1.0, 4.0);

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        try{
            stringRangeValidator.validate(name);
            alphaSpaceValidator.validate(name);
            this.name = name;
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public Integer getLocationNum() {
        return locationNum;
    }

    public void setLocationNum(Integer locationNum) {
        try {
            numberRangeValidator.validate(locationNum.doubleValue());
            this.locationNum = locationNum;
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
}

