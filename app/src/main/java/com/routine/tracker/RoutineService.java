package com.routine.tracker;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import androidx.core.app.NotificationCompat;
import java.util.Calendar;

public class RoutineService extends Service {
    private static final String CHANNEL_ID = "RoutineTrackerChannel";
    private static final int NOTIFICATION_ID = 1;
    private Handler handler;
    private Runnable updateRunnable;

    @Override
    public void onCreate() {
        super.onCreate();
        createNotificationChannel();
        handler = new Handler();
        startForegroundWithNotification();
        scheduleUpdates();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return START_STICKY; // Service will restart if killed
    }

    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(
                    CHANNEL_ID,
                    "Routine Tracker",
                    NotificationManager.IMPORTANCE_HIGH // HIGH importance for visibility
            );
            channel.setDescription("Shows your current routine activity");
            channel.setLockscreenVisibility(Notification.VISIBILITY_PUBLIC);
            channel.enableLights(true); // Enable LED
            channel.setLightColor(0xFFFF5722); // Bright orange-red
            channel.enableVibration(false); // Disable vibration to avoid annoyance
            channel.setShowBadge(true);

            NotificationManager manager = getSystemService(NotificationManager.class);
            if (manager != null) {
                manager.createNotificationChannel(channel);
            }
        }
    }

    private void startForegroundWithNotification() {
        Notification notification = buildNotification();
        startForeground(NOTIFICATION_ID, notification);
    }

    private Notification buildNotification() {
        RoutineActivity activity = getCurrentActivity();

        Intent notificationIntent = new Intent(this, MainActivity.class);
        notificationIntent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);

        PendingIntent pendingIntent = PendingIntent.getActivity(
                this,
                0,
                notificationIntent,
                PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_IMMUTABLE
        );

        return new NotificationCompat.Builder(this, CHANNEL_ID)
                // Title & text
                .setContentTitle(activity.title)
                .setContentText(activity.description)

                // Expanded content (bigger text)
                .setStyle(new NotificationCompat.BigTextStyle()
                        .setBigContentTitle(activity.title)
                        .bigText(activity.description + "\n\nStay consistent 💪"))

                // Icon
                .setSmallIcon(R.drawable.ic_launcher_background)

                // Behavior
                .setContentIntent(pendingIntent)
                .setOngoing(true)                 // Persistent
                .setOnlyAlertOnce(true)           // No repeated sound/flash
                .setAutoCancel(false)

                // Visibility & priority
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setCategory(NotificationCompat.CATEGORY_STATUS)
                .setVisibility(NotificationCompat.VISIBILITY_PUBLIC)

                // Color / styling
                .setColor(0xFFFFEB3B)              // Bright orange accent
                .setColorized(true)

                .build();
    }

    private void scheduleUpdates() {
        updateRunnable = new Runnable() {
            @Override
            public void run() {
                updateNotification();
                handler.postDelayed(this, 10000); // Update every 10 seconds for faster response
            }
        };
        handler.post(updateRunnable);
    }

    private void updateNotification() {
        Notification notification = buildNotification();
        NotificationManager manager = getSystemService(NotificationManager.class);
        if (manager != null) {
            manager.notify(NOTIFICATION_ID, notification);
        }
    }

    private RoutineActivity getCurrentActivity() {
        Calendar calendar = Calendar.getInstance();
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);
        int timeInMinutes = hour * 60 + minute;

        RoutineSchedule schedule = new RoutineSchedule();
        return schedule.getActivity(dayOfWeek, timeInMinutes);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (handler != null && updateRunnable != null) {
            handler.removeCallbacks(updateRunnable);
        }
        // Restart the service if destroyed
        Intent restartIntent = new Intent(getApplicationContext(), RoutineService.class);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            startForegroundService(restartIntent);
        } else {
            startService(restartIntent);
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}