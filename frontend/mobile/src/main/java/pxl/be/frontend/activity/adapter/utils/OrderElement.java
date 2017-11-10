package pxl.be.frontend.activity.adapter.utils;

import android.view.Menu;

import java.io.Serializable;

/**
 * Created by 11400982 on 10/11/2017.
 */

public class OrderElement implements Serializable {

    private Menu menu;
    private int amount;

    public OrderElement(Menu menu, int amount) {
        this.menu = menu;
        this.amount = amount;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}

