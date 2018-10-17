package example.jeevanson.restDemo;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import example.jeevanson.singleviewapplication.R;

public class RestDemoActivity extends AppCompatActivity {


    TextView jsonResponseTextView;

    static class CountryData {
        String id;
        String countryName;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rest_demo);

        jsonResponseTextView = findViewById(R.id.jsonResponseTextId);
        MyAsyncTask myAsyncTask = new MyAsyncTask();
        myAsyncTask.execute();

    }


    void parseJSON(String jsonString) {
        try {
            JSONArray jsonArray = new JSONArray(jsonString);

            for(int i =0; i< jsonArray.length(); i++) {
                JSONObject obj = jsonArray.getJSONObject(i);
                String id = obj.getString("id");
                String name = obj.getString("countryName");
                CountryData data = new CountryData();
                data.id = id;
                data.countryName = name;
            }


        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


    public class MyAsyncTask extends AsyncTask<String,String,String>{


        @Override
        protected String doInBackground(String... strings) {

            HttpsURLConnection urlConnection = null;
            String output = null;

            try {
                URL url = new URL("https://cdn.rawgit.com/arpitmandliya/AndroidRestJSONExample/master/countries.json");
                urlConnection = (HttpsURLConnection) url.openConnection();
                InputStream in = new BufferedInputStream(urlConnection.getInputStream());

                BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                StringBuilder out = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    out.append(line);
                }

                System.out.println(out.toString());
//                parseJSON(out.toString());
                output = out.toString();
            } catch (Exception e) {
                e.printStackTrace();
            }
            finally {
                if(urlConnection == null) {
                    urlConnection.disconnect();
                }
            }

            return output;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            parseJSON(s);
            jsonResponseTextView.setText(s);

        }
    }


}
