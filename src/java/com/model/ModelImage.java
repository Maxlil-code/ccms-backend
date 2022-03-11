
package com.model;

public class ModelImage {
    
      private int idimage;
    private String name;
    private String description;
    private String image;
    private ModelPost idpost;

    public int getIdimage() {
        return idimage;
    }

    public void setIdimage(int idimage) {
        this.idimage = idimage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public ModelPost getIdpost() {
        return idpost;
    }

    public void setIdpost(ModelPost idpost) {
        this.idpost = idpost;
    }
    
    
}
