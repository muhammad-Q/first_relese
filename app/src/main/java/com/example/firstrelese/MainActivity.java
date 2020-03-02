package com.example.firstrelese;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.example.firstrelese.Api_package.Controller;
import com.example.firstrelese.ui.main.MainFragment;
import com.example.firstrelese.ui.main.add_item;
import com.example.firstrelese.ui.main.charge;
import com.example.firstrelese.ui.main.view_item;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;

import static java.util.Locale.forLanguageTag;

public class MainActivity extends AppCompatActivity {
    private ProgressDialog pDialog;

static boolean language=false;
    // JSON Node names
    private static final String TAG_SUCCESS = "success";
    ArrayList<String> a = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        a=new ArrayList<>();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, MainFragment.newInstance())
                    .commitNow();
            Thread thread = new Thread(new Runnable() {

                @Override
                public void run() {
                    try  {
                        UserServiceClient userServiceClient=new UserServiceClient();
                        try {
                            controller controller = new controller();



                            final TextView t = findViewById(R.id.t);



                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        //Your code goes here
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });

            thread.start();




           // sendWhatsAppMessageTo("963934519076");
           /* PackageManager pm=getPackageManager();
            try {

                Intent waIntent = new Intent(Intent.ACTION_SEND);
                waIntent.setType("text/plain");
                String text = "hello";

                PackageInfo info=pm.getPackageInfo("com.whatsapp", PackageManager.GET_META_DATA);
                //Check if package exists or not. If not then code
                //in catch block will be called
                waIntent.setPackage("com.whatsapp");

                waIntent.putExtra(Intent.EXTRA_TEXT, text);
                startActivity(Intent.createChooser(waIntent, "963934519076"));

            } catch (PackageManager.NameNotFoundException e) {
                Toast.makeText(this, "WhatsApp not Installed", Toast.LENGTH_SHORT)
                        .show();
            }*/
            /*Uri uri=Uri.parse("smsto:"+"963934519076/Happy Club");
            Intent intent=new Intent(Intent.ACTION_SENDTO,uri);
            intent.setPackage("com.whatsapp");
            startActivity(intent);*/

        }
    }
    public void sendWhatsAppMessageTo(String whatsappid) {

        startActivity(new Intent(Intent.ACTION_VIEW,
                Uri.parse(
                        String.format("https://api.whatsapp.com/send?phone=%s&text=%s",
                                "9630934519076/Happy Club","Happy Club", "ddd"))));

       }


    @RequiresApi(api = Build.VERSION_CODES.P)
    public void view_item(View view) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, view_item.newInstance())
                    .commitNow();
            ListView list = (ListView) findViewById(R.id.list);


        list.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, a));
        }
    public void add_item(View view) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container, add_item.newInstance())
                        .commitNow();
    }

    @RequiresApi(api = Build.VERSION_CODES.P)
    public void db_save(View view) {
        EditText name = (EditText) findViewById(R.id.name);
        EditText nick_name = (EditText) findViewById(R.id.nick_name);
        EditText group_name = (EditText) findViewById(R.id.group_name);

        ListView list = (ListView) findViewById(R.id.list);


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
if(!language) {
    Locale locale = new Locale("ar");
    Resources resources = getResources();
    android.content.res.Configuration configuration = new android.content.res.Configuration();
    DisplayMetrics displayMetrics = resources.getDisplayMetrics();
    configuration.setLocale(forLanguageTag("ar"));
    resources.updateConfiguration(configuration, resources.getDisplayMetrics());

    resources.updateConfiguration(configuration, displayMetrics);

    finish();
    startActivity(this.getIntent());
language=true;
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
        TextView driver_name=findViewById(R.id.driver_name);
        TextView driver_number=findViewById(R.id.driver_number);
        TextView car_number=findViewById(R.id.car_number);
        CheckBox j=findViewById(R.id.checkbox_j);
        CheckBox a=findViewById(R.id.checkbox_a);
        TextView number_of_car=findViewById(R.id.number_of_car);
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
        if(TextUtils.isEmpty(number_of_car.getText())){
            car_number.setError("car_number is Required.");
            return;
        }
        String message ="";
        if(j.isChecked())
        {
            message+="<✅تخليص الحديثة<:\n";
        }
        if(a.isChecked())
        {
            message+="<✅تخليص الأردن والأمانة<\n";
        }
        message+="عدد"+number_of_car.getText().toString()+" من قبلنا\n";
     message+= " السائق :"+driver_name.getText().toString()+"\n رقم السيارة  :"+car_number.getText().toString()+"\n جوال السائق   :"+driver_number.getText().toString()+"\n  شاكرين تعاونكم معنا";
        String phoneNumberWithCountryCode = "+963943050888";


        startActivity(new Intent(Intent.ACTION_VIEW,
                Uri.parse(
                        String.format("https://api.chat-api.com/instance101871/sendMessage?token=zvxn5k8k6vuaz4c5&chatId=963953436713-1470309480@g.us&body="+message,
                                phoneNumberWithCountryCode, message))));



    }
}


    