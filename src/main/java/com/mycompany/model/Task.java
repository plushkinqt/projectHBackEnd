package com.mycompany.model;

import com.google.gson.annotations.Expose;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tasks")
public class Task implements Serializable{
    @Id
    @Expose
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id", nullable=false)
    private int id;

    @Expose
    @Column(name="name")
    private String name;

    @Expose
    @Column(name="period")
    private int period;

    @Expose
    @Column(name="period_type")
    private int periodType;

    @Expose
    @Column(name="description")
    private String description;

    public Task() {
        this.id = 0;
        this.name = "";
        this.period = 0;
        this.periodType = 0;
        this.description = "";
    }

    public Task(int id, String name, int period, int periodType, String description) {
        this.id = id;
        this.name = name;
        this.period = period;
        this.periodType = periodType;
        this.description = description;
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

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    public int getPeriodType() {
        return periodType;
    }

    public void setPeriodType(int periodType) {
        this.periodType = periodType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

       
}