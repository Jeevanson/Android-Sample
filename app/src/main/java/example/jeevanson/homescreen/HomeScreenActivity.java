package example.jeevanson.homescreen;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import example.jeevanson.customviewscreen.CustomViewActivity;
import example.jeevanson.singleviewapplication.MainActivity;
import example.jeevanson.singleviewapplication.R;

public class HomeScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);


        Button customView = (Button)findViewById(R.id.customViewBtn);
        Button colorPickerButton = (Button) findViewById(R.id.colorPickerBtn);

        colorPickerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(HomeScreenActivity.this, MainActivity.class);
                HomeScreenActivity.this.startActivity(intent);
            }
        });


        customView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(HomeScreenActivity.this, CustomViewActivity.class);
                HomeScreenActivity.this.startActivity(intent);
            }
        });


    }
}
