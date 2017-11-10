package pxl.be.frontend.model;

/**
 * Created by 11400982 on 10/11/2017.
 */

import java.io.Serializable;

public class City implements Serializable {

    private String postcode;
    private String name;

    public City(String postcode, String name) {
        this.postcode = postcode;
        this.name = name;
    }

    public City() {};

    public String getPostcode() {
        return postcode;
    }

    public void setPostalCode(String postcode) {
        this.postcode = postcode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
