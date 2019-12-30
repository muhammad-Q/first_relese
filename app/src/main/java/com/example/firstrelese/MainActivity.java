package com.example.firstrelese;

import android.app.ProgressDialog;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Cache;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.BasicNetwork;
import com.android.volley.toolbox.DiskBasedCache;
import com.android.volley.toolbox.HurlStack;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.firstrelese.ui.main.MainFragment;
import com.example.firstrelese.ui.main.add_item;
import com.example.firstrelese.ui.main.charge;
import com.example.firstrelese.ui.main.view_item;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Locale;

import static java.util.Locale.forLanguageTag;

public class MainActivity extends AppCompatActivity {
    private ProgressDialog pDialog;

    private static String url_create_product = "http://192.168.14.137:8000/android";
    // JSON Node names
    private static final String TAG_SUCCESS = "success";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        RequestQueue requestQueue;
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, MainFragment.newInstance())
                    .commitNow();

            loadWeather("90210");

            final TextView t=findViewById(R.id.t);


    }
    }
    private void loadWeather(String zipCode) {
        String apiUrl = "http://192.168.1.196:8000/android";

        RequestQueue mRequestQueue;

        // Instantiate the cache
        Cache cache = new DiskBasedCache(getCacheDir(), 1024 * 1024);

        // Setup the network to use the HTTPURLConnection client
        BasicNetwork network = new BasicNetwork(new HurlStack());

        // Instantiate the request queue
        mRequestQueue = new RequestQueue(cache, network);

        // Start the queue
        mRequestQueue.start();

        JsonObjectRequest jsObjRequest = new JsonObjectRequest
                (Request.Method.POST, apiUrl, null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        // Load the initial JSON request
                        try {
                          /*  JSONObject mainWeather = response.getJSONObject("main");
                            double temperatureKelvin = mainWeather.getDouble("temp");
                            int temperatureFahrenheit = (int) (temperatureKelvin * 9/5 - 459.67);

                            TextView weatherTextView = (TextView) findViewById(R.id.t);
                            weatherTextView.setText("The temperature is " + temperatureFahrenheit);

                            Toast.makeText(getBaseContext(), "The temperature is " + temperatureFahrenheit, Toast.LENGTH_SHORT).show();
                        */
                        } catch (Exception e) {

                            e.printStackTrace();
                        }
                    } },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                error.printStackTrace();

                                VolleyLog.e("Error: ", error.toString());
                                VolleyLog.e("Error: ", error.getLocalizedMessage());
                            }
                        });

        // Add the request to the RequestQueue
        mRequestQueue.add(jsObjRequest);
    }
    public class myconnection extends AsyncTask<String,String,String>{

        @Override
        protected void onProgressUpdate(String... values) {
            super.onProgressUpdate(values);

        }

        @Override
        protected void onPreExecute() {

            super.onPreExecute();
        }

        @Override
        protected String doInBackground(String... strings) {

        return null;
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.P)
    public void view_item(View view) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, view_item.newInstance())
                    .commitNow();
            ListView list = (ListView) findViewById(R.id.list);
        db = new db_connection(this);
        ArrayList<String> a = db.print();
        list.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, a));
        }
    public void add_item(View view) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container, add_item.newInstance())
                        .commitNow();
    }
    db_connection db;
    @RequiresApi(api = Build.VERSION_CODES.P)
    public void db_save(View view) {
        EditText name = (EditText) findViewById(R.id.name);
        EditText nick_name = (EditText) findViewById(R.id.nick_name);
        EditText group_name = (EditText) findViewById(R.id.group_name);

        ListView list = (ListView) findViewById(R.id.list);

        db = new db_connection(this);
       if(TextUtils.isEmpty(name.getText())){
                name.setError("Name is Required.");
                return;
            }
            if(TextUtils.isEmpty(nick_name.getText())){
                nick_name.setError("nick name is Required.");
                return;
            }

            if(TextUtils.isEmpty(group_name.getText())){
                group_name.setError("group is Required.");
                return;
            }
            db.insert(name.getText().toString(),nick_name.getText().toString(),group_name.getText().toString());
            name.setText("");
            nick_name.setText("");
            group_name.setText("");

            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, MainFragment.newInstance())
                    .commitNow();



    }

    public void back_main(View view) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, MainFragment.newInstance())
                .commitNow();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void change_language(View view) {
Button current_language =findViewById(R.id.language_button);
if(current_language.getText().equals("change language to arabic")) {
    Locale locale = new Locale("ar");
    Resources resources = getResources();
    android.content.res.Configuration configuration = new android.content.res.Configuration();
    DisplayMetrics displayMetrics = resources.getDisplayMetrics();
    configuration.setLocale(forLanguageTag("ar"));
    resources.updateConfiguration(configuration, resources.getDisplayMetrics());

    resources.updateConfiguration(configuration, displayMetrics);

    finish();
    startActivity(this.getIntent());

}
else{
    Locale locale = new Locale("en");
    Resources resources = getResources();
    android.content.res.Configuration configuration = new android.content.res.Configuration();
    DisplayMetrics displayMetrics = resources.getDisplayMetrics();
    configuration.setLocale(forLanguageTag("en"));
    resources.updateConfiguration(configuration, resources.getDisplayMetrics());

    resources.updateConfiguration(configuration, displayMetrics);

    finish();
    startActivity(this.getIntent());


}

    }

    public void send_order(View view) {
EditText driver_name=findViewById(R.id.driver_name);
        EditText car_number =findViewById(R.id.car_number);
        EditText driver_number=findViewById(R.id.driver_number);
        EditText charge_cost=findViewById(R.id.charge_cost);

        if(TextUtils.isEmpty(driver_name.getText())){
            driver_name.setError("your name  is Required.");
            return;
        }
        if(TextUtils.isEmpty(car_number.getText())){
           car_number.setError("car_number is Required.");
            return;
        }

        if(TextUtils.isEmpty(driver_number.getText())){
            driver_number.setError("your phone number  is Required.");
            return;
        }

        if(TextUtils.isEmpty(charge_cost.getText())){
            charge_cost.setError("charge cost  is Required.");
            return;
        }
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, MainFragment.newInstance())
                .commitNow();
    }
    public void make_order(View view) {/*
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, add_order.newInstance())
                .commitNow();
        try {
            java.net.URL connection_url = new java.net.URL("uuu");
            System.out.println("Instantiated new URL: " + connection_url);

            System.out.print("wait");
        StringRequest stringRequest = new StringRequest(Request.Method.POST, connection_url.toString(),
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        System.out.print("accept");

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
System.out.print("feild");
                    }
                }){
            @Override
            protected Map<String,String> getParams(){
                Map<String,String> params = new HashMap<String, String>();
                params.put("group_name","entervero");
//                params.put("KEY_token", token);
                System.out.print("wait map");

                return params;
            }

        };

            System.out.print("wait request");
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
        }
        catch (MalformedURLException e) {
            e.printStackTrace();
        }*/
        // creating new product in background thread

        }
    public void add_charge(View view)
    {

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, charge.newInstance())
                .commitNow();
    }

    public void add_charge2(View view) {

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, MainFragment.newInstance())
                .commitNow();

    }
}


