package com.github.alexvishneuski.androidmainclasses.activities;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.github.alexvishneuski.androidmainclasses.R;
import com.github.alexvishneuski.androidmainclasses.fragments.LoginFragment;

public class WithFragmentsLoginActivity extends AppCompatActivity {

    public final String TAG = this.getClass().getSimpleName();

    //for log in
    private View mShowLoginPanelButton;
    //private View mShowRemindPasswordPanelButton;
    private int loginPanelFrameContainer = R.id.login_panel_frame_container;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_with_fragments);
        Log.d(TAG, "onCreate");
        initView();
    }

    private void initView() {

        //views search
        mShowLoginPanelButton = (Button) findViewById(R.id.show_login_panel_button);
      //  mShowRemindPasswordPanelButton = (Button) findViewById(R.id.show_remind_password_panel_button);

        initActions();
    }

    private void initActions() {
        //views setting
        mShowLoginPanelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showFragment(loginPanelFrameContainer, new LoginFragment());
            }
        });
    }


    public void showFragment(int frameContainer, Fragment fragment) {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(frameContainer, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    public void hideFragment(Fragment fragment) {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.hide(fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume");

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
    }


}
