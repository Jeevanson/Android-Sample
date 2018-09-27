package example.jeevanson.customviewscreen;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import example.jeevanson.singleviewapplication.CustomView;

public class CustomViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        CustomView myView = new CustomView(this);

        setContentView(myView);
    }
}
