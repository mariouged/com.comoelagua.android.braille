package com.comoelagua.android.braille;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.comoelagua.android.braille.model.beans.ResultExercise;

public class ResultsExercisesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results_exercises);

        setResults();
    }

    protected void setResults() {
        Intent intent = getIntent();
        ResultExercise resultExercise = (ResultExercise) intent.getSerializableExtra(WordExercisesActivity.RESULT_EXERCISE);

        TextView okValueTextView = (TextView) findViewById(R.id.okValue);
        okValueTextView.setText("" + resultExercise.getOkCount());
        TextView failValueTextView = (TextView) findViewById(R.id.failValue);
        failValueTextView.setText("" + resultExercise.getFailCount());

        TextView charactersErrorsList = (TextView) findViewById(R.id.charactersErrorsList);
        String joinCharStrError = "";
        for(String charStrError : resultExercise.getCharactersErrorsList()) {
            joinCharStrError += charStrError + "\n";
        }
        charactersErrorsList.setText(joinCharStrError);
    }
}
