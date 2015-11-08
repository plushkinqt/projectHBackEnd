package com.mycompany.model;

import com.google.gson.annotations.Expose;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

/**
 *
 * @author yevgen
 */
@Entity
@Table(name="users")
public class User implements Serializable{

    @Id
    @Expose
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id", nullable=false)
    private int id;
    @Expose
    @Column(name="username")
    private String username;
    
    @Column(name="password")
    private String password;
    @Expose
    @Column(name="email")
    private String email;
    @Expose
    @Column(name="first_name")
    private String firstname;
    @Expose
    @Column(name="second_name")
    private String secondname;
    @Lob
    @Expose
    @Column(name="avatar")
    private byte[] image;
    @Expose
    @Column(name="user_type")
    private int userType;

    public User(int id, String username, String password, String email, String firstname, String secondname, byte[] image, int userType) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.firstname = firstname;
        this.secondname = secondname;
        this.image = image;
        this.userType = userType;
    }

    public User() {
        this.id = 0;
        this.username = "";
        this.password = "";
        this.email = "";
        this.firstname = "";
        this.secondname = "";
        this.image = new byte[0];
        this.userType = 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSecondname() {
        return secondname;
    }

    public void setSecondname(String secondname) {
        this.secondname = secondname;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", username=" + username + ", password=" + password + ", email=" + email + ", firstname=" + firstname + ", secondname=" + secondname + ", image=" + image + ", userType=" + userType + '}';
    }
    
    
    
    
}
