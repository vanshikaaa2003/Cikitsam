package com.example.cikitsam;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.Dialog;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.navigation.NavigationView;
//import com.google.firebase.FirebaseApp;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private static final String CHANNEL_ID ="my channel";
    private static final int NOTIFICATION_ID =100;
    DrawerLayout drawerLayout;
    BottomNavigationView bottomNavigationView;
    FragmentManager fragmentManager;
    Toolbar toolbar;
    Dialog dailog;
    Button btnDailogCancel,btnDailoglogout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener((toggle));
        toggle.syncState();

        //firebase connection
        //FirebaseApp.initializeApp(this);

        //Notification to the user
        Drawable drawable = ResourcesCompat.getDrawable(getResources(),R.drawable.yp1,null);
        BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
        Bitmap largeIcon = bitmapDrawable.getBitmap();

        NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        Notification notification;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            notification = new Notification.Builder(this)
                    .setLargeIcon(largeIcon)
                    .setSmallIcon(R.drawable.yp1)
                    .setContentText("Cikitsam notifies you")
                    .setSubText("Time for the daily exercise")
                    .setChannelId(CHANNEL_ID)
                    .build();

            nm.createNotificationChannel(new NotificationChannel(CHANNEL_ID,"new Channel",NotificationManager.IMPORTANCE_HIGH));
        }
        else
        {
            notification = new Notification.Builder(this)
                    .setLargeIcon(largeIcon)
                    .setSmallIcon(R.drawable.yp1)
                    .setContentText("Cikitsam notifies you")
                    .setSubText("Time for the daily exercise")
                    .build();
        }
        nm.notify(NOTIFICATION_ID,notification);



        NavigationView navigationView = findViewById(R.id.navigation_drawer);
        navigationView.setNavigationItemSelectedListener(this);

        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setBackground(null);

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId();
                if(itemId == R.id.bottom_home)
                {
                    openFragment(new HomeFragment());
                    return true;
                }
                else if(itemId == R.id.bottom_yoga)
                {
                    openFragment(new ExerciseFragment());
                    return true;
                }
                else if(itemId == R.id.bottom_watch)
                {
                    openFragment(new WatchFragment());
                    return true;
                }
                else if(itemId == R.id.bottom_profile);
                {
                    openFragment((new ProfileFragment()));
                    return true;
                }
            }
        });

        fragmentManager = getSupportFragmentManager();
        openFragment((new HomeFragment()));
    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item)
    {
        int itemId = item.getItemId();

        if(itemId == R.id.med)
        {
            openFragment(new MedFragment());
        }
        else if(itemId == R.id.symptoms)
        {
            openFragment(new SymptomsFragment());
        }
        else if(itemId == R.id.info)
        {
            openFragment(new InfoFragment());
        }
        else if(itemId == R.id.act)
        {
            openFragment(new Activities());
        }
        else if(itemId == R.id.out)
        {
            openCustomDialog();
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
    @Override
    public void onBackPressed()
    {
        if(drawerLayout.isDrawerOpen(GravityCompat.START))
        {
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else
        {
            super.onBackPressed();
        }
    }

    private void openFragment(Fragment fragment)
    {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.fragment_container,fragment);
        transaction.commit();
    }
    private void openCustomDialog() {
        // Create and show the custom dialog
        CustomDialogFragment customDialog = new CustomDialogFragment();
        customDialog.show(getSupportFragmentManager(), "custom_dialog");
    }
}