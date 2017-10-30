package com.github.alexvishneuski.androidmainclasses.activities;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.github.alexvishneuski.androidmainclasses.R;
import com.github.alexvishneuski.androidmainclasses.fragments.ContinueFragment;
import com.github.alexvishneuski.androidmainclasses.fragments.LoginFragment;

public class WithFragmentsLoginActivity extends AppCompatActivity {

    public final String TAG = this.getClass().getSimpleName();

    //for log in
    private EditText mInputNameEditText;
    private EditText mInputPasswordText;
    private View mLoginButton;

    //for sign up
    private View mContinueButton;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_with_fragments);
        Log.d(TAG, "onCreate");
        initView();



    }

    private void initView() {

        //views search
        mInputNameEditText = (EditText) findViewById(R.id.input_name_for_login_edit_text);
        mInputPasswordText = (EditText) findViewById(R.id.input_password_for_login_edit_text);
        mLoginButton = (Button) findViewById(R.id.login_button);

        mContinueButton = (Button) findViewById(R.id.continue_button);

        initActions();
    }

    private void initActions() {
        //views setting
        mLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WithFragmentsLoginActivity.this, AppActivity.class);
                startActivity(intent);


            }
        });

        mContinueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String toastPressCounter = String.format("\"SIGN UP\" Button was pressed %s times", "");

                Toast.makeText(WithFragmentsLoginActivity.this, toastPressCounter, Toast.LENGTH_LONG).show();
                Intent intent = new Intent(WithFragmentsLoginActivity.this, AppActivity.class);
                startActivity(intent);

            }
        });

        showFragmentWithReplace(new Fragment());
    }

    public void getNewFragmentwithReplace() {
        showFragmentWithReplace(new ContinueFragment());
    }

    private void showFragmentWithReplace(Fragment fragment) {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.in_with_fragment_activity_frame_container, fragment);
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
