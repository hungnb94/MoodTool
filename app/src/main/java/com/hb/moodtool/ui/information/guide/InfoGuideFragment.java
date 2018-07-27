package com.hb.moodtool.ui.information.guide;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hb.moodtool.R;
import com.hb.moodtool.ui.information.guide.cognitive_therapy.CognitiveTherapyActivity;
import com.hb.moodtool.ui.information.guide.lifestyle_change.LifestyleChangeActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class InfoGuideFragment extends Fragment {
    Unbinder unbinder;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_info_guide, container, false);
        unbinder = ButterKnife.bind(this, view);

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.llLSChanges)
    void clickLifeStyleChanges(){
        Intent intent = new Intent(getContext(), LifestyleChangeActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.llCBTherapy)
    void clickCognitiveTherapy(){
        Intent intent = new Intent(getContext(), CognitiveTherapyActivity.class);
        startActivity(intent);
    }

}
