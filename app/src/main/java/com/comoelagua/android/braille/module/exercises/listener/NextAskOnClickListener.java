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
package com.comoelagua.android.braille.module.exercises.listener;

import android.view.View;

import com.comoelagua.android.braille.module.exercises.ExercisesActivity;

public class NextAskOnClickListener implements View.OnClickListener {

    protected ExercisesActivity activity;

    public NextAskOnClickListener(ExercisesActivity activity) {
        this.activity = activity;
    }

    @Override
    public void onClick(View v) {
        activity.nextAsk();
    }
}
