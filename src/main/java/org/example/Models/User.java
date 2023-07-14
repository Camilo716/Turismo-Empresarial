package org.example.Models;


import org.example.Validators.*;

public class User {

    private Integer id;
    private String name;
    private String document;
    private Integer locationNum;
    private String mail;

    private IValidable<String> alphaSpaceValidator;
    private IValidable<String> stringRangeValidator;
    private IValidable<Double> numberRangeValidator;
    private IValidable<String> mailValidator;

    public User(Integer id, String name, String document, Integer location, String mail) {
        this.id = id;
        this.name = name;
        this.document = document;
        this.locationNum = location;
        this.mail = mail;

        alphaSpaceValidator = new AlphaSpaceValidator();
        stringRangeValidator = new StringRangeValidator(10, Integer.MAX_VALUE);
        numberRangeValidator = new NumRangeValidator(1.0, 4.0);
        mailValidator = new MailValidator();
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
        try {
            mailValidator.validate(mail);
            this.mail = mail;
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}

