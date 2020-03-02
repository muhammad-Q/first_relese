package com.example.firstrelese;

import java.io.IOException;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class chargeServiceClient
{
	public void main() throws IOException {

		
		OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
		
		Retrofit retrofit = new Retrofit.Builder()
		  .baseUrl("http://192.168.88.8:8000/")
		  .addConverterFactory(GsonConverterFactory.create())
		  .client(httpClient.build())
		  .build();
//		Service service = retrofit.create(Service.class);
//		Call<ChargeBill> call=service.getcharge();
//		    Response<ChargeBill> response = call.execute();
//
//		ChargeBill apiResponse = response.body();
//		    return apiResponse ;
	}
}
