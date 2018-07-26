package com.hb.moodtool.ui.welcome;

import com.hb.moodtool.preference.PreferenceManager;

public class WelcomePresenterImpl implements WelcomePresenter {
    private PreferenceManager preferenceManager;

    public WelcomePresenterImpl(PreferenceManager preferenceManager){
        this.preferenceManager = preferenceManager;
    }

    @Override
    public boolean isFistTimeLaunch() {
        return preferenceManager.isFirstTimeLaunch();
    }

    @Override
    public void markFirstTimeLaunch() {
        preferenceManager.setFirstTimeLaunch(false);
    }

}
