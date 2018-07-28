package com.hb.moodtool.ui.information.guide.acceptance_commitment;

import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hb.moodtool.R;

import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class AcceptanceCommitmentFragment extends Fragment {
    Unbinder unbinder;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_acceptance_commitment, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.llOverview)
    void clickOverview(){
        Fragment fragment = new OverviewAcceptCommitFragment();
        if (getView()!=null) {
            openFragment(fragment,
                    getView().findViewById(R.id.tvOverview),
                    getView().findViewById(R.id.ivArrowOverview),
                    getView().findViewById(R.id.lineOverview));
        } else {
            openFragment(fragment);
        }
    }

    @OnClick(R.id.llContactPresent)
    void clickContactThePresent(){
        Fragment fragment = new ContactPresentFragment();
        if (getView()!=null) {
            openFragment(fragment,
                    getView().findViewById(R.id.tvOverview),
                    getView().findViewById(R.id.ivArrowOverview),
                    getView().findViewById(R.id.lineOverview));
        } else {
            openFragment(fragment);
        }
    }

    @OnClick(R.id.llDefusion)
    void clickDefusion(){
        Fragment fragment = new DefusionFragment();
        if (getView()!=null) {
            openFragment(fragment,
                    getView().findViewById(R.id.tvDefusion),
                    getView().findViewById(R.id.ivArrowDefusion),
                    getView().findViewById(R.id.lineDefusion));
        } else {
            openFragment(fragment);
        }
    }

    @OnClick(R.id.llAcceptance)
    void clickAcceptance(){
        Fragment fragment = new AcceptanceFragment();
        if (getView()!=null) {
            openFragment(fragment,
                    getView().findViewById(R.id.tvAcceptance),
                    getView().findViewById(R.id.ivArrowAcceptance),
                    getView().findViewById(R.id.lineAcceptance));
        } else {
            openFragment(fragment);
        }
    }

    @OnClick(R.id.llObservingSelf)
    void clickObservingTheSelf(){
        Fragment fragment = new ObservingFragment();
        if (getView()!=null) {
            openFragment(fragment,
                    getView().findViewById(R.id.tvObservingSelf),
                    getView().findViewById(R.id.ivArrowObservingSelf),
                    getView().findViewById(R.id.lineObservingSelf));
        } else {
            openFragment(fragment);
        }
    }

    @OnClick(R.id.llValues)
    void clickValues(){
        Fragment fragment = new ValuesAcceptCommitFragment();
        if (getView()!=null) {
            openFragment(fragment,
                    getView().findViewById(R.id.tvValues),
                    getView().findViewById(R.id.ivArrowValues),
                    getView().findViewById(R.id.lineValues));
        } else {
            openFragment(fragment);
        }
    }

    @OnClick(R.id.llCommittedAction)
    void clickCommittedAction(){
        Fragment fragment = new CommittedActionFragment();
        if (getView()!=null) {
            openFragment(fragment,
                    getView().findViewById(R.id.tvCommittedAction),
                    getView().findViewById(R.id.ivArrowCommittedAction),
                    getView().findViewById(R.id.lineCommittedAction));
        } else {
            openFragment(fragment);
        }
    }

    @OnClick(R.id.llResource)
    void clickResource(){
        Fragment fragment = new ResourcesAcceptCommitFragment();
        if (getView()!=null) {
            openFragment(fragment,
                    getView().findViewById(R.id.tvResource),
                    getView().findViewById(R.id.ivArrowResource),
                    getView().findViewById(R.id.lineResource));
        } else {
            openFragment(fragment);
        }
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

    private void openFragment(Fragment fragment) {
        if (getActivity() != null && getActivity().getSupportFragmentManager() != null) {
            FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.content, fragment)
                    .addToBackStack(null)
                    .commit();
        }
    }

}
