
package com.model;

public class ModelPost {
    private int idpost;
    private int postnumber;
    private String status;
    private String Description;
    private ModelUser iduser;
    private ModelComputer idcomputer;

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
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public ModelUser getIduser() {
        return iduser;
    }

    public void setIduser(ModelUser iduser) {
        this.iduser = iduser;
    }

    public ModelComputer getIdcomputer() {
        return idcomputer;
    }

    public void setIdcomputer(ModelComputer idcomputer) {
        this.idcomputer = idcomputer;
    }
    
}
