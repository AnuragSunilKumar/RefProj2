package com.devon.refferal.entites;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "app_name"))
public class Applications {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String app_name;
    private String app_dob;
    private String app_for;
    private String app_refferedBy;

    public Applications(int id, String app_name, String app_dob, String app_for, String app_refferedBy) {
        this.id = id;
        this.app_name = app_name;
        this.app_dob = app_dob;
        this.app_for = app_for;
        this.app_refferedBy = app_refferedBy;
    }

    public Applications() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getApp_name() {
        return app_name;
    }

    public void setApp_name(String app_name) {
        this.app_name = app_name;
    }

    public String getApp_dob() {
        return app_dob;
    }

    public void setApp_dob(String app_dob) {
        this.app_dob = app_dob;
    }

    public String getApp_for() {
        return app_for;
    }

    public void setApp_for(String app_for) {
        this.app_for = app_for;
    }

    public String getApp_refferedBy() {
        return app_refferedBy;
    }

    public void setApp_refferedBy(String app_refferedBy) {
        this.app_refferedBy = app_refferedBy;
    }

    

    

}
