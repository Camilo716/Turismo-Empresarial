package org.example.Models;


import org.example.Validators.*;

public class User {

    private Integer id;
    private String name;
    private String document;
    private Integer locationNum;
    private String mail;

    private final IValidable<String> alphaSpaceValidator;
    private final IValidable<String> minLength10Validator;
    private final IValidable<Double> rangeBetween1And4Validator;
    private final IValidable<String> mailValidator;

    public User(Integer id, String name, String document, Integer location, String mail) {
        this.id = id;
        this.name = name;
        this.document = document;
        this.locationNum = location;
        this.mail = mail;

        alphaSpaceValidator = new AlphaSpaceValidator();
        minLength10Validator = new StringRangeValidator(10, Integer.MAX_VALUE);
        rangeBetween1And4Validator = new NumRangeValidator(1.0, 4.0);
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
            minLength10Validator.validate(name);
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
            rangeBetween1And4Validator.validate(locationNum.doubleValue());
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

