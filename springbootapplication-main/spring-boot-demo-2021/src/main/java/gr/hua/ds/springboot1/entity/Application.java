package gr.hua.ds.springboot1.entity;

import javax.persistence.*;
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
    private Date birthdate;

    @Column(name = "address")
    private String address;

    @Column(name = "yearofunemployment")
    private Date yearofunemployment;

    @Column(name = "applicationstatus")
    private int applicationstatus;

    @Column(name = "imgname")
    private String imgname;

    public Application() {

    }

    public Application(long amkanumber, Date birthdate, String address, Date yearofunemployment, int applicationstatus, String imgname) {
        this.amkanumber = amkanumber;
        this.birthdate = birthdate;
        this.address = address;
        this.yearofunemployment = yearofunemployment;
        this.applicationstatus = applicationstatus;
        this.imgname = imgname;
    }

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE,CascadeType.DETACH})
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


    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthDate) {
        this.birthdate = birthDate;
    }

    public Date getYearofunemployment() {
        return yearofunemployment;
    }

    public void setYearofunemployment(Date yearOfUnemployment) {
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
}
