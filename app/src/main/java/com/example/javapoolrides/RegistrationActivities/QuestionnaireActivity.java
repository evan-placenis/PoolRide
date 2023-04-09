package com.example.javapoolrides.RegistrationActivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.javapoolrides.CustomerHomeActivity;
import com.example.javapoolrides.R;

public class QuestionnaireActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questionnaire);
        setTitle("Questionnaire");
    }

    public void submit(View v) {
        RadioGroup ageGroup;
        RadioGroup silentGroup;
        RadioGroup tobaccoGroup;

        RadioButton ageResult;
        RadioButton silentResult;
        RadioButton tobaccoResult;

        ageGroup = (RadioGroup) findViewById(R.id.Age);
        silentGroup = (RadioGroup) findViewById(R.id.Silent);
        tobaccoGroup = (RadioGroup) findViewById(R.id.Tobacco);

        int ageId = ageGroup.getCheckedRadioButtonId();
        ageResult = (RadioButton) findViewById(ageId);

        int silentId = silentGroup.getCheckedRadioButtonId();
        silentResult = (RadioButton) findViewById(silentId);

        int tobaccoId = tobaccoGroup.getCheckedRadioButtonId();
        tobaccoResult = (RadioButton) findViewById(tobaccoId);

//        Toast.makeText(QuestionnaireActivity.this,
//                tobaccoButton.getText(), Toast.LENGTH_SHORT).show();

//        ContentValues cv = new ContentValues();
//        cv.put("question1", String.valueOf(ageResult));
//        cv.put("question2", String.valueOf(silentResult));
//        cv.put("question3", String.valueOf(ageResult));

        Intent i = new Intent(this, CustomerHomeActivity.class);
        startActivity(i);
    }
}