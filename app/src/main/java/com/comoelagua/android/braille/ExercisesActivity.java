package com.comoelagua.android.braille;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class ExercisesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercises);

        TextView askLabel = (TextView) findViewById(R.id.askLabel);
        askLabel.setText(askLabel.getText() + " " + 1);

        TextView askTextView = (TextView) findViewById(R.id.ask);
        Typeface typeFace = Typeface.createFromAsset(getAssets(), "fonts/Braille6-ANSI.ttf");
        askTextView.setTypeface(typeFace);
        askTextView.setText("papá aupa al niño");
    }

    public void checkEquals(View view) {
        TextView askTextView = (TextView) findViewById(R.id.ask);
        EditText answerEditText = (EditText) findViewById(R.id.answer);
        String ask = (String) askTextView.getText();
        String answer = answerEditText.getText().toString();
        String result = "CHEK";
        if (ask.equals(answer)) {
            result = "OK";
        } else {
            result = "FAIL";
        }

        TextView askLog = (TextView) findViewById(R.id.askLog);
        askLog.setText(ask + ";");
        TextView answerLog = (TextView) findViewById(R.id.answerLog);
        answerLog.setText(answer + ";");
        TextView checkLog = (TextView) findViewById(R.id.checkLog);
        checkLog.setText(result + ";");
    }
}
