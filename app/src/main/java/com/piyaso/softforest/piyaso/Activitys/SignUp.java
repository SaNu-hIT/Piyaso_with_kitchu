package com.piyaso.softforest.piyaso.Activitys;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.piyaso.softforest.piyaso.R;

import butterknife.ButterKnife;

/**
 * Created by intellyelabs on 30/03/17.
 */

public class SignUp  extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity_new);
        ButterKnife.bind(this);



    }

}
