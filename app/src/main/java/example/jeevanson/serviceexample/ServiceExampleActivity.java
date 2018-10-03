package example.jeevanson.serviceexample;

import android.content.Intent;
import android.media.MediaPlayer;
import android.media.audiofx.BassBoost;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import example.jeevanson.singleviewapplication.R;

public class ServiceExampleActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_service_example);


        Button startService = findViewById(R.id.startService);
        startService.setOnClickListener(this);

        Button stopService = findViewById(R.id.stopServiceBtn);
        stopService.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        Intent intent = new Intent(this,MyService.class);

        switch (v.getId()) {
            case R.id.startService:
                startService(intent);
                break;
            case R.id.stopServiceBtn:
                stopService(intent);
                break;
        }



    }
}
