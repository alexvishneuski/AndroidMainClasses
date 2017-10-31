package com.github.alexvishneuski.androidmainclasses.activities;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.github.alexvishneuski.androidmainclasses.R;
import com.github.alexvishneuski.androidmainclasses.fragments.RemindPasswordFragment;
import com.github.alexvishneuski.androidmainclasses.fragments.LoginFragment;
import com.github.alexvishneuski.androidmainclasses.fragments.PreLoginFragment;

public class WithFragmentsLoginActivity extends AppCompatActivity {

    public final String TAG = this.getClass().getSimpleName();

    //for log in
    //private EditText mInputNameEditText;
    //private EditText mInputPasswordText;
    //private View mLoginButton;
    private View mShowLoginPanelButton;
    private View mShowRemindPasswordPanelButton;
    private int loginPanelFrameContainer = R.id.login_panel_frame_container;
    //for sign up
    //private View mContinueButton;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_with_fragments);
        Log.d(TAG, "onCreate");
        initView();



    }

    private void initView() {

        //views search
        //mInputNameEditText = (EditText) findViewById(R.id.input_name_for_login_edit_text);
        //mInputPasswordText = (EditText) findViewById(R.id.input_password_for_login_edit_text);
        //mLoginButton = (Button) findViewById(R.id.login_button);

       // mContinueButton = (Button) findViewById(R.id.continue_button);
        mShowLoginPanelButton = (Button) findViewById(R.id.show_login_panel_button);
        mShowRemindPasswordPanelButton = (Button) findViewById(R.id.show_remind_password_panel_button);

        initActions();
    }

    private void initActions() {
        //views setting
        mShowLoginPanelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showFragmentWithAdd(loginPanelFrameContainer, new LoginFragment());
            }
        });



        /*mLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showFragmentWithReplace(new LoginFragment());


            }
        });*/

       /* mContinueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String toastPressCounter = String.format("\"SIGN UP\" Button was pressed %s times", "");

                Toast.makeText(WithFragmentsLoginActivity.this, toastPressCounter, Toast.LENGTH_LONG).show();
                Intent intent = new Intent(WithFragmentsLoginActivity.this, AppActivity.class);
                startActivity(intent);

            }
        });*/


    }

    public void getNewFragmentwithReplace() {
        showFragmentWithReplace(new RemindPasswordFragment());
    }



    private void showFragmentWithReplace(Fragment fragment) {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.login_panel_frame_container, fragment);
        transaction.commit();
    }
    public void showFragmentWithAdd(int frameContaner, Fragment fragment) {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();

        transaction.add(frameContaner, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
    public void hideFragment(int frameContaner, Fragment fragment) {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.hide(fragment);
        transaction.commit();
    }

    public void showFragment(Fragment fragment) {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.show(fragment);
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
