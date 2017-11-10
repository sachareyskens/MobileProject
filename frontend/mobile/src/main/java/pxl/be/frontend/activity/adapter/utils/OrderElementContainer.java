package pxl.be.frontend.activity.adapter.utils;

import java.io.Serializable;
import java.util.List;

/**
 * Created by 11400982 on 10/11/2017.
 */

public class OrderElementContainer implements Serializable {

    private List<OrderElement> orderElements;

    public OrderElementContainer(List<OrderElement> orderElements) {
        this.orderElements = orderElements;
    }

    public List<OrderElement> getOrderElements() {
        return orderElements;
    }

    public void setOrderElements(List<OrderElement> orderElements) {
        this.orderElements = orderElements;
    }
}

