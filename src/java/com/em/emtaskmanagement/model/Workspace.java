/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.em.emtaskmanagement.model;

import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 *
 * @author Vishal
 */
@Entity
@Table(name = "workspace")
public class Workspace {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "workspaceid")
    private int workspaceid;
    @Column(name = "workspacename")
    private String workspacename;
    @Column(name = "ownerid")
    private int ownerid;
    @Column(name = "active_inactive", columnDefinition = "bigint default 0")
    private int active_inactive;
    @ManyToMany(mappedBy = "workspace")
    private Set<User> user;

    public int getWorkspaceid() {
        return workspaceid;
    }

    public void setWorkspaceid(int workspaceid) {
        this.workspaceid = workspaceid;
    }

    public String getWorkspacename() {
        return workspacename;
    }

    public void setWorkspacename(String workspacename) {
        this.workspacename = workspacename;
    }

    public int getOwnerid() {
        return ownerid;
    }

    public void setOwnerid(int ownerid) {
        this.ownerid = ownerid;
    }

    public int getActive_inactive() {
        return active_inactive;
    }

    public void setActive_inactive(int active_inactive) {
        this.active_inactive = active_inactive;
    }

    public Set<User> getUser() {
        return user;
    }

    public void setUser(Set<User> user) {
        this.user = user;
    }
}
