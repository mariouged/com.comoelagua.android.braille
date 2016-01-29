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

import com.comoelagua.android.braille.model.daos.PhrasesDao;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class PhrasesDaoTest extends InstrumentationTestCase {

    private PhrasesDao phrasesDao;

    @Before
    public void setUp() {
        Resources res = getInstrumentation().getTargetContext().getResources();
        phrasesDao = new PhrasesDao(res);
    }

    @Test
    public void testReadAll() {
        ArrayList phrasesList = phrasesDao.readAll();
        org.junit.Assert.assertTrue("word list > 0", phrasesList.size() > 0);
        org.junit.Assert.assertNotNull( phrasesList.get(0) );
    }
}
