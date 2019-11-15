package com.example.projectbrowser;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.EditText;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceFragmentCompat;

public class SettingsActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_activity);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.settings, new SettingsFragment())
                .commit();
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

    }
    // navigate back using the arrow at the top
    public boolean onOptionsItemSelected(MenuItem item){

        switch (item.getItemId()) {
            case android.R.id.home:
                // Create SharedPreference will take to display signature on the home screen
                Intent intent = new Intent(SettingsActivity.this, MainActivity.class);
                Bundle b = new Bundle();
                //try 3
//                addPreferencesFromResource(R.xml.root_preferences);
//            ListPreference listPreference = (ListPreference) findPreference("reply");
//            CharSequence currText = listPreference.getEntry();
//            String currValue = listPreference.getValue();
                //try 2
//                String key = "myInt";
//                ed1=(EditText)findViewById(R.id.reply);
//                String valueToSave = reply;
//
//
//                SharedPreferences sharedPref = getApplicationContext().getSharedPreferences("MySignaturePref", MODE_PRIVATE);
//                SharedPreferences.Editor editor = sharedPref.edit();
//                editor.putInt(key, valueToSave).commit();
                //try1

//                SharedPreferences settingPrefs = getApplicationContext().getSharedPreferences("MySignaturePref", MODE_PRIVATE);
//                SharedPreferences.Editor editor = settingPrefs.edit();
//                settingPrefs.getString("signatureText", reply.getText().toString());
//                settingPrefs.commit();
////                b.putStringArrayList("MySignaturePref",reply);
//                intent.putExtras(b);
                startActivity(intent);
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
    public static class SettingsFragment extends PreferenceFragmentCompat {

        @Override
        public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
            setPreferencesFromResource(R.xml.root_preferences, rootKey);
            addPreferencesFromResource(R.xml.root_preferences);
//            ListPreference listPreference = (ListPreference) findPreference("reply");
//            CharSequence currText = listPreference.getEntry();
//            String currValue = listPreference.getValue();

        }
    }
}