package example.jeevanson.serviceexample;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.widget.Toast;

import java.sql.SQLOutput;

import example.jeevanson.broadcastreceiverdemo.BroadCastReceiverDemoActivity;

public class MyService extends Service {

    boolean doWork;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        Toast.makeText(this,"Service Created",Toast.LENGTH_LONG).show();
        System.out.println("Service Created");

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        doWork = true;
        doWork();
        System.out.println("Service Started");
        Toast toast = Toast.makeText(this,"Service Started",Toast.LENGTH_LONG);

        Intent i = new Intent();
        i.setAction("jeevan.Custom_Action");
        sendBroadcast(i);

        return super.onStartCommand(intent, flags, startId);
    }


    public void doWork() {

    }


    @Override
    public void onDestroy() {
        System.out.println("Service Destroyed");
        Toast.makeText(this,"Service Destroyed",Toast.LENGTH_SHORT).show();
        doWork = false;
        super.onDestroy();
    }
}
