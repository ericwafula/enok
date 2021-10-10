package com.moringaschool.enok.network;

import com.moringaschool.enok.constants.Authorization;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginClient {

    public static LoginApi getUserLoginCredentials(){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Authorization.HELP_DESK_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(LoginApi.class);
    }
}
