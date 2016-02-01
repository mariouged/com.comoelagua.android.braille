/**
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License.
 * <p/>
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * <p/>
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 * <p/>
 * Contact: <mario.ugedo@gmail.com>
 */
package com.comoelagua.android.braille;

import com.comoelagua.android.braille.model.daos.containers.DaosContainer;
import com.comoelagua.android.braille.model.daos.interfaces.WordsDaoInterface;
import com.comoelagua.android.braille.module.exercises.ExercisesActivity;

public class CharactersExercisesActivity extends ExercisesActivity {

    @Override
    public void setWordType() {
        wordType =  "character";
        wordLabel.setText(R.string.character);
        resultExercise.setWordType("character");
    }

    @Override
    public void loadWordsList() {
        WordsDaoInterface charactersDao = ((BrailleApplication) getApplicationContext()).getWordsDao(DaosContainer.PHRASES_DAO_TYPE);
        wordsList = charactersDao.readRandom(maxSize);
    }
}