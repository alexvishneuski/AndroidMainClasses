package com.github.alexvishneuski.androidmainclasses.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.github.alexvishneuski.androidmainclasses.R;

public class MainActivity extends AppCompatActivity {

    public final String TAG = this.getClass().getSimpleName();

    private Button mGoToLoginButton;
    private Button mGoToInStackUnsavedActivityButton;
    private Button mStartActivityForResultButton;
    private Button mGoToLoginWithFragmentsButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate");

        mGoToLoginButton = (Button) findViewById(R.id.go_to_login_button);
        mGoToInStackUnsavedActivityButton = (Button) findViewById(R.id.go_to_in_stack_unsaved_activity_button);
        mStartActivityForResultButton = (Button) findViewById(R.id.start_activity_for_result_button);
        mGoToLoginWithFragmentsButton = (Button) findViewById(R.id.go_to_login_with_fragment_activity_button);

        mGoToLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                //Case #1.2
                //intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                startActivity(intent);
            }
        });

        mGoToInStackUnsavedActivityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, InStackUnsavedActivity.class);
                //Case #1.2
                intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                startActivity(intent);
            }
        });
        //case 3
        mStartActivityForResultButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, WithResultActivity.class);

                startActivityForResult(intent, 1);
            }
        });
        mGoToLoginWithFragmentsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, WithFragmentsLoginActivity.class);

                startActivity(intent);
            }
        });
    }

    //case 3
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data == null) {return;}
        String message = String.format("Your name is %s",data.getStringExtra("name"));
        Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
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
