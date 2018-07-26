package com.hb.moodtool.ui.drawer;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.hb.moodtool.R;
import com.hb.moodtool.ui.activities.ActivitiesFragment;
import com.hb.moodtool.ui.information.InformationFragment;
import com.hb.moodtool.ui.safety_plan.SafetyPlanFragment;
import com.hb.moodtool.ui.setting.SettingActivity;
import com.hb.moodtool.ui.test.TestFragment;
import com.hb.moodtool.ui.thought_diary.ThoughtDiaryFragment;
import com.hb.moodtool.ui.videos.VideosFragment;
import com.hb.moodtool.utils.Constants;

public class DrawerActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer);

        initView();
    }

    private void initView() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        int fragmentType = getIntent().getIntExtra(Constants.FRAGMENT_DRAWER_TYPE, 0);
        updateFragment(fragmentType);
    }

    private void updateFragment(int fragmentType) {
        switch (fragmentType) {
            case Constants.FRAGMENT_INFORMATION:
                setCheckedMenuItem(R.id.nav_information);
                openFragment(new InformationFragment());
                setTitle(R.string.depression_information);
                break;
            case Constants.FRAGMENT_TEST:
                setCheckedMenuItem(R.id.nav_test);
                openFragment(new TestFragment());
                setTitle(R.string.test);
                break;
            case Constants.FRAGMENT_VIDEOS:
                setCheckedMenuItem(R.id.nav_videos);
                openFragment(new VideosFragment());
                setTitle(R.string.videos);
                break;
            case Constants.FRAGMENT_THOUGHT_DIARY:
                setCheckedMenuItem(R.id.nav_thought_diary);
                openFragment(new ThoughtDiaryFragment());
                setTitle(R.string.thought_diary);
                break;
            case Constants.FRAGMENT_ACTIVITY:
                setCheckedMenuItem(R.id.nav_activities);
                openFragment(new ActivitiesFragment());
                setTitle(R.string.activities);
                break;
            case Constants.FRAGMENT_SAFE_PLAN:
                setCheckedMenuItem(R.id.nav_safety_plan);
                openFragment(new SafetyPlanFragment());
                setTitle(R.string.safety_plan);
                break;
            default:
                break;
        }
    }

    int previousMenuItemId;
    private void setCheckedMenuItem(int menuItemId) {
        previousMenuItemId = menuItemId;
    }

    @Override
    protected void onResume() {
        super.onResume();
        navigationView.setCheckedItem(previousMenuItemId);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            finish();
        } else if (id == R.id.nav_information) {
            openFragment(new InformationFragment());
        } else if (id == R.id.nav_test) {
            openFragment(new TestFragment());
        } else if (id == R.id.nav_videos) {
            openFragment(new VideosFragment());
        } else if (id == R.id.nav_thought_diary) {
            openFragment(new ThoughtDiaryFragment());
        } else if (id == R.id.nav_activities) {
            openFragment(new ActivitiesFragment());
        } else if (id == R.id.nav_safety_plan) {
            openFragment(new SafetyPlanFragment());
        } else if (id == R.id.nav_settings) {
            Intent intent = new Intent(this, SettingActivity.class);
            startActivity(intent);
        }

        if (id != R.id.nav_settings) previousMenuItemId = id;

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    void openFragment(Fragment fragment) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.llContentDrawer, fragment);
        ft.commit();
    }
}
