package com.example.qasemtest.Aurora.Activity.Service;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.os.Build;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.example.qasemtest.R;

public class JobServiceNote extends JobService {
    private static final String CHANNEL_ID = "1";

    @Override
    public boolean onStartJob(JobParameters params) {
        createNotificationChannel();
        return false;
    }

    @Override
    public boolean onStopJob(JobParameters params) {
        return false;
    }
    private void createNotificationChannel() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = getString(R.string.ere);
            String description = getString(R.string.channel_description);
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
            channel.setDescription(description);

            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
            NotificationCompat.Builder builder = new NotificationCompat.Builder(this, CHANNEL_ID)
                    .setSmallIcon(R.drawable.appicon)
                    .setContentTitle("Aurora")
                    .setContentText("textContent")
                    .setPriority(NotificationCompat.PRIORITY_DEFAULT);
            NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(this);

            notificationManager.notify(2, builder.build());
        }
    }
}
