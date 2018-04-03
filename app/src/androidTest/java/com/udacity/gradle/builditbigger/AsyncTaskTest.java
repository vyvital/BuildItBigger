package com.udacity.gradle.builditbigger;

import android.support.test.espresso.Espresso;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.not;

@RunWith(AndroidJUnit4.class)
public class AsyncTaskTest {


    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);


    @Test
    public void asyncTest() throws InterruptedException {
        onView(withId(R.id.joke_btn)).check(matches(isDisplayed()));
        Espresso.registerIdlingResources(mActivityTestRule.getActivity().getIdlingResource());
        onView(withId(R.id.joke_btn)).perform(click());
        onView(withId(R.id.jokeView)).check(matches(not(withText(""))));
        onView(withId(R.id.jokeView)).check(matches(withText("What's the best thing about UDP jokes?" + "\n" +
                "I don't care if you get them")));
    }


}