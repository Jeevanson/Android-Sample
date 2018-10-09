package example.jeevanson.broadcastreceiverdemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import example.jeevanson.serviceexample.MyService;
import example.jeevanson.singleviewapplication.R;

public class BroadCastReceiverDemoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broad_cast_receiver_demo);


        Button send_broadcast = findViewById(R.id.sendBroadCast);
        send_broadcast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(BroadCastReceiverDemoActivity.this, MyService.class);
                BroadCastReceiverDemoActivity.this.startService(intent);
//                Intent intent = new Intent();
//                intent.setAction("jeevan.Custom_Action");
//                BroadCastReceiverDemoActivity.this.sendBroadcast(intent);
            }
        });


    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onStart() {


        IntentFilter filter = new IntentFilter("jeevan.Custom_Action");
        BroadcastReceiver receiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {

                System.out.println("Broadcast Received from Service ");
                Toast.makeText(BroadCastReceiverDemoActivity.this, "Broadcast received", Toast.LENGTH_LONG).show();
                Intent i = new Intent(BroadCastReceiverDemoActivity.this, MyService.class);
                BroadCastReceiverDemoActivity.this.stopService(i);
            }
        };

        registerReceiver(receiver,filter);

        super.onStart();

    }
}
