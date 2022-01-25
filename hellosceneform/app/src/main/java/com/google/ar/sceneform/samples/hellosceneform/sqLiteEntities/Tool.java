package com.google.ar.sceneform.samples.hellosceneform.sqLiteEntities;

/*
This class keeps the values needed to work with the SQLite database.
 */

public class Tool {
    private Integer id;
    private Float price;
    private String name;
    private String description;


    public Tool(Integer id, Float price, String name, String description) {
        this.id = id;
        this.price = price;
        this.name = name;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public Float getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
