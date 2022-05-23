package com.mega.socialkunto;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.Window;

import com.google.android.material.tabs.TabLayout;
import com.mega.socialkunto.Adapter.ViewPagerAdapter;

public class NotificationActivity extends AppCompatActivity {


    ViewPager viewPager;
    TabLayout tabLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        Window window = getWindow();
        window.setBackgroundDrawableResource(R.drawable.gradient_toolbar);

        viewPager =findViewById(R.id.viewPager);
        viewPager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager()));

        tabLayout=findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(viewPager);

    }
}