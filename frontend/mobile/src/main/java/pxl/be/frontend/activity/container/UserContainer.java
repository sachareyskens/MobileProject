package pxl.be.frontend.activity.container;

import java.io.Serializable;

import pxl.be.frontend.model.User;


/**
 * Created by kevin on 04/10/2017.
 */

public class UserContainer implements Serializable {

    private User user;

    public UserContainer(User user) { this.user = user; }

    public User getUser() { return user; }

    public void setUser(User user) { this.user = user; }

}
