package pxl.be.frontend.api;

import pxl.be.frontend.model.User;
import pxl.be.frontend.util.PutInput;

/**
 * Created by 11400982 on 10/11/2017.
 */

public class Putter {

    private String url = null;
    private User user;

    public Putter(String url, User user) {
        this.url = url;
        this.user = user;
    }

    public Putter(User user) {
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
            PutInput input = new PutInput(user);
            input.execute(url);
        }
    }

}
