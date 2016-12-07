package com.example.sihuan.tablayoutdemo;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by sihuan on 2016/12/7.
 * com.example.sihuan.tablayoutdemo
 */
public class MyFragment extends Fragment {

    private static final String KEY = "MyFragment";


    public static MyFragment newInstance(String str) {
        Bundle b = new Bundle();
        b.putString(KEY, str);
        MyFragment fragment = new MyFragment();
        fragment.setArguments(b);
        return fragment;
    }

    private String s;

    @SuppressWarnings("deprecation")
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        Bundle b = getArguments();
        s = b.getString(KEY);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        TextView textView = new TextView(getContext());
        textView.setText(s);
        return textView;
    }
}
