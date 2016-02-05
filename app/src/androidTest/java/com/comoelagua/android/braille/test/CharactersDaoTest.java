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
package com.comoelagua.android.braille.test;

import android.content.res.Resources;
import android.test.InstrumentationTestCase;
import android.util.Log;

import com.comoelagua.android.braille.model.beans.Word;
import com.comoelagua.android.braille.model.daos.containers.DaosContainer;
import com.comoelagua.android.braille.model.daos.interfaces.WordsDaoInterface;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class CharactersDaoTest  extends InstrumentationTestCase {

    private WordsDaoInterface charactersDao;

    @Before
    public void setUp() {
        Resources res = getInstrumentation().getTargetContext().getResources();
        DaosContainer daosContainer = new DaosContainer(res);
        charactersDao = daosContainer.getWordsDao(DaosContainer.CHARACTERS_DAO_TYPE);
    }

    @Test
    public void testReadRandom() {
        int length = 10;
        ArrayList charactersList = charactersDao.readRandom(length);
        org.junit.Assert.assertTrue("list size == " + length, charactersList.size() == length);
        org.junit.Assert.assertNotNull(charactersList.get(9));
    }

    @Test
    public void testDuplicates() {
        boolean hasDuplicates = false;
        ArrayList charactersList = charactersDao.readRandom(10);
        for (int i = 0; i < charactersList.size(); i++) {
            Word word = (Word) charactersList.get(i);
            Log.d("character " + i + " ", word.getWord());
            for (int j = 0; j < charactersList.size(); j++) {
                if (j == i) continue;

                Word wordCompare = (Word) charactersList.get(j);
                if (word.getWord().equals( wordCompare.getWord() )) {
                    Log.d("duplicate ", wordCompare.getWord());
                }
            }
        }
        assertFalse("no has duplicates", hasDuplicates);
    }
}