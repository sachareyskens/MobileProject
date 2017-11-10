package pxl.be.frontend.activity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.EditTextPreference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceFragment;
import android.support.annotation.Nullable;

import pxl.be.frontend.R;
import pxl.be.frontend.activity.container.UserContainer;
import pxl.be.frontend.model.User;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.EditTextPreference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceFragment;
import android.support.annotation.Nullable;

/**
 * Created by 11400982 on 10/11/2017.
 */

public class ChangeAddressActivity extends PreferenceActivity {

    private static User user;
    private static SharedPreferences preferences;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.user = (User)((UserContainer) getIntent().getSerializableExtra("user")).getUser();
        preferences = getSharedPreferences("prefs", MODE_PRIVATE);
        getFragmentManager().beginTransaction().replace(android.R.id.content, new Fragment()).commit();
    }

    public static class Fragment extends PreferenceFragment {
        @Override
        public void onCreate(final Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            addPreferencesFromResource(R.xml.address_preferences);
            EditTextPreference address = (EditTextPreference)findPreference("address");
            EditTextPreference postalCode = (EditTextPreference) findPreference("postcode");
            address.setText(preferences.getString("address", user.getAddress()));
            postalCode.setText(preferences.getString("postcode", user.getCity()));
        }

        @Override
        public void onStop() {
            super.onStop();
            String postalCode, address;
            postalCode = ((EditTextPreference) findPreference("postcode")).getText();
            address = ((EditTextPreference) findPreference("address")).getText();
            SharedPreferences.Editor editor = preferences.edit();
            editor.putString("address", address);
            editor.putString("postcode", postalCode);
            editor.commit();
        }
    }
}

