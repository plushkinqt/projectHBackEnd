package com.mycompany.model;

import com.google.gson.annotations.Expose;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author yevgen
 */
@Entity
@Table(name="health_cards")
public class HelthCard implements Serializable{

    @Id
    @Expose
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id", nullable=false)
    private int id;
    @Expose
    @Column(name="age")
    private int age;
    @Expose
    @Column(name="sex")
    private String sex;
    @Expose
    @Column(name="city")
    private String city;
    @Expose
    @Column(name="job")
    private String job;
    @Expose
    @Column(name="waist_circumference")
    private double waistCircumference;
    @Expose
    @Column(name="smoking")
    private String smoking;
    @Expose
    @Column(name="blood_sugar")
    private double bloodSugar;
    @Expose
    @Column(name="blood_pressure")
    private String bloodPressure;
    @Expose
    @Column(name="bmi")
    private double bmi;
    @Expose
    @Column(name="weight")
    private double weight;
    @Expose
    @Column(name="alcohol_abuse")
    private String alcoholAbuse;
    @Expose
    @ManyToOne (fetch=FetchType.EAGER)
    @JoinColumn(name="user_id")
    private User user;

    public HelthCard() {
        this.id = 0;
        this.age = 0;
        this.sex = "";
        this.city = "";
        this.job = "";
        this.waistCircumference = 0;
        this.smoking = "";
        this.bloodSugar = 0;
        this.bloodPressure = "";
        this.bmi = 0;
        this.weight = 0;
        this.alcoholAbuse = "";
        this.user = new User();
    }

    public HelthCard(int id, int age, String sex, String city, String job, double waistCircumference, String smoking, double bloodSugar, 
            String bloodPressure, double bmi, double weight, String alcoholAbuse, User user) {
        this.id = id;
        this.age = age;
        this.sex = sex;
        this.city = city;
        this.job = job;
        this.waistCircumference = waistCircumference;
        this.smoking = smoking;
        this.bloodSugar = bloodSugar;
        this.bloodPressure = bloodPressure;
        this.bmi = bmi;
        this.weight = weight;
        this.alcoholAbuse = alcoholAbuse;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public double getWaistCircumference() {
        return waistCircumference;
    }

    public void setWaistCircumference(double waistCircumference) {
        this.waistCircumference = waistCircumference;
    }

    public String getSmoking() {
        return smoking;
    }

    public void setSmoking(String smoking) {
        this.smoking = smoking;
    }

    public double getBloodSugar() {
        return bloodSugar;
    }

    public void setBloodSugar(double bloodSugar) {
        this.bloodSugar = bloodSugar;
    }

    public String getBloodPressure() {
        return bloodPressure;
    }

    public void setBloodPressure(String bloodPressure) {
        this.bloodPressure = bloodPressure;
    }

    public double getBmi() {
        return bmi;
    }

    public void setBmi(double bmi) {
        this.bmi = bmi;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getAlcoholAbuse() {
        return alcoholAbuse;
    }

    public void setAlcoholAbuse(String alcoholAbuse) {
        this.alcoholAbuse = alcoholAbuse;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
    
}
