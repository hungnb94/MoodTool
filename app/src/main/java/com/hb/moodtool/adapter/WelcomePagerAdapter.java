package com.hb.moodtool.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.hb.moodtool.R;
import com.hb.moodtool.ui.welcome.WelcomeFragment;

import java.util.ArrayList;
import java.util.List;

public class WelcomePagerAdapter extends FragmentStatePagerAdapter {
    private Context context;
    private List<Fragment> fragments;

    public WelcomePagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        this.context = context;
        init();
    }

    private void init() {
        fragments = new ArrayList<>();
        fragments.add(new WelcomeFragment()
                .init(R.drawable.withinacircle,
                        context.getString(R.string.welcome_to),
                        context.getString(R.string.this_app_provide),
                        context.getString(R.string.swipe_guide)));
        fragments.add(new WelcomeFragment()
                .init(R.drawable.largei,
                        context.getString(R.string.information),
                        context.getString(R.string.information_guide)));
        fragments.add(new WelcomeFragment()
                .init(R.drawable.largedepressiontest,
                        context.getString(R.string.test),
                        context.getString(R.string.test_guide)));
        fragments.add(new WelcomeFragment()
                .init(R.drawable.largevids,
                        context.getString(R.string.videos),
                        context.getString(R.string.videos_guide)));
        fragments.add(new WelcomeFragment()
                .init(R.drawable.largenotebook,
                        context.getString(R.string.thought_diary),
                        context.getString(R.string.thought_diary_guide)));
        fragments.add(new WelcomeFragment()
                .init(R.drawable.jumplarge,
                        context.getString(R.string.activities),
                        context.getString(R.string.activities_guide)));
        fragments.add(new WelcomeFragment()
                .init(R.drawable.largecross,
                        context.getString(R.string.safety_plan),
                        context.getString(R.string.safety_plan_guide)));
    }

    @Override
    public int getCount() {
        return fragments.size();
    }


    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }
}
