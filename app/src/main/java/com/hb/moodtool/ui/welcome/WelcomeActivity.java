package com.hb.moodtool.ui.welcome;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.hb.moodtool.R;
import com.hb.moodtool.adapter.WelcomePagerAdapter;
import com.hb.moodtool.preference.PreferenceManager;
import com.hb.moodtool.ui.main.MainActivity;
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class WelcomeActivity extends AppCompatActivity implements WelcomeView {
    private WelcomePresenterImpl welcomePresenter;

    private ViewPager viewPager;
    private DotsIndicator dotsIndicator;
    private WelcomePagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        // Checking for first time launch - before calling setContentView()
        PreferenceManager preferenceManager = new PreferenceManager(this);
        welcomePresenter = new WelcomePresenterImpl(preferenceManager);
        if (welcomePresenter.isFistTimeLaunch()) navigateToHome();

        ButterKnife.bind(this);
    }

    @OnClick(R.id.button)
    void clickGetStart(){
        welcomePresenter.markFirstTimeLaunch();
        navigateToHome();
    }

    @Override
    public void showGuideTour() {
        dotsIndicator = findViewById(R.id.dots_indicator);
        viewPager = findViewById(R.id.viewpager);
        adapter = new WelcomePagerAdapter(this, getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        dotsIndicator.setViewPager(viewPager);
    }

    @Override
    public void navigateToHome() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
