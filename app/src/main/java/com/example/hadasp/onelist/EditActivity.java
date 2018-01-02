package com.example.hadasp.onelist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class EditActivity extends AppCompatActivity implements EditAdapter.CategoriesAdapterInteraction {

    private List<Category> categoriesList;
    private List<String> categoriesTitles;

    private EditAdapter mEditAdapter;
    private RecyclerView recyclerView;
    private EditText editTextNote;
    private EditText editTextCategory;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        recyclerView = (RecyclerView) findViewById(R.id.rv_categories_add_note);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        categoriesList = getCategoryList();
        mEditAdapter = new EditAdapter(this, categoriesList);
        recyclerView.setAdapter(mEditAdapter);

        editTextNote = (EditText) findViewById(R.id.et_add_note);
        editTextCategory = (EditText) findViewById(R.id.et_add_category);


    }

    @Override
    public void onUpdateCategory(Category category) {
        AppDatabase.getInstance(this).categoryDao().updateCategory(category);
    }

    public List<Category> getCategoryList() {
        return AppDatabase.getInstance(this).categoryDao().getAllCategories();
    }

    public void addNote(View view) {
        Note note = mEditAdapter.getNote();
        note.setChecked(false);
        note.setBody(editTextNote.getText().toString());

        AppDatabase.getInstance(this).noteDao().insertNote(note);
        Intent intent = new Intent(EditActivity.this, MainActivity.class);
        startActivity(intent);
    }

    public void addCategory(View view) {
        Category category = new Category();
        category.setTitle(editTextCategory.getText().toString());
        AppDatabase.getInstance(this).categoryDao().insertCategory(category);
        mEditAdapter.updateCategoryList(getCategoryList());

    }
}
