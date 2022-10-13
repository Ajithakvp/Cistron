package com.example.cistron.Activity;

import androidx.appcompat.app.AppCompatActivity;

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

import com.example.cistron.R;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import static android.content.ContentValues.TAG;

public class AttendanceActivity extends AppCompatActivity {

    ImageView ivBack;
    TextInputLayout placeLayout;
    TextInputEditText edtPlace;
    RadioButton rbLocal,rbOutstation,rbExstation,rbRegular,rbTraining,rbMeeting;
    Button btnSubmit;
    RadioGroup rbGroup;


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



        //Submit

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              rbLocal=rbGroup.findViewById(rbGroup.getCheckedRadioButtonId());

              String Radio=rbLocal.getText().toString();
                Toast.makeText(AttendanceActivity.this, Radio, Toast.LENGTH_SHORT).show();


            }
        });



//RadioGroup
        rbGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

               View view=rbGroup.findViewById(i);
               int rg=rbGroup.indexOfChild(view);

               switch (rg){
                   case 0:

                       //Local

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
                       Log.d(TAG, "onCheckedChanged:Click ");

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
}