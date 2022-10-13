package com.example.cistron;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cistron.Activity.Welcome;
import com.example.cistron.DataParse.ApiClient;
import com.example.cistron.DataParse.responsemodel;
import com.example.cistron.Fragment.Attendence;
import com.example.cistron.Fragment.Home;
import com.example.cistron.InterFace.LoginInterFace;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    EditText uname,pass;
    Button login_btn;
    TextView tvForget;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        uname=findViewById(R.id.edName);
        pass=findViewById(R.id.edPass);
        login_btn=findViewById(R.id.login_btn);

        String UserName=uname.getText().toString();
        String Password=pass.getText().toString();


        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Login(UserName, Password);
                }catch (Exception e){}



            }
        });

    }

     public void Login(String userName, String password) {
        LoginInterFace loginInterFace=ApiClient.getClient().create(LoginInterFace.class);

        Call<responsemodel> call=loginInterFace.getUserLogin(userName,password);

        call.enqueue(new Callback<responsemodel>() {
            @Override
            public void onResponse(Call<responsemodel> call, Response<responsemodel> response) {

                try {
                    if(response.isSuccessful()) {



                        Intent intent = new Intent(MainActivity.this, Welcome.class);
                        startActivity(intent);
                    }
                }catch (Exception e){

                }

            }

            @Override
            public void onFailure(Call<responsemodel> call, Throwable t) {

                Toast.makeText(MainActivity.this, "Login failed", Toast.LENGTH_SHORT).show();

            }
        });


     }




    }

