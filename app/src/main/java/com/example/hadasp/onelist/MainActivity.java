package com.example.hadasp.onelist;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RadioGroup radioGroupAddNote;
    private ScrollView scrollViewAddNote;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //radioGroupAddNote = (RadioGroup) findViewById(R.id.rg_add_note);
        //scrollViewAddNote = (ScrollView) findViewById(R.id.scv_add_note);

        //Category category  = new Category();
        //category.setTitle("Home");
        //AppDatabase.getInstance(this).categoryDao().insertCategory(category);
        //category.setTitle("No Wifi");
        //AppDatabase.getInstance(this).categoryDao().insertCategory(category);
        //category.setTitle("Office");
        //AppDatabase.getInstance(this).categoryDao().insertCategory(category);
        //Log.e("MainActivity", "All categories were added");
        // Get the ViewPager and set it's PagerAdapter so that it can display items
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setAdapter(new CategoryAdapter(getSupportFragmentManager(),
                MainActivity.this));

        Log.e("MainActivity", "adapter is set");
        // Give the TabLayout the ViewPager
        TabLayout tabLayout = (TabLayout) findViewById(R.id.sliding_tabs);
        tabLayout.setupWithViewPager(viewPager);
    }

    public void openAddNoteLayout(View view) {
        Intent intent = new Intent(MainActivity.this, EditActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onDestroy() {
        AppDatabase.destroyInstance();
        super.onDestroy();
    }
}
