package com.example.firstrelese;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AndroidException;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;


import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.firstrelese.ui.main.MainFragment;
import com.example.firstrelese.ui.main.add_item;
import com.example.firstrelese.ui.main.add_order;
import com.example.firstrelese.ui.main.charge;
import com.example.firstrelese.ui.main.view_item;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

import static java.util.Locale.*;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, MainFragment.newInstance())
                    .commitNow();
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

    public void make_order(View view) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, add_order.newInstance())
                .commitNow();
        try {
            java.net.URL connection_url = new java.net.URL("http://127.0.0.1:8000/login");
            System.out.println("Instantiated new URL: " + connection_url);


        StringRequest stringRequest = new StringRequest(Request.Method.POST, connection_url.toString(),
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }){
            @Override
            protected Map<String,String> getParams(){
                Map<String,String> params = new HashMap<String, String>();
                params.put("subject_name","muhammad");
                params.put("subject_nick_name","12345678");
                params.put("group_id","11");

//                params.put("KEY_token", token);
                return params;
            }

        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
        }
        catch (MalformedURLException e) {
            e.printStackTrace();
        }
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


