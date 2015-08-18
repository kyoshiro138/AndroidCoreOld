package com.jp.androidcore.core.googleservice.driveapi;

public interface OnGoogleAuthListener {
    void onAuthSuccess(String token);
    void onAuthError(Exception e);
}
