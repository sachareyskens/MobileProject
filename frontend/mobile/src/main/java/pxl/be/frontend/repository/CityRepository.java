package pxl.be.frontend.repository;

import pxl.be.frontend.BuildConfig;
import pxl.be.frontend.activity.IActivity;
import pxl.be.frontend.api.Consumer;

/**
 * Created by 11400982 on 10/11/2017.
 */

public class CityRepository  {

    private Consumer consumer;

    public CityRepository(IActivity activity) {
        this.consumer = new Consumer(activity);
    }

    public void find(String postalCode) {
        consumer.setUrl(BuildConfig.SERVER_URL + "/cities/get/" + postalCode);
        consumer.getString();
    }

    public void all() {
        consumer.setUrl(BuildConfig.SERVER_URL + "/cities/all");
        consumer.getString();
    }
}
