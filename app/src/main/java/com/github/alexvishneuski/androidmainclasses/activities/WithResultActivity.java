package com.github.alexvishneuski.androidmainclasses.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.github.alexvishneuski.androidmainclasses.R;

/**
 * Created by Asus on 30.10.2017.
 */
//case 3
public class WithResultActivity extends AppCompatActivity {

    public final String TAG = this.getClass().getSimpleName();

    private View mReturnNameButton;
    private EditText mInputNameEditText;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate");
        setContentView(R.layout.activity_with_result);
        initView();
    }

    private void initView() {
        mReturnNameButton = (Button) findViewById(R.id.return_result_button);
        mInputNameEditText = (EditText) findViewById(R.id.input_name_edit_text);


        mReturnNameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("name", mInputNameEditText.getText().toString());
                setResult(RESULT_OK, intent);

                finish();
            }
        });

    }
}
