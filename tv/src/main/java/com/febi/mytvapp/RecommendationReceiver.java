package com.febi.mytvapp;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by Febi.M.Felix on 11/11/16.
 */

public class RecommendationReceiver extends BroadcastReceiver {
    private static final long INITIAL_DELAY = 1000;

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.e("TAG", "On Recieve");
        if (intent.getAction().equals(Intent.ACTION_BOOT_COMPLETED)) {
            scheduleRecommendationUpdate(context);
        }
    }

    private void scheduleRecommendationUpdate(Context context) {
        Log.e("TAG", "scheduleRecommendationUpdate");
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        Intent recommendationIntent = new Intent(context, UpdateRecommendationsService.class);
        PendingIntent alarmIntent = PendingIntent.getService(context, 0, recommendationIntent, 0);

        alarmManager.setInexactRepeating(AlarmManager.ELAPSED_REALTIME_WAKEUP, INITIAL_DELAY,
                AlarmManager.INTERVAL_HALF_HOUR, alarmIntent);
    }
}