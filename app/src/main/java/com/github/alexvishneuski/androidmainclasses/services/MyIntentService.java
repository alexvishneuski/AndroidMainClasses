package com.github.alexvishneuski.androidmainclasses.services;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

import com.github.alexvishneuski.androidmainclasses.Constants;
import com.github.alexvishneuski.androidmainclasses.activities.LoginActivity;

public class MyIntentService extends IntentService {

    public final String TAG = this.getClass().getSimpleName();

    public MyIntentService() {
        super("FromLowerToUpperCaseApp");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        Log.d(TAG, "onHandleIntent");

        String message = intent.getStringExtra(Constants.INPUT_MESSAGE);


        message = message.toUpperCase();


        System.out.println(message);
        Intent resultIntent = new Intent();
        resultIntent.setAction(Constants.ACTION);
        resultIntent.addCategory(Intent.CATEGORY_DEFAULT);
        resultIntent.putExtra(Constants.OUTPUT_MESSAGE, message);

        sendBroadcast(resultIntent);
    }


}
