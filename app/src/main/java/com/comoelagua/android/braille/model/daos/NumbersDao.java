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
package com.comoelagua.android.braille.model.daos;

import android.content.res.Resources;

import com.comoelagua.android.braille.R;
import com.comoelagua.android.braille.model.beans.Number;
import com.comoelagua.android.braille.model.beans.interfaces.WordInterface;

import java.util.ArrayList;
import java.util.Hashtable;

public class NumbersDao extends WordsDao {

    public NumbersDao(Resources res) { super(res); }

    public String[] getStringArray() {
        return res.getStringArray(R.array.numbers);
    }

    public ArrayList<WordInterface> readAll() {
        if (wordsListAll != null) {
            return wordsListAll;
        }
        ArrayList wordsListAll = new ArrayList<>();
        String[] numbersBraille = res.getStringArray(R.array.numbersBraille);
        String[] wordsArray = getStringArray();
        for (int i = 0; i < wordsArray.length; i++) {
            WordInterface word = new Number();
            word.setId(1 + i).setWord(wordsArray[i])
                    .setWordToView(numbersBraille[i]);
            wordsListAll.add( word );
        }

        return wordsListAll;
    }

    public String numberToBraille(String s) {
        String[] numbersBraille = res.getStringArray(R.array.numbersBraille);
        String[] wordsArray = getStringArray();
        for (int i = 0; i < wordsArray.length; i++) {
            String numberStr = wordsArray[i];
            if (s.equals(numberStr)) {
                return numbersBraille[i];
            }
        }
        return s; // error
    }

    public Hashtable<String, String> getHashConverter() {
        Hashtable<String, String> hashConverter
                = new Hashtable<String, String>();
        hashConverter.put("1", "#a");
        hashConverter.put("2", "#b");
        hashConverter.put("3", "#c");
        hashConverter.put("4", "#d");
        hashConverter.put("5", "#e");
        hashConverter.put("6", "#f");
        hashConverter.put("7", "#g");
        hashConverter.put("8", "#h");
        hashConverter.put("9", "#i");
        hashConverter.put("0", "#j");
        return hashConverter;
    }
}
