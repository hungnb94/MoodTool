package com.hb.moodtool.ui.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.hb.moodtool.R;
import com.hb.moodtool.ui.drawer.DrawerActivity;
import com.hb.moodtool.ui.setting.SettingActivity;
import com.hb.moodtool.utils.Constants;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements MainView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ButterKnife.bind(this);
    }

    @OnClick(R.id.llInformation)
    void clickInformation() {
        openDrawerActivity(Constants.FRAGMENT_INFORMATION);
    }

    @OnClick(R.id.llTest)
    void clickTest() {
        openDrawerActivity(Constants.FRAGMENT_TEST);
    }

    @OnClick(R.id.llVideos)
    void clickVideos() {
        openDrawerActivity(Constants.FRAGMENT_VIDEOS);
    }

    @OnClick(R.id.llThoughtDiary)
    void clickThoughtDiary() {
        openDrawerActivity(Constants.FRAGMENT_THOUGHT_DIARY);
    }

    @OnClick(R.id.llActivities)
    void clickActivities() {
        openDrawerActivity(Constants.FRAGMENT_ACTIVITY);
    }

    @OnClick(R.id.llSafePlan)
    void clickSafePlan() {
        openDrawerActivity(Constants.FRAGMENT_SAFE_PLAN);
    }

    @Override
    public void openDrawerActivity(int fragmentType) {
        if (fragmentType < 0 || fragmentType > 5) fragmentType = 0;

        Intent intent = new Intent(this, DrawerActivity.class);
        intent.putExtra(Constants.FRAGMENT_DRAWER_TYPE, fragmentType);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == R.id.action_setting) {
            clickSetting();
        }
        return true;
    }

    private void clickSetting() {
        Intent intent = new Intent(this, SettingActivity.class);
        startActivity(intent);
    }
}
