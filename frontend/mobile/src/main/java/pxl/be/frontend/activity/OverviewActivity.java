package pxl.be.frontend.activity;

import android.content.SharedPreferences;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import pxl.be.frontend.R;
import pxl.be.frontend.activity.adapter.OverViewAdapter;
import pxl.be.frontend.activity.adapter.utils.OrderElement;
import pxl.be.frontend.activity.adapter.utils.OrderElementContainer;
import pxl.be.frontend.activity.container.UserContainer;
import pxl.be.frontend.model.City;
import pxl.be.frontend.model.Event;
import pxl.be.frontend.model.User;
import pxl.be.frontend.repository.CityRepository;
import pxl.be.frontend.activity.IActivity;

/**
 * Created by 11400982 on 10/11/2017.
 */

public class OverviewActivity extends AppCompatActivity implements IActivity {

    @BindView(R.id.overview_menus_list)
    ListView listView;
    @BindView(R.id.overview_menus_textview)
    TextView textView;
    @BindView(R.id.overview_menus_list_image)
    ImageView image;
    @BindView(R.id.overview_menus_textview_total_price) TextView total;

    private List<OrderElement> orderElements;
    private OverViewAdapter adapter;
    private User user;
    private String url;
    private SharedPreferences preferences;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_overview_menus_list);
        this.user = ((UserContainer)getIntent().getSerializableExtra("user")).getUser();
        ButterKnife.bind(this);
        this.orderElements = ((OrderElementContainer)getIntent().getSerializableExtra("orderElements")).getOrderElements();
        trimOrderElements();
        this.url = getIntent().getStringExtra("url");
        Picasso.with(this).load(url).into(image);
        this.user = ((UserContainer)getIntent().getSerializableExtra("user")).getUser();
        adapter = new OverViewAdapter(OverviewActivity.this, orderElements);
        listView.setAdapter(adapter);
        CityRepository cityRepository = new CityRepository(this);
        cityRepository.find(this.user.getCity());
        preferences = getSharedPreferences("prefs", MODE_PRIVATE);

    }

    private void trimOrderElements() {
        List<OrderElement> newOrderElements = new ArrayList<OrderElement>();
        int i;

        for (i=0; i < orderElements.size() ;i++) {
            if (orderElements.get(i).getAmount() > 0)
                newOrderElements.add(orderElements.get(i));
        }

        this.orderElements = newOrderElements;
    }

    @Override
    public void setJson(String json) {
        Event event = new Gson().fromJson(json, Event.class);
        textView.setText("Het feestje waar je aanwezig bent gaat door in de  " + preferences.getString("address", event.getAddress()) + " te " + event.getCity() + ". Je staat op de gastenlijst als " + this.user.getFirstName() + " " + this.user.getLastName() + ".");

    }
}
