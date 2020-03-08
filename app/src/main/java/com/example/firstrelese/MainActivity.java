package com.example.firstrelese;

import android.app.ProgressDialog;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.example.firstrelese.db_connection.DBHelper;
import com.example.firstrelese.ui.main.MainFragment;
import com.example.firstrelese.ui.main.add_item;
import com.example.firstrelese.ui.main.view_item;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;

import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import static java.util.Locale.forLanguageTag;

public class MainActivity extends AppCompatActivity {
    private ProgressDialog pDialog;

    static boolean language = false;
    // JSON Node names
    private static final String TAG_SUCCESS = "success";
    ArrayList<String> a = null;

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        a = new ArrayList<>();
        mydb = new DBHelper(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);


        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, MainFragment.newInstance())
                    .commitNow();
        }

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
    Button button;
    @RequiresApi(api = Build.VERSION_CODES.P)
    public void view_item(View view) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, view_item.newInstance())
                .commitNow();
       // ListView list = (ListView) findViewById(R.id.list);
        a=mydb.getAllCotacts();
        Button b;
        LinearLayout list=null;
        list =findViewById (R.id.list_item1);
for(int i=0;i<a.size ();i++) {
    button = new Button ( this );
    button.setText ( a.get ( i ) );
    button.setOnClickListener ( new View.OnClickListener () {
        @Override
        public void onClick(View v) {
         //   makeText ( MainActivity.this, "This button is created dynamically",
            //        LENGTH_SHORT ).show ()
            //        ;
            a = new ArrayList<>();
            Button b = (Button)v;
            String buttonText = b.getText().toString();
         a=   mydb.get_group ( buttonText);

            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, edit_sitting.newInstance())
                    .commitNow();
            TextView w_group_name=findViewById ( R.id.T_w_group_name );
            w_group_name.setText ( buttonText);
            CheckBox company_name=findViewById ( R.id.T_company_name );
            CheckBox driver_name=findViewById ( R.id.T_driver_name );
            CheckBox driver_phone=findViewById ( R.id.T_driver_phone );
            CheckBox car_number=findViewById ( R.id.T_car_number );
            CheckBox car_rental=findViewById ( R.id.T_car_rental );
            CheckBox price=findViewById ( R.id.T_price );
            CheckBox costumes_decleration=findViewById ( R.id.T_costumes_decleration );
            CheckBox bag_weight=findViewById ( R.id.T_bag_weight);
            int a1,b1,c,d,e,f,g,h;
            a1 =(int)Double.parseDouble (  a.get (2));
            b1=(int)Double.parseDouble (  a.get (3));
            c=(int)Double.parseDouble (  a.get (4));
            d=(int)Double.parseDouble (  a.get (5));
            e=(int)Double.parseDouble (  a.get (6));
            f=(int)Double.parseDouble (  a.get (7));
            g= (int)Double.parseDouble (  a.get (8));
            h=(int)Double.parseDouble (  a.get (9));
            if(a1>0)
            {
company_name.setChecked(true);
            }
            if(b1>0)
            {
                driver_name.setChecked(true);
            }
            if(c>0)
            {
                driver_phone.setChecked(true);
            }
            if(d>0)
            {
                car_number.setChecked(true);
            }
            if(e>0)
            {
                car_rental.setChecked(true);
            }
            if(f>0)
            {price.setChecked(true);}
            if(g>0)
            {costumes_decleration.setChecked(true);
            }
            if(h>0)
            {bag_weight.setChecked(true);}

          //  mydb.insertContact(chatid.getText().toString(),w_group_name.getText().toString(),a,b,c,d,e,f,g,h);


        }
    } );
    button.setLayoutParams ( new LinearLayout.LayoutParams ( LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT ) );
    list.addView ( button );
}
        //  list.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, a));
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

      //  ListView list = (ListView) findViewById(R.id.list);


        if (TextUtils.isEmpty(name.getText())) {
            name.setError("Name is Required.");
            return;
        }

        if (TextUtils.isEmpty(nick_name.getText())) {
            nick_name.setError("nick name is Required.");
            return;
        }

        if (TextUtils.isEmpty(group_name.getText())) {
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
        Button current_language = findViewById(R.id.language_button);
        if (language) {
            language = false;
            Locale locale = new Locale("ar");
            Resources resources = getResources();
            android.content.res.Configuration configuration = new android.content.res.Configuration();
            DisplayMetrics displayMetrics = resources.getDisplayMetrics();
            configuration.setLocale(forLanguageTag("ar"));
            resources.updateConfiguration(configuration, resources.getDisplayMetrics());

            resources.updateConfiguration(configuration, displayMetrics);

            finish();
            startActivity(this.getIntent());

        } else {
            language = true;
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
        EditText driver_name = findViewById(R.id.driver_name);
        EditText car_number = findViewById(R.id.car_number);
        EditText driver_number = findViewById(R.id.driver_number);
        EditText charge_cost = findViewById(R.id.charge_cost);

        if (TextUtils.isEmpty(driver_name.getText())) {
            driver_name.setError("your name  is Required.");
            return;
        }
        if (TextUtils.isEmpty(car_number.getText())) {
            car_number.setError("car_number is Required.");
            return;
        }

        if (TextUtils.isEmpty(driver_number.getText())) {
            driver_number.setError("your phone number  is Required.");
            return;
        }

        if (TextUtils.isEmpty(charge_cost.getText())) {
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

    public void add_charge(View view) {

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, add_edit_group_sitting.newInstance())
                .commitNow();
    }

    String message = "";
    String message2 = "";

    public void add_charge2(View view) {
        TextView driver_name = findViewById(R.id.driver_name);
        TextView driver_number = findViewById(R.id.driver_number);
        TextView car_number = findViewById(R.id.car_number);
      //  CheckBox jor_name = findViewById(R.id.jor_name);
      //  CheckBox new_name = findViewById(R.id.new_name);
        TextView number_of_car = findViewById(R.id.car_rental);
        if (TextUtils.isEmpty(driver_name.getText())) {
            driver_name.setError("your name  is Required.");
            return;
        }
        if (TextUtils.isEmpty(car_number.getText())) {
            car_number.setError("car_number is Required.");
            return;
        }

        if (TextUtils.isEmpty(driver_number.getText())) {
            driver_number.setError("your phone number  is Required.");
            return;
        }
        if (TextUtils.isEmpty(number_of_car.getText())) {
            car_number.setError("car_number is Required.");
            return;
        }

       // if (jor_name.isChecked())
        {
            message2 = "\uD83D\uDD34السلام عليكم سيد محمد سيصلكم سيارة عدد";
            message2 += number_of_car.getText().toString();
            message2 += "من قبلنا";
            message2 += "%0D%0A";
            message2 += "اسم السائق :" + driver_name.getText().toString();
            message2 += "%0D%0A";
            message2 += "رقم السيارة :" + car_number.getText().toString();
            message2 += "%0D%0A";
            message2 += "جوال السائق   :" + driver_number.getText().toString();
            message2 += "%0D%0A";
            message2 += "شاكرين تعاونكم معنا";
            Thread thread = null;
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.KITKAT) {
                thread = new Thread(new Runnable() {

                    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
                    @Override
                    public void run() {
                        try {
                            final OkHttpClient client = new OkHttpClient();


                            Request request = new Request.Builder()
                                    .url("https://api.chat-api.com/instance103346/sendMessage?token=hgxofj5zp8lt4lfr&chatId=963948811066-1582551269@g.us&body=" + message2)
                                    .build();

                            try (Response response = client.newCall(request).execute()) {
                                if (!response.isSuccessful())
                                    throw new IOException("Unexpected code " + response);

                                Headers responseHeaders = response.headers();
                                for (int i = 0; i < responseHeaders.size(); i++) {
                                    ;
                                }

                                System.out.println(response.body().string());
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            //  UserServiceClient userServiceClient=new UserServiceClient();
                            //                        controller2 controller = new controller2();
                            //                        controller.start();
                            //
                            //                        final TextView t = findViewById(R.id.t);


                            //Your code goes here
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
            }

            thread.start();

        }
       // if (new_name.isChecked())
        {
            message = "\uD83D\uDD34السلام عليكم سيد سيف سيصلكم سيارة عدد ";
            message += number_of_car.getText().toString() + " من قبلنا\n";
            message += "%0D%0A";
            message += " السائق :" + driver_name.getText().toString();
            message += "%0D%0A";
            message += " رقم السيارة  :" + car_number.getText().toString();
            message += "%0D%0A";
            message += " جوال السائق   :" + driver_number.getText().toString();
            message += "%0D%0A";
            message += "  شاكرين تعاونكم معنا";

            Thread thread = null;
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.KITKAT) {
                thread = new Thread(new Runnable() {

                    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
                    @Override
                    public void run() {
                        try {
                            final OkHttpClient client = new OkHttpClient();


                            Request request = new Request.Builder()
                                    .url("https://api.chat-api.com/instance103346/sendMessage?token=hgxofj5zp8lt4lfr&chatId=963948811066-1582551269@g.us&body=" + message)
                                    .build();

                            try (Response response = client.newCall(request).execute()) {
                                if (!response.isSuccessful())
                                    throw new IOException("Unexpected code " + response);

                                Headers responseHeaders = response.headers();
                                for (int i = 0; i < responseHeaders.size(); i++) {
                                    System.out.println(responseHeaders.name(i) + ": " + responseHeaders.value(i));
                                }

                                System.out.println(response.body().string());
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            //  UserServiceClient userServiceClient=new UserServiceClient();
                            //                        controller2 controller = new controller2();
                            //                        controller.start();
                            //
                            //                        final TextView t = findViewById(R.id.t);


                            //Your code goes here
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
            }

            thread.start();

        }


    }

    public void nasib_frag(View view) {

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, nasib.newInstance())
                .commitNow();
    }
String message3;
    public void send_message_to_nasib(View view) {
        TextView number_of_car = findViewById(R.id.number_of_car_nasib);
        TextView car_number = findViewById(R.id.car_number_nasib);
        TextView decleration = findViewById(R.id.decleration);
        TextView case_wight = findViewById(R.id.case_wight);
        if (TextUtils.isEmpty(number_of_car.getText())) {
            number_of_car.setError("number of car  is Required.");
            return;
        }
        if (TextUtils.isEmpty(car_number.getText())) {
            car_number.setError("car_number is Required.");
            return;
        }

        if (TextUtils.isEmpty(car_number.getText())) {
            car_number.setError("car_number is Required.");
            return;
        }
        if (TextUtils.isEmpty(case_wight.getText())) {
           case_wight.setError("your phone number  is Required.");
            return;
        }

            message3 = "\uD83D\uDD34السلام عليكم استاذ اياد سيصلكم سيارة عدد ";
            message3 += number_of_car.getText().toString();
            message3 += "من قبلنا";
            message3 += car_number.getText().toString();
            message3 += "%0D%0A";
            message3 +="الرجاء اضافة الارقام التالية الى البيان الجمركي ";
            message3 += "%0D%0A";
            message3 += decleration.getText().toString();
            message3 += "%0D%0A";
            message3+="وزن الكيس ";
            message3+=case_wight.getText().toString();
            message3 += "%0D%0A";
            message3+="سيتم تنزيل البضاعة في مستودعنا  ";
            message3 += "%0D%0A";
            message3+="*الرجاء ارسال بيان جمركي مع السائق ضروري*";
            message3 += "%0D%0A";
            message3 += "شاكرين تعاونكم معنا";
            Thread thread = null;
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.KITKAT) {
                thread = new Thread(new Runnable() {

                    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
                    @Override
                    public void run() {
                        try {
                            final OkHttpClient client = new OkHttpClient();


                            Request request = new Request.Builder()
                                    .url("https://api.chat-api.com/instance103346/sendMessage?token=hgxofj5zp8lt4lfr&chatId=963948811066-1582551269@g.us&body=" +message3)
                                    .build();

                            try (Response response = client.newCall(request).execute()) {
                                if (!response.isSuccessful())
                                    throw new IOException("Unexpected code " + response);

                                Headers responseHeaders = response.headers();
                                for (int i = 0; i < responseHeaders.size(); i++) {
                                    ;
                                }

                                System.out.println(response.body().string());
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            //  UserServiceClient userServiceClient=new UserServiceClient();
                            //                        controller2 controller = new controller2();
                            //                        controller.start();
                            //
                            //                        final TextView t = findViewById(R.id.t);


                            //Your code goes here
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
            }

            thread.start();

        }
    private DBHelper mydb ;
    public void add_edit_group(View view) {

         TextView chatid = findViewById(R.id.chatid);
     TextView w_group_name = findViewById(R.id.w_group_name);
         CheckBox company_name=findViewById(R.id._company_name);
        CheckBox driver_name=findViewById(R.id._driver_name);
     CheckBox driver_phone=findViewById(R.id._driver_phone);
     CheckBox car_number=findViewById(R.id._car_number);
  CheckBox car_rental=findViewById(R.id._car_rental);
     CheckBox price=findViewById(R.id._price);
        CheckBox costumes_decleration=findViewById(R.id._costumes_decleration);
       CheckBox bag_weight=findViewById(R.id._bag_weight);
int  a,b,c,d;
int  e,f,g,h;
a=b=c=d=e=f=g=h=0;
if(company_name.isChecked())
{a=1;

}
        if(driver_name.isChecked())
        {
            b=1;
        }
        if(driver_phone.isChecked())
        {
            c=1;
        }
        if(car_number.isChecked())
        {d=1;}
        if(car_rental.isChecked())
        {e=1;}
        if(price.isChecked())
        {f=1;}
        if(costumes_decleration.isChecked())
        {g=1;}
        if(bag_weight.isChecked())
        {h=1;}

mydb.insertContact(chatid.getText().toString(),w_group_name.getText().toString(),a,b,c,d,e,f,g,h);

    }

    public void add_edit(View view) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, add_edit_group_sitting.newInstance())
                .commitNow();
    }

    public void edit_group(View view) {
        TextView w_group_name = findViewById(R.id.T_w_group_name);
        CheckBox company_name=findViewById(R.id.T_company_name);
        CheckBox driver_name=findViewById(R.id.T_driver_name);
        CheckBox driver_phone=findViewById(R.id.T_driver_phone);
        CheckBox car_number=findViewById(R.id.T_car_number);
        CheckBox car_rental=findViewById(R.id.T_car_rental);
        CheckBox price=findViewById(R.id.T_price);
        CheckBox costumes_decleration=findViewById(R.id.T_costumes_decleration);
        CheckBox bag_weight=findViewById(R.id.T_bag_weight);
        int  a1,b1,c,d;
        int  e,f,g,h;
        a1=b1=c=d=e=f=g=h=0;
        if(company_name.isChecked())
        {a1=1;

        }
        else
            a1=0;
        if(driver_name.isChecked())
        {
            b1=1;
        }

        else
            b1=0;
        if(driver_phone.isChecked())
        {
            c=1;
        }

        else
            c=0;
        if(car_number.isChecked())
        {d=1;}
        else
            d=0;
        if(car_rental.isChecked())
        {e=1;}

        else
            e=0;
        if(price.isChecked())
        {f=1;}
        else
            f=0;
        if(costumes_decleration.isChecked())
        {g=1;}
        else
            a1=0;
        if(bag_weight.isChecked())
        {h=1;}
        else
            a1=0;
        a = new ArrayList<>();
        a=   mydb.get_group (w_group_name.getText ().toString ());
        int id=(int )Double.parseDouble ( a.get (10));
        mydb.updateContact (id,a1,b1,c,d,e,f,g,h);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, MainFragment.newInstance())
                .commitNow();
    }

}


    