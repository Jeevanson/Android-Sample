package example.jeevanson.singleviewapplication;

import android.content.Intent;
import android.media.session.PlaybackState;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();
        Toast.makeText(this, intent.getExtras().getString("message"),Toast.LENGTH_LONG).show();
        setContentView(R.layout.color_picker_layout);


        final EditText redField = (EditText) findViewById(R.id.textFieldRed);
        final EditText greenField = (EditText) findViewById(R.id.textFieldGreen);
        final EditText blueField = (EditText) findViewById(R.id.textFieldBlue);
        final CustomView customView = (CustomView) findViewById(R.id.customView);



        Button button = (Button) findViewById(R.id.updateButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int red = Integer.parseInt(redField.getText().toString());
                int green = Integer.parseInt(greenField.getText().toString());
                int blue = Integer.parseInt(blueField.getText().toString());

                customView.setViewBackground(red,green,blue);
            }
        });



    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }


    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
