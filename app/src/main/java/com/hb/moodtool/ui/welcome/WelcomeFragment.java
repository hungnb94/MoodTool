package com.hb.moodtool.ui.welcome;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.hb.moodtool.R;

import butterknife.ButterKnife;

public class WelcomeFragment extends Fragment {
    private static final String TAG = WelcomeFragment.class.getSimpleName();
    ImageView imageView;
    TextView tvTitle;
    TextView tvDescription;
    TextView tvGuide;
    int imageId;
    String title;
    String description;
    String guide;

    public WelcomeFragment() {
    }

    public WelcomeFragment init(int imageId, String title, String description, String guide) {
        this.imageId = imageId;
        this.title = title;
        this.description = description;
        this.guide = guide;
        return this;
    }

    public WelcomeFragment init(int imageId, String title, String description) {
        this.imageId = imageId;
        this.title = title;
        this.description = description;
        this.guide = "";
        return this;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        if (bundle != null) {
//            imageId = bundle.getInt(Constants.ARG_IMAGE_ID_WELCOME_FR);
//            title = bundle.getString(Constants.ARG_TITLE_WELCOME_FR);
//            description = bundle.getString(Constants.ARG_DESCRIBLE_WELCOME_FR);
//            guide = bundle.getString(Constants.ARG_GUIDE_WELCOME_FR, "");
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_welcome, container, false);
        imageView = view.findViewById(R.id.imageView);
        tvTitle = view.findViewById(R.id.tvTitle);
        tvDescription = view.findViewById(R.id.tvDescription);
        tvGuide = view.findViewById(R.id.tvGuide);
        ButterKnife.bind(this, view);
        imageView.setImageDrawable(ContextCompat.getDrawable(getContext(), imageId));
        tvTitle.setText(title);
        tvDescription.setText(description);
        tvGuide.setText(guide);
        return view;
    }
}
