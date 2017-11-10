package pxl.be.frontend.api;

import pxl.be.frontend.activity.IActivity;
import pxl.be.frontend.util.GetInput;

/**
 * Created by 11400982 on 10/11/2017.
 */

public class Consumer {

    private String url = null;
    private IActivity activity;

    public Consumer(String url, IActivity activity) {
        this.url = url;
        this.activity = activity;
    }

    public Consumer(IActivity activity) { this.activity = activity; }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void getString() {
        if (url != null) {
            GetInput input = new GetInput(activity);
            input.execute(url);
        }
    }

}
