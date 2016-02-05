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
package com.comoelagua.android.braille.test;

import com.comoelagua.android.braille.model.beans.ResultExercise;

import org.junit.Test;
import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import java.util.List;

public class ResultExerciseTest {

    @Test
    public void addAllcharactersErrorsListTest() {
        List<String> charactersErrorOne = new ArrayList<>();
        charactersErrorOne.add("a");
        charactersErrorOne.add("b");
        charactersErrorOne.add("a");

        ResultExercise resultExercise = new ResultExercise();
        resultExercise.addAllcharactersErrorsList(charactersErrorOne);
        assertTrue("charactersErrorsList size = 2", resultExercise.getCharactersErrorsList().size() == 2);

        List<String> charactersErrorTwo = new ArrayList<>();
        charactersErrorTwo.add("a");
        charactersErrorTwo.add("b");
        charactersErrorTwo.add("c");
        resultExercise.addAllcharactersErrorsList(charactersErrorTwo);
        assertTrue("charactersErrorsList size = 3", resultExercise.getCharactersErrorsList().size() == 3);
    }
}
