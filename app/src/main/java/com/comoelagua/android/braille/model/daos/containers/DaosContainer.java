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
package com.comoelagua.android.braille.model.daos.containers;

import android.content.res.Resources;

import com.comoelagua.android.braille.model.daos.CharactersDao;
import com.comoelagua.android.braille.model.daos.NumbersDao;
import com.comoelagua.android.braille.model.daos.PhrasesDao;
import com.comoelagua.android.braille.model.daos.WordsDao;
import com.comoelagua.android.braille.model.daos.interfaces.WordsDaoInterface;

import java.util.Hashtable;

public class DaosContainer {

    protected Resources res;

    public static final String WORDS_DAO_TYPE = "words";
    public static final String PHRASES_DAO_TYPE = "phrases";
    public static final String CHARACTERS_DAO_TYPE = "characters";
    public static final String NUMBERS_DAO_TYPE = "numbers";

    protected Hashtable<String, WordsDaoInterface> daosHastable;

    public DaosContainer(Resources res) {
        this.res = res;
        daosHastable = new Hashtable<String, WordsDaoInterface>();
    }

    public WordsDaoInterface getWordsDao(String type) {
        if (daosHastable.containsKey(type)) {
            return daosHastable.get(type);
        }

        WordsDaoInterface wordsDaoInterface = factoryWordsDao(type);
        daosHastable.put(type, wordsDaoInterface);
        return wordsDaoInterface;
    }

    protected WordsDaoInterface factoryWordsDao(String type) {
        if (CHARACTERS_DAO_TYPE.equals(type)) {
            return new CharactersDao(res);
        } else if (WORDS_DAO_TYPE.equals(type)) {
            return new WordsDao(res);
        } else if (PHRASES_DAO_TYPE.equals(type)) {
            return new PhrasesDao(res);
        } else if (NUMBERS_DAO_TYPE.equals(type)) {
            return new NumbersDao(res);
        }
        return null;
    }

}
