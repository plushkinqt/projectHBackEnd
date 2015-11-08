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
import javax.persistence.Table;

/**
 *
 * @author yevgen
 */
@Entity
@Table(name="user_to_instructions")
public class UserToInstruction implements Serializable{
    @Id
    @Expose
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id", nullable=false)
    private int id;
    @Expose
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="instruction_id")
    private Instruction instruction;
    @Expose
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="user_id")
    private User user;
    @Expose
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="task_id")
    private Task task;

    public UserToInstruction() {
        this.id = 0;
        this.instruction = new Instruction();
        this.user = new User();
        this.task = new Task();
    }

    public UserToInstruction(int id, Instruction instruction, User user, Task task) {
        this.id = id;
        this.instruction = instruction;
        this.user = user;
        this.task = task;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Instruction getInstruction() {
        return instruction;
    }

    public void setInstruction(Instruction instruction) {
        this.instruction = instruction;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }
    
    
}
