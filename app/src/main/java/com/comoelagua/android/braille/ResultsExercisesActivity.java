/**
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 * Contact: <mario.ugedo@gmail.com>
 */
package com.comoelagua.android.braille;

import android.content.Intent;
import android.content.SharedPreferences;
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

        Intent intent = getIntent();
        ResultExercise resultExercise = (ResultExercise) intent.getSerializableExtra(WordExercisesActivity.RESULT_EXERCISE);

        setResults(resultExercise);
    }

    protected void setResults(ResultExercise resultExercise) {
        TextView okValueTextView = (TextView) findViewById(R.id.okValue);
        okValueTextView.setText("" + resultExercise.getOkCount());
        TextView failValueTextView = (TextView) findViewById(R.id.failValue);
        failValueTextView.setText("" + resultExercise.getFailCount());
        TextView timeValueTextView = (TextView) findViewById(R.id.timeValue);
        timeValueTextView.setText("" + Math.round(resultExercise.getTime() / 1000));
        TextView bestTimeValueTextView = (TextView) findViewById(R.id.bestTimeValue);
        bestTimeValueTextView.setText("" + Math.round(resultExercise.getBestTimeValue() / 1000));
        ListView charactersErrorsList = (ListView) findViewById(R.id.charactersErrorsList);
        charactersErrorsList.setAdapter(new CharacterErrorAdapter(this, resultExercise.getCharactersErrorsList()));
    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
        finish();
    }

}
