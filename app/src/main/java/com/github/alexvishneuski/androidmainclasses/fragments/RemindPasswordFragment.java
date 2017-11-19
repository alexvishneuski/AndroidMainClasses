package com.github.alexvishneuski.androidmainclasses.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.alexvishneuski.androidmainclasses.R;
/**
 * Created by Asus on 30.10.2017.
 */

public class RemindPasswordFragment extends Fragment {

    /*creating a RemindPasswordFragment*/
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_remind_password, null);


    }
}

