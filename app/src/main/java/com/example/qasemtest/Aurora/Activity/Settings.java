package com.example.qasemtest.Aurora.Activity;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.lifecycle.ViewModelProvider;

import com.example.qasemtest.Aurora.Activity.AuroraDataBase.ViewModel;
import com.example.qasemtest.Aurora.Activity.ProfileWithFirebase.ProfileFirebaseActivity;
import com.example.qasemtest.Aurora.Activity.Service.JobServiceNote;
import com.example.qasemtest.R;
import com.example.qasemtest.databinding.ActivitySettingsBinding;

public class Settings extends AppCompatActivity implements View.OnClickListener {
    private static final String CHANNEL_ID = "1";
    private static final int JOB_ID = 1;
    ActivitySettingsBinding binding;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding =ActivitySettingsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setonclickListiner();
        binding.notifications.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (binding.notifications.isChecked()){
                    ComponentName componentName = new ComponentName(getApplicationContext(), JobServiceNote.class);
                    JobInfo jobInfo;
                    if (Build.VERSION.SDK_INT<= Build.VERSION_CODES.N){
                        jobInfo = new JobInfo.Builder(JOB_ID,componentName)
                                .setPeriodic(5000)
                                .build();
                    }else {
                        jobInfo = new JobInfo.Builder(JOB_ID,componentName)
                                .setMinimumLatency(5000)
                                .build();
                    }

                    JobScheduler scheduler = (JobScheduler) getSystemService(JOB_SCHEDULER_SERVICE);
                    scheduler.schedule(jobInfo);

                }else {

                }
            }
        });
        binding.sound.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (binding.sound.isChecked()){

                }else {

                }
            }
        });


        binding.cardRestart.setOnClickListener(v -> {
            createNotificationChannel();
        });

    }

    private void setonclickListiner() {
      binding.imageProfile.setOnClickListener(this::onClick);
    }


    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.image_profile){
            Intent intent = new Intent(getApplicationContext(), Profile.class);
            startActivity(intent);

        }

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