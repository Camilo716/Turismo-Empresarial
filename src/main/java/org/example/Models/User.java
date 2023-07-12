package org.example.Models;


public class User {

    private Integer id;
    private String name;
    private String document;
    private Integer location;
    private String mail;


    public User() {
    }

    public User(Integer id, String name, String document, Integer location, String mail) {
        this.id = id;
        this.name = name;
        this.document = document;
        this.location = location;
        this.mail = mail;
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
        this.name = name;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public Integer getLocation() {
        return location;
    }

    public void setLocation(Integer location) {
        this.location = location;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
}

