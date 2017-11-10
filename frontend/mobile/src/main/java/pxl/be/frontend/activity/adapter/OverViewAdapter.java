package pxl.be.frontend.activity.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import pxl.be.frontend.R;
import pxl.be.frontend.activity.adapter.utils.OrderElement;

/**
 * Created by 11400982 on 10/11/2017.
 */

public class OverViewAdapter extends BaseAdapter {
    private List<OrderElement> orderElements;
    private Context context;
    private LayoutInflater inflater;

    public OverViewAdapter(Context context, List<OrderElement> orderElements) {
        this.context = context;
        this.orderElements = orderElements;
    }

    @Override
    public int getCount() {
        return orderElements.size();
    }

    @Override
    public Object getItem(int i) {
        return orderElements.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        if (view == null) {
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.activity_overview_menus_list_element, null);
        }

        TextView menu = (TextView) view.findViewById(R.id.menu_overview_list_element_menu);
        TextView amount = (TextView) view.findViewById(R.id.menu_overview_list_element_amount);


        return view;
    }
}
