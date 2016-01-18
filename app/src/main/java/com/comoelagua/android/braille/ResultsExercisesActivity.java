package com.comoelagua.android.braille;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.TextView;

import com.comoelagua.android.braille.adapter.CharacterErrorAdapter;
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

        ListView charactersErrorsList = (ListView) findViewById(R.id.charactersErrorsList);
        charactersErrorsList.setAdapter(new CharacterErrorAdapter(this, resultExercise.getCharactersErrorsList()));

    }
}
