package com.example.ricardocossich.petagramrcenodejs;

/**
 * Created by rcossich on 17/04/2017.
 */


import android.util.Log;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

public class NotificationIDTokenService extends FirebaseInstanceIdService {

    private static final String TAG = "FIREBASE_TOKEN_OTR";
    @Override
    public void onTokenRefresh() {
        //super.onTokenRefresh();
        Log.d(TAG, "Solicitando Token desde onTokenRefresh()");
        String token = FirebaseInstanceId.getInstance().getToken();
        enviarTokenRegistro(token);
    }

    private void enviarTokenRegistro(String token) {
        Log.d(TAG,token);
    }
}