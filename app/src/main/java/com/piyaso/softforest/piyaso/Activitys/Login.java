package com.piyaso.softforest.piyaso.Activitys;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.piyaso.softforest.piyaso.HttpInterfaces.OnHttpResponceForLogin;
import com.piyaso.softforest.piyaso.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Login extends Activity implements OnHttpResponceForLogin
{

    @BindView(R.id.phonenumber_txt)
    EditText username;
    @BindView(R.id.password_txt)
    EditText password;


    @OnClick(R.id.forget_password_txt)
   public void forgetPass()
    {
        Intent intent=new Intent(getBaseContext(),ForgetPassword.class);
        startActivity(intent);
        finish();
    }

    @OnClick(R.id.login_button)
    public void setTexts(Button button)
    {

        Log.e("CLICK","click");
        if(isConnectedToNet(getBaseContext())) {
            String firebase_id=getFirebaseId();// Firebase id for getting notifiction
            String device_id=getDeviceIdfromMobile();//Device id for getting to authonticate user

            //TODO validate firebase and device id

            LoginUser(username.getText().toString(), password.getText().toString(),firebase_id,device_id);
        }
        else
        {
            //TODO : handle if no network connection is available
            Toast.makeText(this, "No internet connectivity", Toast.LENGTH_SHORT).show();
        }
    }

    private String getDeviceIdfromMobile() {
        String device_id="";

//        TelephonyManager telephonyManager = (TelephonyManager)getSystemService(Context.TELEPHONY_SERVICE);
//        device_id=telephonyManager.getDeviceId();

        return device_id;

    }

    private String getFirebaseId() {
        String firebaseid="";
        return firebaseid;
    }

    private void LoginUser(String usernameString, String passwordString, String firebaseid, String deviceid) {
        if(usernameString.equals("")&&passwordString.equals(""))
        {
            //TODO :validate functions

        }
else {
            Intent intent=new Intent(getBaseContext(),MainHome.class);
            startActivity(intent);
            finish();
           //TODO : call the api for login


        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_design);
        ButterKnife.bind(this);



    }

    public boolean isConnectedToNet(Context context)
    {
        ConnectivityManager cm =
                (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        boolean isConnected = activeNetwork != null &&
                activeNetwork.isConnectedOrConnecting();
        return isConnected;

    }

    @Override
    public void OnLoginSuccess(String stautus, String status_code, String message, String userid, String session_id, String role) {
//        Intent intent=new Intent(getBaseContext(),MainHome.class);
//        startActivity(intent);
//        finish();

    }

    @Override
    public void OnLoginFaild(Throwable throwable) {

    }
}
