package be.pxl.mdev.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

/**
 * Created by 11400982 on 9/11/2017.
 */
@Entity
@Table(name="users")
public class User {
    @Id
    private String username;
    private String passWord;
    private String firstName;
    private String lastName;
    private String mobileNr;
    private String address;
    private String city;
    @OneToMany(mappedBy = "user")
    @JsonManagedReference(value = "user_events")
    private List<Event> attendingEvents;
    private int distance;

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public User() {}

    public User(String username, String firstName, String lastName, String mobileNr, String address, String city, List<Event> events, int distance) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.mobileNr = mobileNr;
        this.address = address;
        this.city = city;
        this.attendingEvents = events;
        this.distance = distance;

    }


    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String email) {
        this.username = email;
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

    public String getMobileNr() {
        return mobileNr;
    }

    public void setMobileNr(String mobileNr) {
        this.mobileNr = mobileNr;
    }

    public int getDistance() {return distance;}

    public void setDistance(int distance) {this.distance = distance;}

    public List<Event> getAttendingEvents() {return attendingEvents;}

    public void setAttendingEvents(List<Event> attendingEvents) {this.attendingEvents = attendingEvents;}
}
