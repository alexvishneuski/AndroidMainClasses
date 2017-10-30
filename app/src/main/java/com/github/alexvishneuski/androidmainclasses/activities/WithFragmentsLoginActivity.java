package com.github.alexvishneuski.androidmainclasses.activities;

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

        //views setting
        mSignUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String toastPressCounter = String.format("\"SIGN UP\" Button was pressed %s times", String.valueOf(++mSignUpButtonPressCounter));

                Toast.makeText(WithFragmentsLoginActivity.this, toastPressCounter, Toast.LENGTH_LONG).show();
                Intent intent = new Intent(WithFragmentsLoginActivity.this, AppActivity.class);
                startActivity(intent);

            }
        });

    }

    private void initView() {

        //views search
        mInputNameEditText = (EditText) findViewById(R.id.input_name_for_login_edit_text);
        mInputPasswordText = (EditText) findViewById(R.id.input_password_for_login_edit_text);
        mLoginButton = (Button) findViewById(R.id.login_button);

        mInputNameForSignUpEditText = (EditText) findViewById(R.id.input_full_name_for_sign_up_edit_text);
        mInputEmailForSignUpEditText = (EditText) findViewById(R.id.input_email_for_sign_up_edit_text);
        mInputPasswordForSignUpText = (EditText) findViewById(R.id.input_email_for_sign_up_edit_text);
        mSignUpButton = (Button) findViewById(R.id.sign_up_button);


    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart");
    }

    //2.2 getting saved state approach 1: obtaining of login button press count in onRestoreInstanceState
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        mLoginButtonPressCounter = savedInstanceState.getInt(LOGIN_BUTTON_PRESSED_TIMES);
        Log.d(TAG, "onRestoreInstanceState");

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume");
        //views setting
        mLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String toastPressCounter = String.format("\"LOG IN\" Button was pressed %s times", String.valueOf(++mLoginButtonPressCounter));

                Toast.makeText(WithFragmentsLoginActivity.this, toastPressCounter, Toast.LENGTH_LONG).show();
                Intent intent = new Intent(WithFragmentsLoginActivity.this, AppActivity.class);
                startActivity(intent);


            }
        });
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
