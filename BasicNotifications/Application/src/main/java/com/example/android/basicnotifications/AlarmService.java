package com.example.android.basicnotifications;

import android.app.AlarmManager;
import android.app.IntentService;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;

/**
 * Created by David on 7/6/2015.
 */
public class AlarmService extends IntentService {

    int alarmType;

    public AlarmService() {
        super("AlarmService");
    }

    @Override
    public void onHandleIntent(Intent intent) {
        alarmType = AlarmManager.ELAPSED_REALTIME;
        long screenTime = intent.getLongExtra("screenTime", 20);
        Intent alarmIntent = new Intent(this, AlarmReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 0, alarmIntent, 0);
        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        alarmManager.setRepeating(alarmType, screenTime, 5000, pendingIntent);
    }

}
