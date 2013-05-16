/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.em.emtaskmanagement.model;

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
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author Vishal
 */
@Entity
@Table(name = "user", uniqueConstraints =
        @UniqueConstraint(columnNames = {"email"}))
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "userid")
    private int userid;
    @Column(name = "firstname", nullable = false)
    private String firstname;
    @Column(name = "lastname")
    private String lastname;
    @Column(name = "email", nullable = false)
    private String email;
    @Column(name = "password", nullable = false)
    private String password;
    @Column(name = "active_inactive", columnDefinition = "bigint default 0")
    private int active_inactive;
    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name = "user_workspace",
            joinColumns = {
        @JoinColumn(name = "user_id")},
            inverseJoinColumns = {
        @JoinColumn(name = "workspace_id")})
    private Set<Workspace> workspace;

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getActive_inactive() {
        return active_inactive;
    }

    public void setActive_inactive(int active_inactive) {
        this.active_inactive = active_inactive;
    }

    public Set<Workspace> getWorkspace() {
        return workspace;
    }

    public void setWorkspace(Set<Workspace> workspace) {
        this.workspace = workspace;
    }
}
