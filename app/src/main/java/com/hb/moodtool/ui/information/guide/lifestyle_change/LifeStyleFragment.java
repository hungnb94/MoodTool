package com.hb.moodtool.ui.information.guide.lifestyle_change;

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

public class LifeStyleFragment extends Fragment {
    private Unbinder unbinder;

//    private static final int SHOW_ALL = 0;
//    private static final int SHOW_SUNLIGHT = 1;
//    private static final int SHOW_SOCIAL_SUPPORT = 2;
//    private static final int SHOW_EXERCISE = 3;

//    private int nShowState = 0;

    //Sunlight
    @BindView(R.id.tvSunlight)
    TextView tvSunlight;
    @BindView(R.id.ivArrowSunlight)
    ImageView ivArrowSunlight;
    @BindView(R.id.lineSunlight)
    View lineSunlight;

    //Social support
    @BindView(R.id.tvSocialSupport)
    TextView tvSocialSupport;
    @BindView(R.id.ivArrowSocialSupport)
    ImageView ivArrowSocialSupport;
    @BindView(R.id.lineSocialSupport)
    View lineSocialSupport;

    //Exercise
    @BindView(R.id.tvExercise)
    TextView tvExercise;
    @BindView(R.id.ivArrowExercise)
    ImageView ivArrowExercise;
    @BindView(R.id.lineExercise)
    View lineExercise;

    //Nutrition
    @BindView(R.id.tvNutrition)
    TextView tvNutrition;
    @BindView(R.id.ivArrowNutrition)
    ImageView ivArrowNutrition;
    @BindView(R.id.lineNutrition)
    View lineNutrition;

    //Sleep
    @BindView(R.id.tvSleep)
    TextView tvSleep;
    @BindView(R.id.ivArrowSleep)
    ImageView ivArrowSleep;
    @BindView(R.id.lineSleep)
    View lineSleep;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_life_style, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.llSunlight)
    void clickSunlight() {
        openFragment(new SunlightFragment(), tvSunlight, ivArrowSunlight, lineSunlight);
    }

    @OnClick(R.id.llSocialSupport)
    void clickSocialSupport() {
        openFragment(new SocialSupportFragment(), tvSocialSupport, ivArrowSocialSupport, lineSocialSupport);
    }

    @OnClick(R.id.llExercise)
    void clickExercise() {
        openFragment(new ExerciseFragment(), tvExercise, ivArrowExercise, lineExercise);
    }

    @OnClick(R.id.llNutrition)
    void clickNutrition() {
        openFragment(new NutritionFragment(), tvNutrition, ivArrowNutrition, lineNutrition);
    }

    @OnClick(R.id.llSleep)
    void clickSleep() {
        openFragment(new SleepFragment(), tvSleep, ivArrowSleep, lineSleep);
    }

    private void openFragment(Fragment fragment, View... shareElements) {
        if (getActivity() != null && getActivity().getSupportFragmentManager() != null) {
            FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();

            //Add shared element
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                for (View view : shareElements) {
                    ft.addSharedElement(view, ViewCompat.getTransitionName(view));
                }
            }

            ft.replace(R.id.content, fragment)
                    .addToBackStack(null)
                    .commit();
        }
    }

}
