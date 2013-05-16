/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.em.emtaskmanagement.model;

import java.util.Date;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author Vishal
 */
@Entity
@Table(name = "task")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "taskid")
    private int taskid;
    @Column(name = "taskname")
    private String taskname;
    @Temporal(javax.persistence.TemporalType.DATE)
    @Column(name = "startdate")
    private Date startdate;
    @Temporal(javax.persistence.TemporalType.DATE)
    @Column(name = "enddate")
    private Date enddate;
    @Column(name = "ownerid")
    private int ownerid;
    @Column(name = "status")
    private int status;
    @Column(name = "priority")
    private int priority;
    @ManyToOne
    @JoinColumn(name = "workspace_id")
    private Workspace workspace;
    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name = "task_user",
            joinColumns = {
        @JoinColumn(name = "task_id")},
            inverseJoinColumns = {
        @JoinColumn(name = "user_id")})
    private Set<User> user;

    public int getTaskid() {
        return taskid;
    }

    public void setTaskid(int taskid) {
        this.taskid = taskid;
    }

    public String getTaskname() {
        return taskname;
    }

    public void setTaskname(String taskname) {
        this.taskname = taskname;
    }

    public Date getStartdate() {
        return startdate;
    }

    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    public Date getEnddate() {
        return enddate;
    }

    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }

    public int getOwnerid() {
        return ownerid;
    }

    public void setOwnerid(int ownerid) {
        this.ownerid = ownerid;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }
}
