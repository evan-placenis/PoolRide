package com.example.javapoolrides.RegistrationActivities;

import androidx.appcompat.app.AppCompatActivity;

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

        RadioButton ageButton;
        RadioButton silentButton;
        RadioButton tobaccoButton;

        ageGroup = (RadioGroup) findViewById(R.id.Age);
        silentGroup = (RadioGroup) findViewById(R.id.Silent);
        tobaccoGroup = (RadioGroup) findViewById(R.id.Tobacco);

        int ageId = ageGroup.getCheckedRadioButtonId();
        ageButton = (RadioButton) findViewById(ageId);

        int silentId = silentGroup.getCheckedRadioButtonId();
        silentButton = (RadioButton) findViewById(silentId);

        int tobaccoId = tobaccoGroup.getCheckedRadioButtonId();
        tobaccoButton = (RadioButton) findViewById(tobaccoId);

//        Toast.makeText(QuestionnaireActivity.this,
//                tobaccoButton.getText(), Toast.LENGTH_SHORT).show();

        Intent i = new Intent(this, CustomerHomeActivity.class);
        startActivity(i);
    }
}