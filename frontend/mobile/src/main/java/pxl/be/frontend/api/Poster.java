package pxl.be.frontend.api;

import pxl.be.frontend.model.User;
import pxl.be.frontend.util.PostInput;

/**
 * Created by 11400982 on 10/11/2017.
 */

public class Poster {

    private String url = null;
    private User user;

    public Poster(String url, User user) {
        this.url = url;
        this.user = user;
    }

    public Poster(User user) {
        this.user = user;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void update() {
        if (url != null) {
            PostInput input = new PostInput(user);
            input.execute(url);
        }
    }
}
