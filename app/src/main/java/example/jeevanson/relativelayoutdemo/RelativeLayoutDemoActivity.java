package example.jeevanson.relativelayoutdemo;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import example.jeevanson.singleviewapplication.R;

public class RelativeLayoutDemoActivity extends AppCompatActivity {

    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relative_layout_demo);

//        Button getPrefBtn = findViewById(R.id.getPrefBtnId);

//        sharedPreferences = getSharedPreferences("MyPref", Context.MODE_PRIVATE);

//        SharedPreferences.Editor editor = sharedPreferences.edit();
//
//        editor.putString("MyStringKey","Preferece Value");
//        editor.commit();


//        getPrefBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String prefMsg = sharedPreferences.getString("MuStringKey","MyDefault Value");
//
//                Toast.makeText(RelativeLayoutDemoActivity.this, "Pref retrived:"+prefMsg, Toast.LENGTH_LONG).show();
//            }
//        });

    }
}
