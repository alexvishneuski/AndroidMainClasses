package com.github.alexvishneuski.androidmainclasses.services;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.util.Log;

import com.github.alexvishneuski.androidmainclasses.Constants;

public class MyIntentService extends IntentService {

    public final String TAG = this.getClass().getSimpleName();

    public MyIntentService() {
        super("changeMessageService");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        Log.d(TAG, "onHandleIntent");

        String message = intent.getStringExtra(Constants.TO_SERVICE_MESSAGE);
        Log.d(TAG, "message before change: " + message);
        message = "send from MyIntentService to MainActivity";
        Log.d(TAG, "message after change: " + message);

        Intent resultIntent = new Intent();
        resultIntent.setAction(Constants.ACTION);
        resultIntent.putExtra(Constants.FROM_SERVICE_MESSAGE, message);
        sendBroadcast(resultIntent);
    }


}
