package com.hb.moodtool.ui.setting;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.hb.moodtool.R;
import com.hb.moodtool.ui.about.AboutActivity;
import com.hb.moodtool.utils.Constants;

import java.util.Objects;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class SettingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        initView();
    }

    private void initView() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setTitle(R.string.setting);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ButterKnife.bind(this);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @OnClick(R.id.llShare)
    void clickShare() {
        String body = "http://market.android.com/details?id=" + getPackageName();

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, body);

        startActivity(Intent.createChooser(intent, getString(R.string.share)));
    }

    @OnClick(R.id.llFacebook)
    void clickFacebook() {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(Constants.FACEBOOK_URL));
        startActivity(browserIntent);
    }

    @OnClick(R.id.llTwitter)
    void clickTwitter() {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(Constants.TWITTER_URL));
        startActivity(browserIntent);
    }

    @OnClick(R.id.llContactUs)
    void clickContactUs() {
        Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);
        emailIntent.setType("plain/text");
        emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL, new String[]{"moodtools@moodtools.com"});
        emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "");
        emailIntent.putExtra(android.content.Intent.EXTRA_TEXT, "");

        /* Send it off to the Activity-Chooser */
        startActivity(Intent.createChooser(emailIntent, getResources().getString(R.string.send_mail)));
    }

    @OnClick(R.id.llWebpage)
    void clickWebpage() {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(Constants.WEBPAGE_URL));
        startActivity(browserIntent);
    }

    @OnClick(R.id.llAbout)
    void clickAbout() {
        Intent intent = new Intent(this, AboutActivity.class);
        startActivity(intent);
    }
}
