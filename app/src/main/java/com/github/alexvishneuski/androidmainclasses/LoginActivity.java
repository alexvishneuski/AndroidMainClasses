package com.github.alexvishneuski.androidmainclasses;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    public final String TAG = this.getClass().getSimpleName();

    //for log in
    private EditText mInputNameEditText;
    private EditText mInputPasswordText;
    private View mLoginButton;

    //for sign up
    private EditText mInputNameForSignUpEditText;
    private EditText mInputEmailForSignUpEditText;
    private EditText mInputPasswordForSignUpText;
    private View mSignUpButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Log.d(TAG, "onCreate");
        initView();

    }

    private void initView() {

        //views search
        mInputNameEditText = (EditText) findViewById(R.id.input_name_edit_text);
        mInputPasswordText = (EditText) findViewById(R.id.input_password_edit_text);
        mLoginButton = (Button) findViewById(R.id.login_button);

        mInputNameForSignUpEditText = (EditText) findViewById(R.id.input_full_name_for_sign_up_edit_text);
        mInputEmailForSignUpEditText = (EditText) findViewById(R.id.input_email_for_sign_up_edit_text);
        mInputPasswordForSignUpText = (EditText) findViewById(R.id.input_password_edit_text);
        mSignUpButton = (Button) findViewById(R.id.sign_up_button);

        //views setting
        mLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, AppActivity.class);
                startActivity(intent);
            }
        });

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
        Log.d(TAG, "onPayse");
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
