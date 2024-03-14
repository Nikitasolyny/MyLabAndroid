package com.example.mylabandroid;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import static org.hamcrest.core.IsNot.not;

import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.rule.ActivityTestRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

public class MainActivityTest {
    @Rule
    public ActivityTestRule<MainActivity> activityActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Before
    public void setUp() {
        activityActivityTestRule.getActivity()
                .getSupportFragmentManager().beginTransaction();
    }

    @Test
    public void testArticleClick(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        onView(ViewMatchers.withId(R.id.recycler_view1)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
        onView(withId(R.id.recycler_view1)).perform(RecyclerViewActions.scrollToPosition(0));
        onView(withId(R.id.recycler_view1)).perform(actionOnItemAtPosition(0, click()));

        onView(withId(R.id.card_view_detail)).check(matches(isDisplayed()));
        onView(withId(R.id.title_text_view)).check(matches(not(withText(""))));
        onView(withId(R.id.news_site_text_view)).check(matches(not(withText(""))));
        onView(withId(R.id.published_at_text_view)).check(matches(not(withText(""))));
        onView(withId(R.id.updated_at_text_view)).check(matches(not(withText(""))));
        onView(withId(R.id.summary_text_view)).check(matches(not(withText(""))));

        onView(isRoot()).perform(ViewActions.pressBack());

        onView(withId(R.id.fragment_container)).check(matches(isDisplayed()));
    }
}