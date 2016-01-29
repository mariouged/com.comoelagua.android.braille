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

import android.support.test.espresso.Espresso;
import android.support.test.espresso.ViewAction;
import android.support.test.espresso.action.ViewActions;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;
import android.widget.Button;
import android.widget.TextView;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class PhraseExercisesActivityTest {

    @Rule
    public ActivityTestRule<PhraseExercisesActivity> activityTestRule = new ActivityTestRule<>(PhraseExercisesActivity.class);

    @Test
    public void testCompletedExercises() {
        PhraseExercisesActivity phraseExercisesActivity = activityTestRule.getActivity();
        TextView askTextView = (TextView) phraseExercisesActivity.findViewById(R.id.ask);
        int maxSize = 10;
        for(int i = 0; i < maxSize; i++) {
            onView(withId(R.id.ask))
                    .perform(closeSoftKeyboard());

            String word = askTextView.getText().toString();
            onView(withId(R.id.answer))
                    .perform(replaceText(word));
                    //.perform(typeText(word), closeSoftKeyboard());

            // test fail when ask is too long, and not show in screen the next button
            onView(withId(R.id.next)).perform(click());

            if (i < maxSize - 1) {
                // last next click start another activity, no has askNumber
                onView(withId(R.id.askNumber))
                        .check(matches(withText(" " + (2 + i))));
            }
        }
        // result activity show answer ok
        onView(withId(R.id.okValue)).check(matches(withText("" + maxSize)));
    }

}
