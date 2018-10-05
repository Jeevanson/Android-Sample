package example.jeevanson.boundserviceexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import example.jeevanson.singleviewapplication.R;

public class BoundServiceDemoActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bound_service_demo);

        Button bindServiceBtn = findViewById(R.id.bindServiceBtn);
        Button unbindServiceBtn = findViewById(R.id.unbindServiceBtn);
        bindServiceBtn.setOnClickListener(this);
        unbindServiceBtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.bindServiceBtn:

                break;
            case R.id.unbindServiceBtn:

                break;

        }
    }
}
