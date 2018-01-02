package com.example.hadasp.onelist;

import android.support.v7.widget.AppCompatCheckBox;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;

import java.util.List;

/**
 * Created by hadasp on 10/12/2017.
 */

public class EditAdapter extends RecyclerView.Adapter<EditAdapter.ViewHolder> {


    private List<Category> mCategoryList;
    private Note note;
    private final CategoriesAdapterInteraction mListener;

    public EditAdapter(CategoriesAdapterInteraction categoriesAdapterInteraction, List<Category> categoryList) {
        mListener = categoriesAdapterInteraction;
        mCategoryList = categoryList;
        this.note = new Note();
        this.note.setCategory0(false);
        this.note.setCategory1(false);
        this.note.setCategory2(false);
        this.note.setCategory3(false);
        this.note.setCategory4(false);
        this.note.setCategory5(false);
        this.note.setCategory6(false);
        this.note.setCategory7(false);
        this.note.setCategory8(false);
        this.note.setCategory9(false);
    }

    public Note getNote(){
        return this.note;
    }

    public void updateCategoryList(List<Category> updatedList) {
        mCategoryList = updatedList;
        notifyDataSetChanged();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final RadioButton radioButton;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            radioButton = view.findViewById(R.id.rb_category);
        }
    }

    @Override
    public EditAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_category, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final EditAdapter.ViewHolder holder, int position) {
        holder.radioButton.setChecked(false);
        holder.radioButton.setText(mCategoryList.get(position).getTitle());
        holder.radioButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                switch (holder.getAdapterPosition()){
                    case 0:
                        note.setCategory0(b);
                        break;
                    case 1:
                        note.setCategory1(b);
                        break;
                    case 2:
                        note.setCategory2(b);
                        break;
                    case 3:
                        note.setCategory3(b);
                        break;
                    case 4:
                        note.setCategory4(b);
                        break;
                    case 5:
                        note.setCategory5(b);
                        break;
                    case 6:
                        note.setCategory6(b);
                        break;
                    case 7:
                        note.setCategory7(b);
                        break;
                    case 8:
                        note.setCategory8(b);
                        break;
                    case 9:
                        note.setCategory9(b);
                        break;
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return mCategoryList.size();
    }

    public interface CategoriesAdapterInteraction {
        void onUpdateCategory(Category category);
    }

}
