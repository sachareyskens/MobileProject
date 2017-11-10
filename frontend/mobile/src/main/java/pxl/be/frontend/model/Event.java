package pxl.be.frontend.model;

import java.io.Serializable;

/**
 * Created by 11400982 on 10/11/2017.
 */

public class Event implements Serializable {
    private int eventId;
    private String name;
    private String description;
    private String address;
    private String city;
    private double price;
    private String ticketLink;

    private User user;

    public Event (int eventId, String name, String description, String address, String city, double price, String ticketLink, User user) {
        this.eventId = eventId;
        this.name = name;
        this.description = description;
        this.address = address;
        this.city = city;
        this.price = price;
        this.ticketLink = ticketLink;
        this.user = user;
    }

    public int getEventId() { return eventId; }

    public void setEventId(int eventId) { this.eventId = eventId; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }

    public String getAddress() { return address; }

    public void setAddress(String address) { this.address = address; }

    public String getCity() { return city; }

    public void setCity(String city) { this.city = city; }

    public double getPrice() { return price; }

    public void setPrice(Double price) { this.price = price; }

    public String getTicketLink() { return ticketLink; }

    public void setTicketLink(String ticketLink) { this.ticketLink = ticketLink; }

    public User getUser() { return user; }

    public void setUser(User user) { this.user = user;}


}
