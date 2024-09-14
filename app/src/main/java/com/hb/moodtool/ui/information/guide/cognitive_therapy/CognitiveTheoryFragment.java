package com.hb.moodtool.ui.information.guide.cognitive_therapy;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.hb.moodtool.R;
import com.hb.moodtool.utils.MyTextViewUtils;

import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class CognitiveTheoryFragment extends Fragment {
    Unbinder unbinder;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_cognitive_theory, container, false);
        unbinder = ButterKnife.bind(this, view);

        TextView tvLink = view.findViewById(R.id.tvLink);
        MyTextViewUtils.setLink(tvLink);

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.llCognitiveTherapy)
    void clickBack(){
        if (getActivity()!=null && getActivity().getSupportFragmentManager()!=null){
            getActivity().getSupportFragmentManager().popBackStack();
        }
    }

}
