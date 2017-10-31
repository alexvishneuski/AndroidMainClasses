package com.github.alexvishneuski.androidmainclasses.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.alexvishneuski.androidmainclasses.R;
import com.github.alexvishneuski.androidmainclasses.activities.WithFragmentsLoginActivity;


/**
 * Created by Asus on 30.10.2017.
 */

public class LoginFragment extends Fragment {
    private int remindPasswordPanelFrameContainer = R.id.remind_password_panel_frame_container;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, null);
        view.findViewById(R.id.show_remind_password_panel_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((WithFragmentsLoginActivity)getActivity()).showFragmentWithAdd(remindPasswordPanelFrameContainer, new RemindPasswordFragment());
            }
        });

        return view;


    }





}