package com.comoelagua.android.braille;

import junit.framework.TestSuite;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.internal.builders.AllDefaultPossibilitiesBuilder;
import org.junit.runner.RunWith;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.runner.AndroidJUnitRunner;
import android.test.ActivityInstrumentationTestCase2;
import android.test.suitebuilder.annotation.LargeTest;
import android.widget.TextView;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.assertThat;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class WordExercisesActivityTest {

    @Rule
    public ActivityTestRule<WordExercisesActivity> mActivityRule = new ActivityTestRule<>(
            WordExercisesActivity.class);

    @Test
    public void testSetAnswerOK() {
        String word = ((TextView) mActivityRule.getActivity().findViewById(R.id.ask)).getText().toString();
        onView(withId(R.id.answer)).perform(typeText(word), closeSoftKeyboard());
        onView(withId(R.id.next)).perform(click());
        // OK if askNumber after click is 2
        onView(withId(R.id.askNumber))
                .check(matches(withText(" 2")));
    }

    @Test
    public void testSetAnswerFAIL() {
        onView(withId(R.id.answer)).perform(typeText("anything mock"), closeSoftKeyboard());
        onView(withId(R.id.next)).perform(click());
        // OK if askNumber after click is 1
        onView(withId(R.id.askNumber))
                .check(matches(withText(" 1")));
    }
}
