package org.launchcode.demo.models;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Sneaker extends AbstractEntity {
    @NotBlank(message = "Name is required")
    private String name;

    private String designer;
    private String colorway;

    @NotBlank(message = "Release Date required!")
    private String releaseDate;

    @NotBlank(message = "Retail price is required!")
    private String retailPrice;

    @Size(max=5000, message = "Description is too long!")
    private String description;

    private String image;

    public Sneaker(String name, String designer, String colorway, String releaseDate, String retailPrice, String description, String image) {
        this.name = name;
        this.designer = designer;
        this.colorway = colorway;
        this.releaseDate = releaseDate;
        this.retailPrice = retailPrice;
        this.description = description;
        this.image = image;

    }

    public Sneaker() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesigner() {
        return designer;
    }

    public void setDesigner(String designer) {
        this.designer = designer;
    }

    public String getColorway() {
        return colorway;
    }

    public void setColorway(String colorway) {
        this.colorway = colorway;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getRetailPrice() {
        return retailPrice;
    }

    public void setRetailPrice(String retailPrice) {
        this.retailPrice = retailPrice;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString(){
        return name;
    }


}
