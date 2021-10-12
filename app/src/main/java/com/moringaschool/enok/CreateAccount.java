package com.moringaschool.enok;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.moringaschool.enok.models.Login;
import com.moringaschool.enok.models.Register;
import com.moringaschool.enok.models.User;
import com.moringaschool.enok.network.LoginApi;
import com.moringaschool.enok.network.LoginClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CreateAccount extends AppCompatActivity {
    EditText mEmail;
    EditText mPassword;
    EditText mUsername;
    Button signupButton;

    LoginApi loginClient = LoginClient.getUserLoginCredentials();
    Register register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        mEmail = (EditText) findViewById(R.id.editTextTextEmailAddress);
        mPassword =  (EditText) findViewById(R.id.editTextTextPersonName);
        mUsername = (EditText) findViewById(R.id.editTextTextPassword);
        signupButton = (Button) findViewById(R.id.button);

        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = mEmail.getText().toString().trim();
                String password = mPassword.getText().toString().trim();
                String username = mUsername.getText().toString().trim();

                register = new Register(email, username, password);
                login();
            }
        });
        
        
    }

    public void login(){
        Call<Register> call = loginClient.createAccount(register);
        call.enqueue(new Callback<Register>() {
            @Override
            public void onResponse(Call<Register> call, Response<Register> response) {
                if (response.isSuccessful()) {
                    register = response.body();
//                    Toast.makeText(CreateAccount.this, response.body().getUsername(), Toast.LENGTH_SHORT).show();
                    Toast.makeText(CreateAccount.this, response.body().getEmail(), Toast.LENGTH_SHORT).show();
                    
                } else {
                    Toast.makeText(CreateAccount.this, "login not correct", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Register> call, Throwable t) {
                Toast.makeText(CreateAccount.this, "onFailure", Toast.LENGTH_SHORT).show();
            }
        });
        
    }
}