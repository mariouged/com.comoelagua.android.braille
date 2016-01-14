package com.comoelagua.android.braille;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class ResultsExercisesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results_exercises);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        setResults();
    }

    protected void setResults() {
        Intent intent = getIntent();
        String okValue = intent.getStringExtra(WordExercisesActivity.OK_VALUE);
        String failValue = intent.getStringExtra(WordExercisesActivity.FAIL_VALUE);

        TextView okValueTextView = (TextView) findViewById(R.id.okValue);
        okValueTextView.setText(okValue);
        TextView failValueTextView = (TextView) findViewById(R.id.failValue);
        failValueTextView.setText(failValue);
    }
}
