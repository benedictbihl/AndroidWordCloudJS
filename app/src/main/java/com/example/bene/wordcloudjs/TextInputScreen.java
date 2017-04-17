package com.example.bene.wordcloudjs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;

public class TextInputScreen extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_input_screen);
        Button b = (Button) findViewById(R.id.submitBtn);
        b.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this,MainActivity.class);

        //retrieve Inputs
        final EditText textInput = (EditText) findViewById(R.id.textInput);
        final EditText maxWordsInput = (EditText) findViewById(R.id.maxWordsInput);
        final Switch rotateWords = (Switch) findViewById(R.id.rotateSwitch);

        //make them to Strings
        String textInputString = textInput.getText().toString();
        String maxWordsString = maxWordsInput.getText().toString();
        String rotateWordsString = "false";

        if (rotateWords.isChecked()){
            rotateWordsString = "true";
        }

        //send with intent onClick
        intent.putExtra("CloudText",textInputString);
        intent.putExtra("MaxWords",maxWordsString);
        intent.putExtra("RotateWords", rotateWordsString);

        startActivity(intent);

    }


}
