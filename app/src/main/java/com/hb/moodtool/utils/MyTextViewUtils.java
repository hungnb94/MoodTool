package com.hb.moodtool.utils;

import android.text.method.LinkMovementMethod;
import android.widget.TextView;

public class MyTextViewUtils {

    public static void setLink(TextView textView){
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView.setLinksClickable(true);
    }
}
