
package com.model;

public class ModelPost {
    private int idpost;
    private int postnumber;
    private String status;
    private String description;
    private int iduser;
    private int idcomputer;

    public int getIdpost() {
        return idpost;
    }

    public void setIdpost(int idpost) {
        this.idpost = idpost;
    }

    public int getPostnumber() {
        return postnumber;
    }

    public void setPostnumber(int postnumber) {
        this.postnumber = postnumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getIduser() {
        return iduser;
    }

    public void setIduser(int iduser) {
        this.iduser = iduser;
    }

    public int getIdcomputer() {
        return idcomputer;
    }

    public void setIdcomputer(int idcomputer) {
        this.idcomputer = idcomputer;
    }
    
}
