package com.example.firstrelese.Api_package;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GerritAPI {
    @GET("changes/")
    Call<List<WhatsappMessageBody>> loadChanges(@Query("q") String status);
}
