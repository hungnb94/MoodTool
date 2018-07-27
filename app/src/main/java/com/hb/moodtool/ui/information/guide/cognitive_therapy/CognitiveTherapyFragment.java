package com.hb.moodtool.ui.information.guide.cognitive_therapy;

import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.hb.moodtool.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class CognitiveTherapyFragment extends Fragment {
    Unbinder unbinder;

    //Cognitive therapy
    @BindView(R.id.tvCognitiveTherapy)
    TextView tvCognitiveTherapy;
    @BindView(R.id.ivArrowCognitiveTherapy)
    ImageView ivArrowCognitiveTherapy;
    @BindView(R.id.lineCognitiveTherapy)
    View lineCognitiveTherapy;

    //Challenge thoughts
    @BindView(R.id.tvChallengeThoughts)
    TextView tvChallengeThoughts;
    @BindView(R.id.ivArrowChallengeThoughts)
    ImageView ivArrowChallengeThoughts;
    @BindView(R.id.lineChallengeThoughts)
    View lineChallengeThoughts;

    //Cognitive therapy
    @BindView(R.id.tvCognitiveDistortions)
    TextView tvCognitiveDistortions;
    @BindView(R.id.ivArrowCognitiveDistortions)
    ImageView ivArrowCognitiveDistortions;
    @BindView(R.id.lineCognitiveDistortions)
    View lineCognitiveDistortions;

    //Cognitive therapy
    @BindView(R.id.tvThoughtDiary)
    TextView tvThoughtDiary;
    @BindView(R.id.ivArrowThoughtDiary)
    ImageView ivArrowThoughtDiary;
    @BindView(R.id.lineThoughtDiary)
    View lineThoughtDiary;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_cognitive_therapy, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.llCognitiveTherapy)
    void clickCognitiveTherapy() {
        openFragment(new CognitiveTheoryFragment(), tvCognitiveTherapy, ivArrowCognitiveTherapy, lineCognitiveTherapy);
    }

    @OnClick(R.id.llChallengeThoughts)
    void clickChallengeThoughts() {
        openFragment(new ChallengeThoughtsFragment(), tvChallengeThoughts, ivArrowChallengeThoughts, lineChallengeThoughts);
    }

    @OnClick(R.id.llCognitiveDistortions)
    void clickCognitiveDistortions() {
        openFragment(new CognitiveDistortionsFragment(), tvCognitiveDistortions, ivArrowCognitiveDistortions, lineCognitiveDistortions);
    }

    @OnClick(R.id.llThoughtDiary)
    void clickThoughtDiary() {
        openFragment(new ThoughtDiaryGuideFragment(), tvThoughtDiary, ivArrowThoughtDiary, lineThoughtDiary);
    }

    private void openFragment(Fragment fragment, View... sharedElements) {
        if (getActivity() != null && getActivity().getSupportFragmentManager() != null) {
            FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                for (View view : sharedElements) {
                    ft.addSharedElement(view, ViewCompat.getTransitionName(view));
                }
            }

            ft.replace(R.id.content, fragment)
                    .addToBackStack(null)
                    .commit();
        }
    }

}
