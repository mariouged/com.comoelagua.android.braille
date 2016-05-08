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

import android.support.test.espresso.Espresso;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;
import com.comoelagua.android.braille.NumbersExercisesActivity;
import com.comoelagua.android.braille.R;

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
public class NumbersExercisesActivityTest {

    @Rule
    public ActivityTestRule<NumbersExercisesActivity> activityTestRule = new ActivityTestRule<>(NumbersExercisesActivity.class);

    @Test
    public void testSetAnswerOK() {
        NumbersExercisesActivity numberExercisesActivity = activityTestRule.getActivity();
        String askStr = numberExercisesActivity.getCurrentWord().getWord();
        onView(withId(R.id.answer)).perform(replaceText(askStr));
        onView(withId(R.id.next)).perform(click());
        // OK if askNumber after click is 2, has changed to next ask
        onView(withId(R.id.askNumber))
                .check(matches(withText(" 2")));
    }

    @Test
    public void testSetAnswerFAIL() {
        onView(withId(R.id.answer)).perform(typeText("anything mock"), closeSoftKeyboard());
        onView(withId(R.id.next)).perform(click());
        // OK if askNumber after click is 1, keep in same ask
        onView(withId(R.id.askNumber))
                .check(matches(withText(" 1")));
    }

    @Test
    public void testCompletedExercises() {
        NumbersExercisesActivity numberExercisesActivity = activityTestRule.getActivity();

        int maxSize = 10;
        for(int i = 0; i < maxSize; i++) {
            onView(withId(R.id.ask))
                    .perform(closeSoftKeyboard());

            String askStr = numberExercisesActivity.getCurrentWord().getWord();
            onView(withId(R.id.answer))
                    .perform(replaceText(askStr));

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
