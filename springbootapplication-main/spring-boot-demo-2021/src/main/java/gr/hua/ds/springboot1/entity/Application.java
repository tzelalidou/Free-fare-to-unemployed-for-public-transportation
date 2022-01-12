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

    @Column(name = "yearOfUnemployment")
    private Date yearOfUnemployment;

    @Column(name = "applicationStatus")
    private int applicationStatus;

    @Column(name = "imgName")
    private String imgName;

    @Id
    @Column(name = "amkaNumber", nullable = false)
    private String amkaNumber;



    public Application() {

    }



    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn (name = "user_id")
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

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
