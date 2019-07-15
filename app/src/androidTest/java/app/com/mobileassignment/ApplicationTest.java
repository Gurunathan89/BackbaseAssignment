package app.com.mobileassignment;

import android.app.Activity;
import android.view.View;
import android.widget.ListView;

import org.junit.Rule;
import org.junit.Test;
import org.junit.Before;
import org.junit.runner.RunWith;

import android.content.Context;

import androidx.test.InstrumentationRegistry;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import java.lang.String;

import app.com.mobileassignment.views.MainActivity;

import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.clearText;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.swipeUp;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.hasMinimumChildCount;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.core.StringContains.containsString;

import androidx.test.rule.ActivityTestRule;

import android.widget.TextView;

import static org.junit.Assert.assertTrue;


@RunWith(AndroidJUnit4.class)
@LargeTest
public class ApplicationTest {


    @Rule
    public ActivityTestRule<MainActivity> mainActivityTest = new ActivityTestRule<>(
            MainActivity.class);

    @Test

    public void searchCity() {
        onView(withId(R.id.search))
                .perform(typeText("Paris"), closeSoftKeyboard());
        onView(withId(R.id.search)).perform(click());



        ListView list = (ListView) mainActivityTest.getActivity().findViewById(R.id.citiesList);
        int k = list.getChildCount();

        for (int i = 0; i < k; i++) {
            View view = list.getChildAt(i);
            TextView textView = view.findViewById(R.id.cityName);
            String search = textView.getText().toString().toLowerCase();
            assertTrue(search.toLowerCase().contains("Paris".toLowerCase()));
        }
    }


}
