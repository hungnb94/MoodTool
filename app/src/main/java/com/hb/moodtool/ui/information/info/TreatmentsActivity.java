package com.hb.moodtool.ui.information.info;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.hb.moodtool.R;
import com.hb.moodtool.utils.MyTextViewUtils;

import java.util.Objects;

public class TreatmentsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_treatments);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setTitle(R.string.treatments);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        TextView tvLink = findViewById(R.id.tvLink);
        MyTextViewUtils.setLink(tvLink);

        TextView tvLink2 = findViewById(R.id.tvLink2);
        MyTextViewUtils.setLink(tvLink2);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
