package com.github.alexvishneuski.androidmainclasses.activities;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.github.alexvishneuski.androidmainclasses.Constants;
import com.github.alexvishneuski.androidmainclasses.R;
import com.github.alexvishneuski.androidmainclasses.services.MyIntentService;

public class MainActivity extends AppCompatActivity {

    public final String TAG = this.getClass().getSimpleName();

    private Button mGoToLoginButton;
    private Button mGoToInStackUnsavedActivityButton;
    private Button mStartActivityForResultButton;
    private Button mGoToLoginWithFragmentsButton;
    private Button mStartIntentServiceAndCatchResultThroughManifestResciverButton;
    private Button mStartIntentServiceAndCatchResultThroughInActivityImplementedResciverButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate");

        mGoToLoginButton = (Button) findViewById(R.id.go_to_login_button);
        mGoToInStackUnsavedActivityButton = (Button) findViewById(R.id.go_to_in_stack_unsaved_activity_button);
        mStartActivityForResultButton = (Button) findViewById(R.id.start_activity_for_result_button);
        mGoToLoginWithFragmentsButton = (Button) findViewById(R.id.go_to_login_with_fragment_activity_button);
        mStartIntentServiceAndCatchResultThroughManifestResciverButton = (Button) findViewById(R.id.start_intent_service_and_catch_result_throuth_manifest_receiver_button);
        mStartIntentServiceAndCatchResultThroughInActivityImplementedResciverButton = (Button) findViewById(R.id.start_intent_service_and_catch_result_throuth_in_activity_implemented_receiver_button);

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

        mStartIntentServiceAndCatchResultThroughManifestResciverButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MyIntentService.class);
                intent.putExtra(Constants.INPUT_MESSAGE, "send to MyIntentService");

                startService(intent);
                Toast.makeText(MainActivity.this, "send to MyIntentService", Toast.LENGTH_SHORT).show();
            }
        });


    }


    //case 3
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data == null) {
            return;
        }
        String message = String.format("Your name is %s", data.getStringExtra("name"));
        Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
    }

    private BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            Log.d(TAG, "onReceive");
            String resultText =intent.getStringExtra(Constants.INPUT_MESSAGE);
            Toast.makeText(MainActivity.this, resultText, Toast.LENGTH_SHORT).show();
        }
    };

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume");
        LocalBroadcastManager.getInstance(this).registerReceiver(receiver, new IntentFilter(Constants.ACTION));
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
        Log.d(TAG, "onDestroy");
        LocalBroadcastManager.getInstance(this).unregisterReceiver(receiver);
        super.onDestroy();

    }


}
