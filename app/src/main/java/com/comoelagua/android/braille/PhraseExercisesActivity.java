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

import com.comoelagua.android.braille.model.beans.ResultExercise;
import com.comoelagua.android.braille.model.daos.containers.DaosContainer;
import com.comoelagua.android.braille.model.daos.interfaces.WordsDaoInterface;
import com.comoelagua.android.braille.module.exercises.ExercisesActivity;

public class PhraseExercisesActivity extends ExercisesActivity {

    @Override
    public int getContentView() {
        return R.layout.activity_phrase_exercises;
    }

    @Override
    public void setWordType() {
        wordLabel.setText(R.string.phrase);
        resultExercise.setWordType(ResultExercise.PHRASE_TYPE);
    }

    @Override
    public void loadWordsList() {
        WordsDaoInterface phrasesDao = ((BrailleApplication) getApplicationContext()).getWordsDao(DaosContainer.PHRASES_DAO_TYPE);
        wordsList = phrasesDao.readRandom(maxSize);
    }
}
