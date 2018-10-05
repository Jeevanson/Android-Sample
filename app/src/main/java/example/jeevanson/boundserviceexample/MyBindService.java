package example.jeevanson.boundserviceexample;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.widget.Toast;

public class MyBindService extends Service{

    MyBinder myBinder = new MyBinder();

    @Override
    public IBinder onBind(Intent intent) {

        System.out.println("Service onBind");
        return myBinder;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        System.out.println("Service onUnbind");
        return true;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        Toast.makeText(this,"Service Created",Toast.LENGTH_LONG).show();
        System.out.println("Service Created");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        System.out.println("Service Started");
        Toast toast = Toast.makeText(this,"Service Started",Toast.LENGTH_LONG);

        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        System.out.println("Service Destroyed");
        super.onDestroy();
    }


    public class MyBinder extends Binder {

        MyBindService getService() {
            return MyBindService.this;
        }
    }

    public String getMessage() {
        return "Message from Bound Service ";
    }

}
