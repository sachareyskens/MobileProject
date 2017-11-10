package be.pxl.mdev.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

/**
 * Created by 11400982 on 9/11/2017.
 */
@Entity
@Table(name = "events")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int eventId;
    private String name;
    private String description;
    private String address;
    private String city;
    private double Price;
    private String ticketLink;
    @ManyToOne()
    @JsonBackReference(value = "user_events")
    private User user;







}
