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
package com.comoelagua.android.braille.model.beans.actions;

import java.util.ArrayList;
import java.util.List;

public class WordCompare {

    protected List<Integer> positionsErrorsList;
    protected List<String> charactersErrorsList;

    public WordCompare() {
    }

    public List<Integer> getPositionsErrorsList() {
        return positionsErrorsList;
    }

    public List<String> getCharactersErrorsList() {
        return charactersErrorsList;
    }

    public boolean checkEquals(String ask, String answer) {
        positionsErrorsList = new ArrayList<>();
        charactersErrorsList = new ArrayList<>();

        String answerLower = answer.toLowerCase();
        if (ask.equals(answerLower)) {
            return true;
        }

        for(int i = 0; i < answerLower.length(); i++) {
            if (i < ask.length() && answerLower.charAt(i) != ask.charAt(i)) {
                positionsErrorsList.add(new Integer(i));
                charactersErrorsList.add(ask.substring(i, 1 + i));
            } else if(i >= ask.length()) {
                positionsErrorsList.add(new Integer(i));
                charactersErrorsList.add(answerLower.substring(i, 1 + i));
            }
        }

        return false;
    }
}
