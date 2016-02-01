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

import android.app.Application;

import com.comoelagua.android.braille.model.daos.containers.DaosContainer;
import com.comoelagua.android.braille.model.daos.interfaces.WordsDaoInterface;

public class BrailleApplication extends Application {

    private DaosContainer daosContainer = null;

    public BrailleApplication() {
        super();
    }

    public WordsDaoInterface getWordsDao(String type) {
        if (daosContainer == null) {
            daosContainer = new DaosContainer(getResources());
        }
        return daosContainer.getWordsDao(type);
    }

}
