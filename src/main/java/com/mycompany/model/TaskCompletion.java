package com.mycompany.model;

import com.google.gson.annotations.Expose;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="task_completion")
public class TaskCompletion implements Serializable{
    @Id
    @Expose
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id", nullable=false)
    private int id;

    @Expose
    @Column(name="done")
    private int done;

    @Expose
    @Column(name="date")
    private Date date;

    @Expose
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="task_id")
    private Task task;

    @Expose
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="user_id")
    private User user;

    public TaskCompletion() {
        this.id = 0;
        this.done = 0;
        this.date = new Date();
        this.task = new Task();
        this.user = new User();
    }

    public TaskCompletion(int id, int done, Date date, Task task, User user) {
        this.id = id;
        this.done = done;
        this.date = date;
        this.task = task;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDone() {
        return done;
    }

    public void setDone(int done) {
        this.done = done;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
    
    
}