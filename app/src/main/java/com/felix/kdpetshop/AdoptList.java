package com.felix.kdpetshop;

import android.os.Bundle;
import com.google.android.material.tabs.TabLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

public class AdoptList extends AppCompatActivity {
    TextView loggedUsername;
    TabLayout tabLayout;
    ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adopt_list);

        loggedUsername = findViewById(R.id.logged_username);
        String username = getIntent().getStringExtra("username");
        loggedUsername.setText(username);
        tabLayout = findViewById(R.id.TabLayout);
        viewPager = findViewById(R.id.ViewPager);
        tabLayout.addTab(tabLayout.newTab().setText("Dog"));
        tabLayout.addTab(tabLayout.newTab().setText("Cat"));
        tabLayout.addTab(tabLayout.newTab().setText("Sugar Glider"));
        tabLayout.addTab(tabLayout.newTab().setText("Reptile"));

        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });



    };

    }

