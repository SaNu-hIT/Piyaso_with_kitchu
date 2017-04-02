package com.piyaso.softforest.piyaso.HttpInterfaces;

/**
 * Created by intellyelabs on 13/03/17.
 */

public interface OnHttpResponceForLogin {
    void OnLoginSuccess(String stautus, String status_code, String message, String userid, String session_id, String role);
    void OnLoginFaild(Throwable throwable);
}
