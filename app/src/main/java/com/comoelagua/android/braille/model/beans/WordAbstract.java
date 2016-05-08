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
package com.comoelagua.android.braille.model.beans;

import com.comoelagua.android.braille.model.beans.interfaces.WordInterface;

abstract public class WordAbstract implements WordInterface {

    protected int id;
    protected String word;

    public WordAbstract() {}

    public WordInterface setId(int id) {
        this.id = id;
        return this;
    }

    public int getId() {
        return id;
    }

    public WordInterface setWord(String word) {
        this.word = word;
        return this;
    }

    public String getWord() {
        return word;
    }

    public WordInterface setWordToView(String wordToView) {
        this.word = wordToView;
        return this;
    }

    public String getWordToView() { return word; }

    public WordInterface setWordToCompare(String wordToCompare) {
        this.word = wordToCompare;
        return this;
    }
    public String getWordToCompare() { return word; }

}
