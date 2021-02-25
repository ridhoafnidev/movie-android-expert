package com.dailyapps.dicodingmoviedbketpackpro

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.rule.ActivityTestRule
import com.dailyapps.dicodingmoviedbketpackpro.utils.DataDummy
import org.junit.Rule
import org.junit.Test

@Suppress("DEPRECATION")
class MainActivityTest {
    private val dummyMovie = DataDummy.generateDummyMovie()
    private val dummyTv = DataDummy.generateDummyTvShow()

    @get:Rule
    var activityRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun loadDataMovie(){
        onView(withId(R.id.recycler_view_movie)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        onView(withId(R.id.recycler_view_movie)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyMovie.size))
    }

    @Test
    fun loadTvShow() {
        onView(withId(R.id.navigation_tv_show)).perform(ViewActions.click())
        onView(withId(R.id.recycler_view_tv)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        onView(withId(R.id.recycler_view_tv)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyTv.size))
    }

    @Test
    fun loadDetailMovie(){
        onView(withId(R.id.recycler_view_movie)).perform(
        RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
            0,
            ViewActions.click()
            )
        )
        onView(withId(R.id.labelTitleDes)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        onView(withId(R.id.labelTitleDes)).check(ViewAssertions.matches(withText(dummyMovie[0].title)))
        onView(withId(R.id.labelRealaseDes)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        onView(withId(R.id.labelRealaseDes)).check(ViewAssertions.matches(withText("Release Date : ${dummyMovie[0].release_date}")))
        onView(withId(R.id.labelVoteDes)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        onView(withId(R.id.labelVoteDes)).check(ViewAssertions.matches(withText("Vote : ${dummyMovie[0].vote_average}")))
        onView(withId(R.id.labelOverviewDes)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        onView(withId(R.id.labelOverviewDes)).check(ViewAssertions.matches(withText(dummyMovie[0].overview)))
    }

    @Test
    fun loadDetailTvShow(){
        onView(withId(R.id.navigation_tv_show)).perform(ViewActions.click())
        onView(withId(R.id.recycler_view_tv)).perform(
        RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
            0,
            ViewActions.click()
            )
        )
        onView(withId(R.id.labelTitleDes)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        onView(withId(R.id.labelTitleDes)).check(ViewAssertions.matches(withText(dummyTv[0].name)))
        onView(withId(R.id.labelRealaseDes)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        onView(withId(R.id.labelRealaseDes)).check(ViewAssertions.matches(withText("Release Date : ${dummyTv[0].first_air_date}")))
        onView(withId(R.id.labelVoteDes)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        onView(withId(R.id.labelVoteDes)).check(ViewAssertions.matches(withText("Vote : ${dummyTv[0].vote_average}")))
        onView(withId(R.id.labelOverviewDes)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        onView(withId(R.id.labelOverviewDes)).check(ViewAssertions.matches(withText(dummyTv[0].overview)))
    }

}