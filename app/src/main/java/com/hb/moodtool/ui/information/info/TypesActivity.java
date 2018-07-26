package com.hb.moodtool.ui.information.info;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import com.hb.moodtool.R;
import com.hb.moodtool.utils.MyTextViewUtils;

import java.util.Objects;

public class TypesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_types);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setTitle(R.string.types);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Set link from TextView clickable
        TextView tvLinkSeasonalDisorder = findViewById(R.id.tvLinkSeasonalDisorder);
        MyTextViewUtils.setLink(tvLinkSeasonalDisorder);

        TextView tvLinkPersistentDisorder = findViewById(R.id.tvLinkPersistentDisorder);
        MyTextViewUtils.setLink(tvLinkPersistentDisorder);

        TextView tvLinkBipolarDisorder = findViewById(R.id.tvLinkBipolarDisorder);
        MyTextViewUtils.setLink(tvLinkBipolarDisorder);

        TextView tvLinkPostpartumDepression = findViewById(R.id.tvLinkPostpartumDepression);
        MyTextViewUtils.setLink(tvLinkPostpartumDepression);

        TextView tvLinkAtypicalDepression = findViewById(R.id.tvLinkAtypicalDepression);
        MyTextViewUtils.setLink(tvLinkAtypicalDepression);

        TextView tvLinkPsychoticDepression = findViewById(R.id.tvLinkPsychoticDepression);
        MyTextViewUtils.setLink(tvLinkPsychoticDepression);

        TextView tvLinkDepressionTypes = findViewById(R.id.tvLinkDepressionTypes);
        MyTextViewUtils.setLink(tvLinkDepressionTypes);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

}
