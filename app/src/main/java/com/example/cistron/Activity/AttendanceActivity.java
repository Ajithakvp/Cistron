package com.example.cistron.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.cistron.DataParse.ApiClient;
import com.example.cistron.DataParse.responsemodel;
import com.example.cistron.Fragment.Attendence;
import com.example.cistron.InterFace.AttendanceInterface;
import com.example.cistron.Model.AttendanceModel;
import com.example.cistron.R;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.ContentValues.TAG;

public class AttendanceActivity extends AppCompatActivity {

    ImageView ivBack;
    TextInputLayout placeLayout;
    TextInputEditText edtPlace;
    RadioButton rbLocal,rbOutstation,rbExstation,rbRegular,rbTraining,rbMeeting;
    Button btnSubmit;
    RadioGroup rbGroup;
   int placeId;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendance);

        ivBack=findViewById(R.id.ivBack);
        edtPlace=findViewById(R.id.edtPlace);
        rbLocal=findViewById(R.id.rbLocal);
        rbOutstation=findViewById(R.id.rbOutstation);
        rbExstation=findViewById(R.id.rbExstation);
        rbRegular=findViewById(R.id.rbRegular);
        rbTraining=findViewById(R.id.rbTraining);
        rbMeeting=findViewById(R.id.rbMeeting);
        btnSubmit=findViewById(R.id.btnSubmit);
        placeLayout=findViewById(R.id.placeLayout);
        rbGroup=findViewById(R.id.rbGroup);


        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });



        //Submit

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                callAttendance();


            }
        });



//RadioGroup
        rbGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

               View view=rbGroup.findViewById(i);

             int rb=rbGroup.indexOfChild(view);

               switch (rb){
                   case 0:
                       placeId=1;


                       placeLayout.setVisibility(View.GONE);
                       rbLocal.setTextColor(Color.RED);
                       rbTraining.setTextColor(Color.BLACK);
                       rbMeeting.setTextColor(Color.BLACK);
                       rbRegular.setTextColor(Color.BLACK);
                       rbExstation.setTextColor(Color.BLACK);
                       rbOutstation.setTextColor(Color.BLACK);
                       break;
                   case 1:



                       //Out Station
                       placeId=2;

                       placeLayout.setVisibility(View.GONE);
                       rbOutstation.setTextColor(Color.RED);
                       rbTraining.setTextColor(Color.BLACK);
                       rbMeeting.setTextColor(Color.BLACK);
                       rbRegular.setTextColor(Color.BLACK);
                       rbExstation.setTextColor(Color.BLACK);
                       rbLocal.setTextColor(Color.BLACK);
                       break;
                   case 2:

                       //Ex station
                       placeId=11;

                       placeLayout.setVisibility(View.GONE);
                       rbExstation.setTextColor(Color.RED);
                       rbTraining.setTextColor(Color.BLACK);
                       rbMeeting.setTextColor(Color.BLACK);
                       rbRegular.setTextColor(Color.BLACK);
                       rbLocal.setTextColor(Color.BLACK);
                       rbOutstation.setTextColor(Color.BLACK);
                       break;
                   case 3:

                       //Office Regular
                       placeId=4;

                       placeLayout.setVisibility(View.VISIBLE);
                       rbRegular.setTextColor(Color.RED);
                       rbTraining.setTextColor(Color.BLACK);
                       rbMeeting.setTextColor(Color.BLACK);
                       rbLocal.setTextColor(Color.BLACK);
                       rbExstation.setTextColor(Color.BLACK);
                       rbOutstation.setTextColor(Color.BLACK);
                       Toast.makeText(AttendanceActivity.this, "Enter The Place", Toast.LENGTH_SHORT).show();
                       break;
                   case 5:

                       //Training

                       placeId=5;

                       placeLayout.setVisibility(View.GONE);
                       rbTraining.setTextColor(Color.RED);
                       rbLocal.setTextColor(Color.BLACK);
                       rbMeeting.setTextColor(Color.BLACK);
                       rbRegular.setTextColor(Color.BLACK);
                       rbExstation.setTextColor(Color.BLACK);
                       rbOutstation.setTextColor(Color.BLACK);
                       break;
                   case 6:

                       //Meeting
                       placeId=6;

                       placeLayout.setVisibility(View.GONE);
                       rbMeeting.setTextColor(Color.RED);
                       rbTraining.setTextColor(Color.BLACK);
                       rbLocal.setTextColor(Color.BLACK);
                       rbRegular.setTextColor(Color.BLACK);
                       rbExstation.setTextColor(Color.BLACK);
                       rbOutstation.setTextColor(Color.BLACK);
                       break;
               }
            }
        });




    }

    private void callAttendance() {
        AttendanceInterface attendanceInterface= ApiClient.getClient().create(AttendanceInterface.class);
        Call<responsemodel> call=attendanceInterface.getAttendance(placeId,edtPlace.getText().toString());
        call.enqueue(new Callback<responsemodel>() {
            @Override
            public void onResponse(Call<responsemodel> call, Response<responsemodel> response) {
                try {

                    if (response.isSuccessful()){
                        Toast.makeText(AttendanceActivity.this, "Success", Toast.LENGTH_SHORT).show();
                    }

                }catch (Exception e){
                    Toast.makeText(AttendanceActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<responsemodel> call, Throwable t) {


            }
        });
    }
}