package com.mega.socialkunto;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;


import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.mega.socialkunto.Fragment.AddFragment;
import com.mega.socialkunto.Fragment.HomeFragment;
import com.mega.socialkunto.Fragment.ProfileFragment;
import com.mega.socialkunto.Fragment.SearchFragment;
import com.mega.socialkunto.Fragment.WorkOutsFragment;
import com.mega.socialkunto.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(R.layout.activity_main);


        Window window = getWindow();
        window.setBackgroundDrawableResource(R.drawable.gradient_toolbar);

        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId()){

                    case R.id.home:
                        getSupportFragmentManager().beginTransaction().replace(R.id.flFragment,new  HomeFragment()).commit();
                        return true;

                    case R.id.notification:
                        getSupportFragmentManager().beginTransaction().replace(R.id.flFragment,new WorkOutsFragment()).commit();
                        return true;

                    case R.id.add:
                        getSupportFragmentManager().beginTransaction().replace(R.id.flFragment,new AddFragment()).commit();
                        return true;
                    case R.id.search:
                        getSupportFragmentManager().beginTransaction().replace(R.id.flFragment,new SearchFragment()).commit();
                        return true;

                    case R.id.profile:
                        getSupportFragmentManager().beginTransaction().replace(R.id.flFragment,new ProfileFragment()).commit();
                        return true;


                }
                return false;
            }
        });
        bottomNavigationView.setSelectedItemId(R.id.home);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_item,menu);
        return true;
    }
}