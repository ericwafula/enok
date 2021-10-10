package com.moringaschool.enok.network;



import com.moringaschool.enok.models.Login;
import com.moringaschool.enok.models.User;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface LoginApi {

//    @FormUrlEncoded
    @POST("auth/login")
    Call<User> loginUser(@Body Login login);

    @GET("question")
    Call<ResponseBody> getProfileQuestions(@Header("Authorization") String authToken);
}
