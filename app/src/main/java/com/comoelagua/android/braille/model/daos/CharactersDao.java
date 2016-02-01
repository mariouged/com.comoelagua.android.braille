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
package com.comoelagua.android.braille.model.daos;

import android.content.res.Resources;
import com.comoelagua.android.braille.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CharactersDao extends WordsDao {

    public CharactersDao(Resources res) {
        super(res);
    }

    public String[] getStringArray() {
        List<String> retCharacters = new ArrayList<>();
        String[] ignore = {"may.","núm.", "1", "2", "3", "4", "5", "6", "7", "8", "9", "0"};
        List<String> ignoreList = Arrays.asList(ignore);
        String[] characters = res.getStringArray(R.array.characters);
        for (int i = 0; i < characters.length; i++) {
            if (ignoreList.contains( characters[i] )) {
                continue;
            }
            retCharacters.add( characters[i] );
        }
        String[] charactersCleans = retCharacters.toArray(new String[retCharacters.size()]);
        return charactersCleans;
    }

}
