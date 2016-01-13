package com.comoelagua.android.braille;

import android.content.res.AssetManager;
import android.test.ActivityInstrumentationTestCase2;

import java.io.IOException;

public class ExercisesActivityTest extends ActivityInstrumentationTestCase2<ExercisesActivity> {

    private ExercisesActivity exercisesActivity;

    public ExercisesActivityTest() {
        super(ExercisesActivity.class);
    }

    @Override
    public void setUp() throws Exception {
        super.setUp();
        exercisesActivity = getActivity();
    }

    public void testAssets() {
        AssetManager assetManager = exercisesActivity.getAssets();
        try {
            System.out.println(assetManager.list(""));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
