package com.example.firstrelese;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface UserService {

    @GET("/api/charges")
    public Call<car_serviece> getUsers();
    @FormUrlEncoded
    @POST("/")
    Call<ApiResponse> request(@Field("api_key") String apiKey, @Field("app_id") String appId);

    @GET("/api/charge/{id}")
    public Call<UserApiResponse> getUser(@Path("id") long id);

}