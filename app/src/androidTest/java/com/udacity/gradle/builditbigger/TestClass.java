package com.udacity.gradle.builditbigger;


import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.*;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent;


import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;



import static org.junit.Assert.assertTrue;

@RunWith(AndroidJUnit4.class)
public class TestClass {
    @Rule
    public ActivityTestRule<MainActivity> activityActivityTestRule = new ActivityTestRule<MainActivity>(MainActivity.class);

    @Test
    public void testSomething(){
        try {
            onView(withId(R.id.tellJokeButton)).perform(click());

            Thread.sleep(8000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        assertTrue(MainActivity.isNotEmpty[0]);

    }

/*


    @Test
    public void testDoInBackground(){
        final boolean[] oneBoolean=new boolean[1];

        new MyAsyncTask(new FinishedInterface() {
            @Override
            public void onFinished(String result) {
                oneBoolean[0]=(!TextUtils.isEmpty(result));
            }
        }).execute();
        try {
            Thread.sleep(8000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertTrue("MyError-----", oneBoolean[0]);

    }*/
}
