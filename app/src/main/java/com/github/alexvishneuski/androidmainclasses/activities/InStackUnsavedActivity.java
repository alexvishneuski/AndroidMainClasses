package com.github.alexvishneuski.androidmainclasses.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.github.alexvishneuski.androidmainclasses.R;

/**
 * Created by Asus on 30.10.2017.
 */

public class InStackUnsavedActivity extends AppCompatActivity {

    public final String TAG = this.getClass().getSimpleName();

    private View mGoToAppButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate");
        setContentView(R.layout.activity_in_stack_unsaved);
        initView();
    }


    public void initView() {
        mGoToAppButton = (Button) findViewById(R.id.go_to_app_button);
        mGoToAppButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(InStackUnsavedActivity.this, AppActivity.class);
                startActivity(intent);
            }
        });
    }
}
