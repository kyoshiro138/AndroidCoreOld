package com.jp.androidcore.service.client;

import android.content.Context;

import com.android.volley.Response;
import com.jp.androidcore.core.service.client.OnServiceResponseListener;
import com.jp.androidcore.core.service.client.ServiceRestClient;
import com.jp.androidcore.core.service.request.BaseRequest;
import com.jp.androidcore.core.service.response.ServiceJsonResponse;
import com.jp.androidcore.service.request.GoogleDriveRequest;

public class GoogleDriveClient extends ServiceRestClient {

    public GoogleDriveClient(Context context, String tag, String url, Class<?> responseDataType, OnServiceResponseListener<ServiceJsonResponse> listener) {
        super(context, tag, url, responseDataType, listener);
    }

    @Override
    protected BaseRequest createRequest(int method, String url, Response.Listener<String> listener, Response.ErrorListener errorListener) {
        // TODO: Get google drive access token
        String accessToken = "";
        return new GoogleDriveRequest(method, url, accessToken, this, this);
    }
}
