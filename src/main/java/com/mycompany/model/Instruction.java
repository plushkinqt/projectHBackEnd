package com.mycompany.model;

import com.google.gson.annotations.Expose;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author yevgen
 */
@Entity
@Table(name="instructions")
public class Instruction implements Serializable{
    @Id
    @Expose
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id", nullable=false)
    private int id;
    @Expose
    @Column(name="name")
    private String name;
    @Expose
    @Column(name="description")
    private String description;
    @Expose
    @Column(name="image")
    private byte[] image;

    public Instruction() {
        this.id = 0;
        this.name = "";
        this.description = "";
        this.image = new byte[0];
    }

    public Instruction(int id, String name, String description, byte[] image) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
    
    
    
}
