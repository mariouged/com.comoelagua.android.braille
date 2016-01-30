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

import android.util.Log;

import com.comoelagua.android.braille.model.beans.actions.WordCompare;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;


public class WordCompareTest {

    @Test
    public void testCheckEquals() {
        WordCompare wordCompare = new WordCompare();
        String ask = "hello";
        String answer = "hello";
        boolean equals = wordCompare.checkEquals(ask, answer);
        assertTrue("words equals", equals);
        assertTrue("positions is empty ", wordCompare.getPositionsErrorsList().size() == 0);
        assertTrue("characters is empty ", wordCompare.getCharactersErrorsList().size() == 0);
    }

    @Test
    public void testCheckNotEquals() {
        WordCompare wordCompare = new WordCompare();
        String ask = "hello";
        String answer = "word";
        boolean equals = wordCompare.checkEquals(ask, answer);
        assertFalse("words equals", equals);

        List<Integer> positionsErrorsList = wordCompare.getPositionsErrorsList();
        assertTrue("positions has items", positionsErrorsList.size() > 0);

        List<String> charactersErrorsList = wordCompare.getCharactersErrorsList();
        assertTrue("characters has items", charactersErrorsList.size() > 0);

        for (int i = 0; i < positionsErrorsList.size(); i++) {
            assertEquals("error on position " + i, i, positionsErrorsList.get(i).intValue());
        }

        for (int i = 0; i < charactersErrorsList.size(); i++) {
            assertEquals("error on character " + i, ask.substring(i, 1 + i), charactersErrorsList.get(i));
        }

    }

}
