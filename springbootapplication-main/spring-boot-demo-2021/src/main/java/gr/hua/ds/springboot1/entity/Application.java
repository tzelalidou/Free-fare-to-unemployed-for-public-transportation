package gr.hua.ds.springboot1.entity;

import javax.persistence.*;
import java.util.*;


@Entity
@Table(name = "application")
public class Application {

    @Column(name = "birthdate")
    private Date birthDate;

    @Column(name = "address")
    private String address;

    @Column(name = "yearofunemployement")
    private Date yearOfUnemployment;

    @Column(name = "status")
    private int applicationStatus;

    @Column(name = "img_name")
    private String imgName;

    @Id
    @Column(name = "amka")
    private String amkaNumber;



    public Application() {

    }

    public Application(Date birthDate, String address, Date yearOfUnemployment, int applicationStatus, String imgName, String amkaNumber) {
        this.birthDate = birthDate;
        this.address = address;
        this.yearOfUnemployment = yearOfUnemployment;
        this.applicationStatus = applicationStatus;
        this.imgName = imgName;
        this.amkaNumber = amkaNumber;
    }
    @ManyToOne
    @JoinColumn (name = "amkaNumber")
    private User user;

    public String getImgName() {
        return imgName;
    }

    public void setImgName(String imgName) {
        this.imgName = imgName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Date getYearOfUnemployment() {
        return yearOfUnemployment;
    }

    public void setYearOfUnemployment(Date yearOfUnemployment) {
        this.yearOfUnemployment = yearOfUnemployment;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getApplicationStatus() {
        return applicationStatus;
    }

    public void setApplicationStatus(int applicationStatus) {
        this.applicationStatus = applicationStatus;
    }

    public String getAmkaNumber() {
        return amkaNumber;
    }

    public void setAmkaNumber(String amkaNumber) {
        this.amkaNumber = amkaNumber;
    }
}
