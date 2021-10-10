package com.moringaschool.enok.network;

import com.moringaschool.enok.constants.Authorization;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class QuestionClient {
    private static Retrofit retrofit = null;

    public static QuestionApi getQuestions(){
        if (retrofit == null){
            OkHttpClient okHttpClient = new OkHttpClient.Builder()
                    .addInterceptor(new Interceptor() {
                        @Override
                        public Response intercept(Chain chain) throws IOException {
                            Request newRequest = chain.request().newBuilder()
                                    .addHeader("Authorization", "Bearer " + Authorization.authorization)
                                    .build();

                            return chain.proceed(newRequest);
                        }
                    }).build();

            retrofit = new Retrofit.Builder()
                    .baseUrl(Authorization.HELP_DESK_BASE_URL)
                    .client(okHttpClient)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(QuestionApi.class);
    }
}
