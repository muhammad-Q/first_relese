package com.example.firstrelese;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface serviece {
    @GET("api/charges/")
    public Call<Charge2> getcharge();
    @GET("/api/users/{id}")
    public Call<Charge> getUser(@Path("id") long id);
    @GET("/charge/{charge}")
    public Call<Charge> getUser(@Path("charge_id") String username);
}
