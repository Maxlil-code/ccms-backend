
package com.model;

import java.sql.Timestamp;

public class ModelReservation {
    
    private int idreservation;
    private ModelUser iduser;
    private ModelPost idpost;
    private String name;
    private Timestamp duration;
    private String price; 

    public int getIdreservation() {
        return idreservation;
    }

    public void setIdreservation(int idreservation) {
        this.idreservation = idreservation;
    }

    public ModelUser getIduser() {
        return iduser;
    }

    public void setIduser(ModelUser iduser) {
        this.iduser = iduser;
    }

    public ModelPost getIdpost() {
        return idpost;
    }

    public void setIdpost(ModelPost idpost) {
        this.idpost = idpost;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Timestamp getDuration() {
        return duration;
    }

    public void setDuration(Timestamp duration) {
        this.duration = duration;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
    
    
}
