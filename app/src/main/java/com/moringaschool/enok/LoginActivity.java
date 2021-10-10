package com.moringaschool.enok;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.moringaschool.enok.constants.Authorization;
import com.moringaschool.enok.models.Login;
import com.moringaschool.enok.models.User;
import com.moringaschool.enok.network.LoginApi;
import com.moringaschool.enok.network.LoginClient;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    public static final String TAG = LoginActivity.class.getSimpleName();
    private static String token;
    EditText mEmail;
    EditText mPassword;
    Button loginButton;
    Button getSecretButton;

    LoginApi loginClient = LoginClient.getUserLoginCredentials();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mEmail = (EditText) findViewById(R.id.editTextTextEmailAddress2);
        mPassword = (EditText) findViewById(R.id.editTextTextPassword2);
        loginButton = (Button) findViewById(R.id.button2);
        getSecretButton = (Button) findViewById(R.id.getSecretButton);

        String email = mEmail.getText().toString().trim();
        String password = mPassword.getText().toString().trim();



        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
            }
        });

        getSecretButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSecret();
            }
        });
    }

    public void login(){
        Login login = new Login("wathomeeric@gmail.com", "testtest");
        Call<User> call = loginClient.loginUser(login);
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(LoginActivity.this, response.body().getTokens().getAccess(), Toast.LENGTH_SHORT).show();
                    token = response.body().getTokens().getAccess();
                } else {
                    Toast.makeText(LoginActivity.this, "login not correct", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Toast.makeText(LoginActivity.this, "onFailure", Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void getSecret(){
        Call<ResponseBody> call = loginClient.getProfileQuestions(token);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()) {
                    try {
                        Toast.makeText(LoginActivity.this, response.body().string(), Toast.LENGTH_SHORT).show();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                } else {
                    Toast.makeText(LoginActivity.this, "Token is not correct", Toast.LENGTH_SHORT).show();
                    Log.e(TAG, "onResponse: ");
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(LoginActivity.this, "onFailure", Toast.LENGTH_SHORT).show();
            }
        });
    }
}