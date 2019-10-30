package com.br.italoscompany.eventstarterapp.Functionalities.EventResgister;


import android.os.Bundle;


import com.br.italoscompany.eventstarterapp.R;

import com.google.android.material.tabs.TabLayout;

import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import com.br.italoscompany.eventstarterapp.Adapters.SectionsPagerAdapter;



public class EventRegisterActivity extends AppCompatActivity implements IEventRegister.IView{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_register);
        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);

    }
}