package com.example.cistron;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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
import com.google.android.material.textfield.TextInputEditText;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.ContentValues.TAG;

public class MainActivity extends AppCompatActivity {

    TextInputEditText uname,pass;
    Button login_btn;
    TextView tvForget;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        uname=findViewById(R.id.edName);
        pass=findViewById(R.id.edPass);
        login_btn=findViewById(R.id.login_btn);




        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                try {
                    Login();
                }catch (Exception e){}



            }
        });

    }

     public void Login() {
        LoginInterFace loginInterFace=ApiClient.getClient().create(LoginInterFace.class);

        Call<responsemodel> call=loginInterFace.getUserLogin(uname.getText().toString(),pass.getText().toString());

        call.enqueue(new Callback<responsemodel>() {
            @Override
            public void onResponse(Call<responsemodel> call, Response<responsemodel> response)


            {

//                String msg=response.message().toString();
//
//           Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();


                try {

         if(response.isSuccessful()) {

             Toast.makeText(MainActivity.this, "Login Successfully", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(MainActivity.this, Welcome.class);
                        startActivity(intent);
         }
                }catch (Exception e){
                    String msg=response.message().toString();
                    Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();

                }

            }

            @Override
            public void onFailure(Call<responsemodel> call, Throwable t) {

                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });


     }




    }

