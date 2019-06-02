package com.udacity.gradle.builditbigger;


import android.text.TextUtils;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;


import static org.junit.Assert.assertTrue;

@RunWith(JUnit4.class)
public class MyTestCase {

    @Test
    public void testDoInBackground2() {
        final boolean[] oneBoolean = new boolean[1];

        new MyAsyncTask(new FinishedInterface() {
            @Override
            public void onFinished(String result) {
                oneBoolean[0] = (!TextUtils.isEmpty(result));
            }
        }).execute();
        try {
            Thread.sleep(8000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertTrue("MyError-----", oneBoolean[0]);
    }
}
