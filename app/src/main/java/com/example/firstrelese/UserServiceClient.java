package com.example.firstrelese;

import java.io.IOException;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class UserServiceClient 
{
	public  void main() throws IOException {
		/*HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
		logging.setLevel(HttpLoggingInterceptor.Level.BASIC);*/
		
		OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
		
		Retrofit retrofit = new Retrofit.Builder()
		 /* .baseUrl(" http://192.168.88.8:8000")*/
				.baseUrl("https://api.chat-api.com/instance103335/sendMessage?token=qvvo14y05xfgdnvq&chatId=963948811066-1582551269@g.us&body=kjkjkjk")
		  .addConverterFactory(GsonConverterFactory.create())
		  .client(httpClient.build())
		  .build();

	//	UserService service = retrofit.create(UserService.class);

		/*// Calling '/api/users'
		Call<UsersApiResponse> callSync = service.getUsers(10, 2);
		 
		try {
		    Response<UsersApiResponse> response = callSync.execute();
		    UsersApiResponse apiResponse = response.body();
		    System.out.println(apiResponse);
		} catch (Exception ex) { 
			ex.printStackTrace();
		}*/
		
		// Calling '/api/users/2'

//		Call<UserApiResponse> callSync = service.getUser(2);
//
//		    Response<UserApiResponse> response = callSync.execute();
//		    UserApiResponse apiResponse = response.body();
//		    System.out.println(apiResponse);

	//	Call<car_serviece> callSync = service.getUsers();

	//	Response<car_serviece> response = callSync.execute();
	//	car_serviece apiResponse = response.body();
	//	System.out.println(apiResponse);
	}
}
