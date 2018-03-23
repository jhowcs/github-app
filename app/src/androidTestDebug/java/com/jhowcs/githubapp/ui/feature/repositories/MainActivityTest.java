package com.jhowcs.githubapp.ui.feature.repositories;

import android.content.Intent;
import android.support.test.espresso.Espresso;
import android.support.test.espresso.intent.rule.IntentsTestRule;
import android.support.test.espresso.matcher.ViewMatchers;

import com.jhowcs.githubapp.R;
import com.jhowcs.githubapp.repository.network.BaseApi;
import com.jhowcs.githubapp.util.RecyclerViewItemCountAssertion;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import br.com.concretesolutions.requestmatcher.InstrumentedTestRequestMatcherRule;
import br.com.concretesolutions.requestmatcher.RequestMatcherRule;
import br.com.concretesolutions.requestmatcher.model.HttpMethod;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivityTest {

    @Rule
    public RequestMatcherRule serverRule = new InstrumentedTestRequestMatcherRule();

    @Rule
    public IntentsTestRule<MainActivity> intentsTestRule =
            new IntentsTestRule<>(MainActivity.class, true, false);

    @Before
    public void setUp() {
        final String urlMockServer = serverRule.url("/").toString();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(urlMockServer)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        BaseApi.switchRetrofitInstanceForTest(retrofit);
    }

    @Test
    public void onLoadActivity_shouldShowTheFirstThirtyAndroidRepositories() throws InterruptedException {
        serverRule.addFixture("first_thirty_android_repositories_response.json")
                .ifRequestMatches()
                .methodIs(HttpMethod.GET);

        intentsTestRule.launchActivity(new Intent());
        Espresso.onView(ViewMatchers.withId(R.id.rvRepositories))
                .check(RecyclerViewItemCountAssertion.withItemCount(30));
    }
}