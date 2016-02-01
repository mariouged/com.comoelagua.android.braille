/**
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License.
 * <p>
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * <p>
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 * <p>
 * Contact: <mario.ugedo@gmail.com>
 */
package com.comoelagua.android.braille.test;

import android.content.res.Resources;
import android.test.InstrumentationTestCase;

import com.comoelagua.android.braille.model.daos.containers.DaosContainer;
import com.comoelagua.android.braille.model.daos.interfaces.WordsDaoInterface;

import org.junit.Before;
import org.junit.Test;

public class DaosContainerTest extends InstrumentationTestCase {

    private Resources res;

    @Before
    public void setUp() {
        res = getInstrumentation().getTargetContext().getResources();
    }

    @Test
    public void testGetWordsDaos() {
        DaosContainer daosContainer = new DaosContainer(res);
        WordsDaoInterface wordDao = daosContainer.getWordsDao(DaosContainer.WORDS_DAO_TYPE);
        assertNotNull(wordDao);

        WordsDaoInterface wordDaoSecondFactory = daosContainer.getWordsDao(DaosContainer.WORDS_DAO_TYPE);
        assertEquals("its same dao", wordDao, wordDaoSecondFactory);
    }
}
