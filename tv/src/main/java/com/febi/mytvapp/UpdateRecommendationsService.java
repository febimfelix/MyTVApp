package com.febi.mytvapp;

import android.app.IntentService;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.support.app.recommendation.ContentRecommendation;
import android.util.Log;

import com.bumptech.glide.Glide;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * Created by Febi.M.Felix on 11/11/16.
 */

public class UpdateRecommendationsService extends IntentService {
    private static final String TAG = "UpdateRecommendationsService";
    private static final int MAX_RECOMMENDATIONS = 3;
    private NotificationManager mNotifManager;

    public UpdateRecommendationsService() {
        super("RecommendationService");
    }

    @Override
    public void onCreate() {
        super.onCreate();

        Log.e("TAG", "On Create service");
        if (mNotifManager == null) {
            mNotifManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        }
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        // Generate recommendations, but only if recommendations are enabled
//        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
//        if (!sharedPreferences.getBoolean("RECOMMEND", true)) {
//            Log.d("TAG", "Recommendations disabled");
//            mNotifManager.cancelAll();
//            return;
//        }

        Log.e("TAG", "On Handle Intent");

        Resources res = getResources();
        int cardWidth = res.getDimensionPixelSize(R.dimen.card_width);
        int cardHeight = res.getDimensionPixelSize(R.dimen.card_width);
        ContentRecommendation.Builder builder = new ContentRecommendation.Builder()
                .setBadgeIcon(R.drawable.videos_by_google_icon);

        HashMap<String, List<Movie>> recommendationList = MovieList.getRecommendationsList();

        if (recommendationList.size() > 0) {
            try {
                for(int i = 0; i < recommendationList.get("Recommended").size(); i++) {
                    Movie movie = recommendationList.get("Recommended").get(i);
                    builder.setIdTag("Video " + i)
                            .setTitle(movie.getTitle())
                            .setText(getString(R.string.popular_header))
                            .setContentIntentData(ContentRecommendation.INTENT_TYPE_ACTIVITY,
                                    buildPendingIntent(movie), 0, null);

                    Bitmap bitmap = Glide.with(getApplication())
                            .load(movie.getCardImageUrl())
                            .asBitmap()
                            .into(cardWidth, cardHeight) // Only use for synchronous .get()
                            .get();
                    builder.setContentImage(bitmap);

                    // Create an object holding all the information used to recommend the content.
                    ContentRecommendation rec = builder.build();
                    Notification notification = rec.getNotificationObject(getApplicationContext());

                    if (BuildConfig.DEBUG) Log.d("Recommending video " , movie.getTitle());

                    // Recommend the content by publishing the notification.
                    mNotifManager.notify(i, notification);
                }
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
                Log.e("TAG", "Could not create");
            }
        }
    }

    private Intent buildPendingIntent(Movie movie) {
        Intent detailsIntent = new Intent(this, DetailsActivity.class);
        detailsIntent.putExtra(DetailsActivity.MOVIE, movie);

        return detailsIntent;
    }
}
