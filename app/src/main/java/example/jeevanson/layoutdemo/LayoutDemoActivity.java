package example.jeevanson.layoutdemo;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import example.jeevanson.singleviewapplication.R;

public class LayoutDemoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout_demo);
        showAlert();

    }


    void showAlert() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this).setTitle("My Title").setPositiveButton("Ok",null).setNegativeButton("Cancel",null);
        builder.setMessage("This is my custom alert message.");
        AlertDialog dialog = builder.create();
        dialog.show();
    }

}
