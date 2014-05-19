package ir.home.changelocale;

import java.util.Locale;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.View;


public class ChangeLocaleActivity extends Activity {

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent i = getIntent();
        String lang = i.getStringExtra("lang");
        if (lang != null)
        {
            Log.d("ws", "Intent : " + lang);
            setDefaultLocale(lang);
        }

        setContentView(R.layout.main);
    }


    public void persianButtonClick(View view) {
        refresh("fa");
    }


    public void englishButtonClick(View view) {
        refresh("en");
    }


    private void refresh(String lang) {
        Intent i = new Intent(ChangeLocaleActivity.this, ChangeLocaleActivity.class);
        i.putExtra("lang", lang);
        startActivity(i);
        finish();
    }


    private void setDefaultLocale(String lang)
    {
        Locale locale = new Locale(lang);
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
        getBaseContext().getResources().updateConfiguration(config,
                getBaseContext().getResources().getDisplayMetrics());
    }

}