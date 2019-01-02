package example.jeevanson.homescreen;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import example.jeevanson.boundserviceexample.BoundServiceDemoActivity;
import example.jeevanson.customviewscreen.CustomViewActivity;
import example.jeevanson.layoutdemo.LayoutDemoActivity;
import example.jeevanson.serviceexample.ServiceExampleActivity;
import example.jeevanson.singleviewapplication.MainActivity;
import example.jeevanson.singleviewapplication.R;

public class HomeScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);


        Button customView = (Button)findViewById(R.id.customViewBtn);
        Button colorPickerButton = (Button) findViewById(R.id.colorPickerBtn);
        Button serviceDemoButton = (Button) findViewById(R.id.serviceDemoBtn);
        Button boundServiceDemoButton = (Button) findViewById(R.id.boundServiceDemoBtn);
        Button layoutDemoButton = (Button) findViewById(R.id.layoutDemoBtnId);


        colorPickerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(HomeScreenActivity.this, MainActivity.class);
                intent.putExtra("message","Message from HomeActivity");
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

        serviceDemoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(HomeScreenActivity.this, ServiceExampleActivity.class);
                HomeScreenActivity.this.startActivity(intent);
            }
        });

        boundServiceDemoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(HomeScreenActivity.this, BoundServiceDemoActivity.class);
                HomeScreenActivity.this.startActivity(intent);
            }
        });

        layoutDemoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(HomeScreenActivity.this, LayoutDemoActivity.class);
                HomeScreenActivity.this.startActivity(intent);
            }
        });


    }
}
