package example.jeevanson.boundserviceexample;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import example.jeevanson.singleviewapplication.R;

public class BoundServiceDemoActivity extends AppCompatActivity implements View.OnClickListener {

    MyBindService myBindService;
    boolean isBound;

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

                Intent intent = new Intent(this,MyBindService.class);
                bindService(intent, myServiceConnection, BIND_AUTO_CREATE);

                break;
            case R.id.unbindServiceBtn:

                if(isBound) {
                    System.out.println(myBindService.getMessage());
                    unbindService(myServiceConnection);
                }

                break;

        }
    }

    ServiceConnection myServiceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {


            System.out.println("Service Connected");

            MyBindService.MyBinder binder = (MyBindService.MyBinder) service;
            myBindService = binder.getService();
            isBound = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            System.out.println("Service Disconnected");

            isBound = false;
        }
    };
}
