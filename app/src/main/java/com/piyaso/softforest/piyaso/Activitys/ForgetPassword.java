package com.piyaso.softforest.piyaso.Activitys;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.EditText;


import com.piyaso.softforest.piyaso.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ForgetPassword extends AppCompatActivity {
    @BindView(R.id.phonenumber_txt)
    EditText phonenumber;
    @OnClick(R.id.reset_button)
    public void restPass()
    {
        String phone=phonenumber.getText().toString();
        Log.e("Phone",phone);
        //TODO :send a otp to mobile number and verify it
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);
        ButterKnife.bind(this);
    }

}
