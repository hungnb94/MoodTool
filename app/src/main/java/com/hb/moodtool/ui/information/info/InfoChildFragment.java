package com.hb.moodtool.ui.information.info;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hb.moodtool.R;

import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class InfoChildFragment extends Fragment {
    Unbinder unbinder;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View itemView = inflater.inflate(R.layout.fragment_info_child, container, false);
        unbinder = ButterKnife.bind(this, itemView);
        return itemView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.llDepression)
    void clickDepression(){
        Intent intent = new Intent(getContext(), WhatIsDepressionActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.llSymptoms)
    void clickSymptoms(){
        Intent intent = new Intent(getContext(), SymptomsActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.llTypes)
    void clickTypes(){
        Intent intent = new Intent(getContext(), TypesActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.llCauses)
    void clickCauses(){
        Intent intent = new Intent(getContext(), DepressionCausesActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.llTreatments)
    void clickTreatments(){
        Intent intent = new Intent(getContext(), TreatmentsActivity.class);
        startActivity(intent);
    }
}
