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

import android.content.res.Resources;
import android.test.InstrumentationTestCase;

import com.comoelagua.android.braille.model.daos.WordsDao;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class WordsDaoTest extends InstrumentationTestCase {

    private WordsDao wordsDao;

    @Before
    public void setUp() {
        Resources res = getInstrumentation().getTargetContext().getResources();
        wordsDao = new WordsDao(res);
    }

    @Test
    public void testReadAll() {
        ArrayList wordsList = wordsDao.readAll();
        org.junit.Assert.assertTrue("word list > 0", wordsList.size() > 0);
    }

}
