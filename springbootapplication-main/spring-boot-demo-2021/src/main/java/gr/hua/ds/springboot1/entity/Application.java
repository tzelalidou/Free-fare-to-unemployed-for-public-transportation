package gr.hua.ds.springboot1.entity;

import javax.persistence.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;


@Entity
@Table(name = "application")
public class Application {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="aid")
    private int aid;

    @Column(name = "amkanumber", nullable = false)
    private long amkanumber;

    @Column(name = "birthdate")
    private String birthdate;

    @Column(name = "address")
    private String address;

    @Column(name = "yearofunemployment")
    private String yearofunemployment;

    @Column(name = "applicationstatus")
    private int applicationstatus;

    @Column(name = "imgname")
    private String imgname;

    public Application() {

    }

    public Application(long amkanumber, String birthdate, String address, String yearofunemployment, int applicationstatus, String imgname) {
        this.amkanumber = amkanumber;
        this.birthdate = birthdate;
        this.address = address;
        this.yearofunemployment = yearofunemployment;
        this.applicationstatus = applicationstatus;
        this.imgname = imgname;
    }

    @ManyToOne(fetch = FetchType.EAGER,cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE,CascadeType.DETACH})
    @JoinColumn (name = "user_id")
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getImgname() {
        return imgname;
    }

    public void setImgname(String imgName) {
        this.imgname = imgName;
    }

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthDate) {
        this.birthdate = birthDate;
    }

    public String getYearofunemployment() {
        return yearofunemployment;
    }

    public void setYearofunemployment(String yearOfUnemployment) {
        this.yearofunemployment = yearOfUnemployment;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getApplicationstatus() {
        return applicationstatus;
    }

    public void setApplicationstatus(int applicationStatus) {
        this.applicationstatus = applicationStatus;
    }

    public long getAmkanumber() {
        return amkanumber;
    }

    public void setAmkanumber(long amkaNumber) {
        this.amkanumber = amkaNumber;
    }

    @Override
    public String toString() {
        return "Application{" +
                "aid=" + aid +
                ", amkanumber=" + amkanumber +
                ", birthdate='" + birthdate + '\'' +
                ", address='" + address + '\'' +
                ", yearofunemployment='" + yearofunemployment + '\'' +
                ", applicationstatus=" + applicationstatus +
                ", imgname='" + imgname + '\'' +
                '}';
    }
}
