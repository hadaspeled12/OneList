package com.example.hadasp.onelist;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by HP-PC on 12/10/2017.
 */

public class CategoryAdapter extends FragmentPagerAdapter {
    private int PAGE_COUNT = 1 ;
    private List<Category> tabCategories;
    private List<String> tabTitles;
    private Context context;

    public CategoryAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
        tabCategories = new ArrayList<>();
        tabTitles = new ArrayList<>();
        if (AppDatabase.getInstance(context).categoryDao().getAllCategories() != null){
            this.tabCategories.addAll(AppDatabase.getInstance(context).categoryDao().getAllCategories());
            for (int i = 0; i < this.tabCategories.size(); i++){
                tabTitles.add(this.tabCategories.get(i).getTitle());
            }
        }
        //tabTitles.add("+");
        this.PAGE_COUNT = this.tabTitles.size();
    }

    @Override
    public int getCount(){
        return PAGE_COUNT;
    }

    @Override
    public Fragment getItem(int position) {

        NoteFragment noteFragment =  new NoteFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("POSITION", position+1);
        noteFragment.setArguments(bundle);
        Log.e("CategotyAdapter", Integer.toString(position));
        return noteFragment;

    }

    @Override
    public CharSequence getPageTitle(int position) {
        // Generate title based on item position
        return tabTitles.get(position);
    }

}

