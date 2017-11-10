package pxl.be.frontend.repository;

import pxl.be.frontend.BuildConfig;
import pxl.be.frontend.activity.IActivity;
import pxl.be.frontend.api.Consumer;
import pxl.be.frontend.api.Poster;
import pxl.be.frontend.api.Putter;
import pxl.be.frontend.model.User;

/**
 * Created by 11400982 on 10/11/2017.
 */

public class UserRepository {
    private Consumer consumer;

    public UserRepository(IActivity activity) {
        this.consumer = new Consumer(activity);
    }

    public void all() {
        consumer.setUrl(BuildConfig.SERVER_URL + "/users/all");
        consumer.getString();
    }

    public void find(String userName) {
        consumer.setUrl(BuildConfig.SERVER_URL + "/users/get/" + userName);
        consumer.getString();
    }

    public void add(User user) {
        Poster poster = new Poster(user);
        poster.setUrl(BuildConfig.SERVER_URL + "/users/add");
        poster.update();
    }

    public void update(User user) {
        Putter putter = new Putter(user);
        putter.setUrl(BuildConfig.SERVER_URL + "/users/update");
        putter.update();
    }
}
