package example.jeevanson.asynctaskdemo;

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
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import javax.net.ssl.HttpsURLConnection;

import example.jeevanson.singleviewapplication.R;

public class AsynctaskDemoActivity extends AppCompatActivity {


    TextView webServiceResponseTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asynctask_demo);

        webServiceResponseTextView = findViewById(R.id.webServiceResponseViewId);

        MyAsyncTask myAsyncTask = new MyAsyncTask();
        myAsyncTask.execute();
    }

    String webServiceTest() {

        String result = "";
        try {
            URL url = new URL("https://cdn.rawgit.com/arpitmandliya/AndroidRestJSONExample/master/countries.json");

            HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();

            InputStream is = new BufferedInputStream(connection.getInputStream());

            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            StringBuilder out = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                out.append(line);
            }

            System.out.println(out.toString());
            result = out.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }


    class MyAsyncTask extends AsyncTask<String,String,String> {


        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(String... strings) {

            String result = webServiceTest();
            return result;
        }

        @Override
        protected void onPostExecute(String s) {
            parseJSON(s);
            webServiceResponseTextView.setText(s);
            super.onPostExecute(s);
        }
    }


    void parseJSON(String jsonString) {

        ArrayList<CountryData> countryList = new ArrayList<>();

        try {
            JSONArray countryArray = new JSONArray(jsonString);

            for(int i = 0; i < countryArray.length(); i++) {

                JSONObject countryJSON = countryArray.getJSONObject(i);
                String id = countryJSON.getString("id");
                String name = countryJSON.getString("countryName");
                CountryData data = new CountryData(id,name);
                countryList.add(data);
            }


        } catch (JSONException e) {
            e.printStackTrace();
        }

        for( CountryData data : countryList) {

            System.out.println(" country id: "+ data.id);
            System.out.println(" country name: "+ data.name);
        }


    }



    static class CountryData {
        String id;
        String name;

        CountryData(String id, String name) {
            this.id = id;
            this.name = name;
        }

    }


}
