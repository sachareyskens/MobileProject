package pxl.be.frontend.model;

/**
 * Created by 11400982 on 10/11/2017.
 */

import java.io.Serializable;

public class User implements Serializable {

    private String username;
    private String firstName;
    private String lastName;
    private String passWord;
    private String city;
    private String address;
    private String mobileNr;
    private int radius;

    public User(String username, String firstName, String lastName, String passWord, String city, String address, int radius, String mobileNr) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.passWord = passWord;
        this.city = city;
        this.address = address;
        this.radius = radius;
        this.mobileNr = mobileNr;
    }

    public User() {};

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String  getCity() {
        return city;
    }

    public void setCity(String  city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public String getMobileNr() {
        return mobileNr;
    }

    public void setMobileNr(String mobileNr) {
        this.mobileNr = mobileNr;
    }













}
