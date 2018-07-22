package com.example.tony.caldeira;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ToggleButton;
import android.widget.CompoundButton;

public class MainActivity extends AppCompatActivity {

    protected ToggleButton toggle;                                      // ON/OFF Boiler ToggleButton Object
    protected ImageView caldeira;                                       // Boiler Image Object

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toggle = findViewById(R.id.toggleButton);
        caldeira = findViewById(R.id.caldeiraImage);

        // When toggleButton is clicked
        toggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked)  turnCaldeiraOff();
                else            turnCaldeiraOn();
            }
        });


    }

    // Turn the boiler ON command
    protected void turnCaldeiraOn(){
        caldeira.setImageAlpha(255);
        CaldeiraRestClient.postCaldeiraState(true);
    }

    // Turn the boiler OFF command
    protected void turnCaldeiraOff(){
        caldeira.setImageAlpha(100);
        CaldeiraRestClient.postCaldeiraState(false);
    }

}
