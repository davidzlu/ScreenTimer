package com.example.android.basicnotifications;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by David on 7/15/2015.
 */

public class ScreenReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals(Intent.ACTION_SCREEN_ON))
        {
            Intent mainActivityIntent = new Intent();
            mainActivityIntent.setClass(context, MainActivity.class);

            context.startActivity(mainActivityIntent);
        }
    }
}
