package com.example.ricardocossich.petagramrcenodejs;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.util.Log;

import com.example.ricardocossich.petagramrcenodejs.restApi.ConstantesRestApi;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;


/**
 * Created by rcossich on 17/04/2017.
 */

public class NotificationService  extends FirebaseMessagingService {

    public static final String TAG = "FIREBASE";
    public static final int    ID_NOTIFICACION = 001;
    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        //super.onMessageReceived(remoteMessage);


        // [START_EXCLUDE]
        // There are two types of messages data messages and notification messages. Data messages are handled
        // here in onMessageReceived whether the app is in the foreground or background. Data messages are the type
        // traditionally used with GCM. Notification messages are only received here in onMessageReceived when the app
        // is in the foreground. When the app is in the background an automatically generated notification is displayed.
        // When the user taps on the notification they are returned to the app. Messages containing both notification
        // and data payloads are treated as notification messages. The Firebase console always sends notification
        // messages. For more see: https://firebase.google.com/docs/cloud-messaging/concept-options
        // [END_EXCLUDE]


        // TODO(developer): Handle FCM messages here.
        // Not getting messages here? See why this may be: https://goo.gl/39bRNJ
        Log.d(TAG, "From: " + remoteMessage.getFrom());
        Log.d(TAG, "Message Notification Body: " + remoteMessage.getNotification().getBody());
        enviarNotificacion(remoteMessage);
        //enviarNotificacion2(remoteMessage);
    }

    public void enviarNotificacion(RemoteMessage remoteMessage){
        Intent i = new Intent(this, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, i, PendingIntent.FLAG_ONE_SHOT);
        Uri sonido = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        NotificationCompat.Builder notificacion = new NotificationCompat.Builder(this)
                .setSmallIcon(R.drawable.hueso_amarillo)
                .setContentTitle("Notificacion")
                .setContentText(remoteMessage.getNotification().getBody())
                .setAutoCancel(true)
                .setSound(sonido)
                .setContentIntent(pendingIntent)
                ;

        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(0, notificacion.build());

    }

    public void enviarNotificacion2(RemoteMessage remoteMessage) {
        NotificationCompat.Builder notif;
        //NotificationManager nm;
        notif = new NotificationCompat.Builder(getApplicationContext());
        notif.setSmallIcon(R.drawable.hueso_amarillo);
        notif.setContentTitle("Notificacion");
        notif.setContentText(remoteMessage.getNotification().getBody());
        Uri path = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        notif.setSound(path);
        //nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        Intent miPerfil = new Intent();
        miPerfil.setAction(ConstantesApp.MI_PERFIL_ACTION);
        PendingIntent pendingIntentMiPerfil = PendingIntent.getBroadcast(this,ID_NOTIFICACION,miPerfil,PendingIntent.FLAG_UPDATE_CURRENT);
        NotificationCompat.Action accion1 = new NotificationCompat.Action(R.drawable.ic_full_miperfil,getString(R.string.opcion1_notificacion),pendingIntentMiPerfil);
        notif.addAction(accion1);

        Intent Seguir = new Intent();
        Seguir.setAction(ConstantesApp.SEGUIR_INSTAGRAM);
        PendingIntent pendingIntentSeguir = PendingIntent.getBroadcast(this,ID_NOTIFICACION,Seguir,PendingIntent.FLAG_UPDATE_CURRENT);
        NotificationCompat.Action accion2 = new NotificationCompat.Action(R.drawable.ic_full_seguir,getString(R.string.opcion2_notificacion),pendingIntentSeguir);
        notif.addAction(accion2);

        Intent suPerfil = new Intent();
        Seguir.setAction(ConstantesApp.VER_OTRO_PERFIL);
        PendingIntent pendingIntentSuPerfil = PendingIntent.getBroadcast(this,ID_NOTIFICACION,suPerfil,PendingIntent.FLAG_UPDATE_CURRENT);
        NotificationCompat.Action accion3 = new NotificationCompat.Action(R.drawable.ic_full_superfil,getString(R.string.opcion3_notificacion),pendingIntentSuPerfil);
        notif.addAction(accion3);

        NotificationManagerCompat nm = NotificationManagerCompat.from(this);
        nm.notify(ID_NOTIFICACION,notif.build());

    }

}
