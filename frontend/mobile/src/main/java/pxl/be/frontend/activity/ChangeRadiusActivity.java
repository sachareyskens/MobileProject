package pxl.be.frontend.activity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.SeekBar;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import pxl.be.frontend.R;
import pxl.be.frontend.activity.container.UserContainer;
import pxl.be.frontend.model.User;

/**
 * Created by 11400982 on 10/11/2017.
 */

public class ChangeRadiusActivity extends AppCompatActivity {

    @BindView(R.id.change_radius_seekbar)
    SeekBar seekBar;
    @BindView(R.id.change_radius_seekbar_text)
    TextView textView;
    private User user;
    private int radius = 0;
    private static SharedPreferences prefs;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.user = ((UserContainer) getIntent().getSerializableExtra("user")).getUser();
        setContentView(R.layout.activity_change_radius);
        ButterKnife.bind(this);
        prefs = getSharedPreferences("prefs", MODE_PRIVATE);
        seekBar.setProgress(prefs.getInt("seekBarValue", 0));
        textView.setText(prefs.getString("textViewValue", "0km"));
        setSeekBar();
    }

    private void setSeekBar() {
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int radius, boolean b) {
                textView.setText(radius + "km");
                prefs = getSharedPreferences("prefs", MODE_PRIVATE);
                SharedPreferences.Editor editor = prefs.edit();
                editor.putInt("seekBarValue", radius);
                editor.putString("textViewValue", radius + "km");
                editor.commit();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

}
