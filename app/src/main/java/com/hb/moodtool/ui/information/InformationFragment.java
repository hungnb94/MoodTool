package com.hb.moodtool.ui.information;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hb.moodtool.R;
import com.hb.moodtool.adapter.InformationPagerAdapter;

import java.util.Objects;


public class InformationFragment extends Fragment {

    public InformationFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View itemView = inflater.inflate(R.layout.fragment_information, container, false);
        ViewPager viewPager = itemView.findViewById(R.id.viewPager);

        InformationPagerAdapter adapter = new InformationPagerAdapter(getContext(),
                Objects.requireNonNull(getActivity()).getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        viewPager.setPageTransformer(true, new InformationPagerAdapter.ZoomOutPageTransformer());

        TabLayout tabLayout = itemView.findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(viewPager);

        return itemView;
    }

}
