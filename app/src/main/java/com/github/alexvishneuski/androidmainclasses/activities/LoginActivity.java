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

public class LoginActivity extends AppCompatActivity {


    //static final String PRESSED_TIMES = "Pressed_times";

    int mLoginButtonPressCounter = 0;//=Constants.LOGIN_BUTTON_PRESS_COUNTER;
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
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Log.d(TAG, "onCreate");

        //2.2 obtaining of login button press count in onCreate
        //try {
       /* if (savedInstanceState != null) {
            mLoginButtonPressCounter = savedInstanceState.getInt(PRESSED_TIMES);
        } else mLoginButtonPressCounter = 0;*/
        // } catch (NullPointerException e) {
        //     //e.printStackTrace();
        //     mLoginButtonPressCounter = 0;
        // }

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


    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        mLoginButtonPressCounter = savedInstanceState.getInt("PRESSED_TIMES");
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

                Toast.makeText(LoginActivity.this, toastPressCounter, Toast.LENGTH_LONG).show();
                Intent intent = new Intent(LoginActivity.this, AppActivity.class);
                startActivity(intent);


            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause");
    }

    //2.1 save state through method onSaveInstanceState
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("PRESSED_TIMES", mLoginButtonPressCounter);

        Log.d(TAG, "onSaveInstanceState");


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
