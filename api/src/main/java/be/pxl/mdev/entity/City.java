package be.pxl.mdev.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by 11400982 on 9/11/2017.
 */
@Entity
@Table(name = "cities")
public class City {

    @Id
    private String postcode;
    private String name;

    public City() {};

    public City(String postalCode, String name) {
        this.postcode = postalCode;
        this.name = name;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
