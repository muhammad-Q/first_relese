package com.example.firstrelese.Api_package;


import android.os.Build;

import androidx.annotation.RequiresApi;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;
import java.util.function.Consumer;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

class Controller implements Callback<List<WhatsappMessageBody>> {

    static final String BASE_URL = "https://git.eclipse.org/r/";

    public void start() {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        GerritAPI gerritAPI = retrofit.create(GerritAPI.class);

        Call<List<WhatsappMessageBody>> call = gerritAPI.loadChanges("status:open");
        call.enqueue(this);

    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onResponse(Call<List<WhatsappMessageBody>> call, Response<List<WhatsappMessageBody>> response) {
        if(response.isSuccessful()) {
            List<WhatsappMessageBody> changesList = response.body();
            changesList.forEach(new Consumer<WhatsappMessageBody>() {
                @Override
                public void accept(WhatsappMessageBody change) {
                    System.out.println(change.chatId);
                }
            });
        } else {
            System.out.println(response.errorBody());
        }
    }

    @Override
    public void onFailure(Call<List<WhatsappMessageBody>> call, Throwable t) {

    }

}