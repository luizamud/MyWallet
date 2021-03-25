package amudcorp.dev.mywallet.Controller;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import amudcorp.dev.mywallet.R;

public class AppAutoria extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_autoria);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}