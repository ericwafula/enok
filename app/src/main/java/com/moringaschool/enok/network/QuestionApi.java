package com.moringaschool.enok.network;

import com.moringaschool.enok.models.Question;

import retrofit2.Call;
import retrofit2.http.GET;

public interface QuestionApi {
    @GET("question")
    Call<Question> getQuestions();
}
