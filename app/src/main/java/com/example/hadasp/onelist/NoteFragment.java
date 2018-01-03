package com.example.hadasp.onelist;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class NoteFragment extends Fragment implements NoteAdapter.NotesAdapterInteraction {

    public NoteFragment() {
        // Required empty public constructor
    }

    private int mPosition;
    private List<Note> notes;
    private String categoryString;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.list_notes, container, false);
        Log.e("NoteFragment", Integer.toString(getId()));

        if (this.getArguments() != null){
            Log.e("NoteFragment", "SHIT");
            mPosition = this.getArguments().getInt("POSITION");
        } else {
            mPosition = 1;
        }
        Log.e("NoteFragment", Integer.toString(mPosition));
        Log.e("NoteFragment", AppDatabase.getInstance(getContext())
                .categoryDao().getCategoryById(mPosition).getTitle());
        categoryString = AppDatabase.getInstance(getContext())
                .categoryDao().getCategoryById(mPosition).getTitle();

        notes = getNoteList();
        final NoteAdapter adapter = new NoteAdapter(this, notes);

        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.rv_notes);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);

        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0,
                ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT ) {
            @Override
            public boolean onMove(RecyclerView recyclerView,
                                  RecyclerView.ViewHolder viewHolder,
                                  RecyclerView.ViewHolder target) {
                return false;
            }
            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
                int position = (int) viewHolder.itemView.getTag();
                Note currentNote = getNoteList().get(position);
                Log.e("NoteActivity", position + "=" + direction);
                onDeleteNote(currentNote);
                List<Note> updatedList = getNoteList();
                adapter.updateList(updatedList);
            }

        }).attachToRecyclerView(recyclerView);
        return rootView;
    }

    public void onDeleteNote(Note note) {
        AppDatabase.getInstance(getContext()).noteDao().deleteNote(note);
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onUpdateNote(Note note) {
        AppDatabase.getInstance(getContext()).noteDao().updateNote(note);
        MainActivity.updateUi(getFragmentManager(), getContext());
    }

    public List<Note> getNoteList() {
        switch (mPosition){
            case 1:
                return AppDatabase.getInstance(getContext()).noteDao()
                        .getNotesByCategory0(true);
            case 2:
                return AppDatabase.getInstance(getContext()).noteDao()
                        .getNotesByCategory1(true);
            case 3:
                return AppDatabase.getInstance(getContext()).noteDao()
                        .getNotesByCategory2(true);
            case 4:
                return AppDatabase.getInstance(getContext()).noteDao()
                        .getNotesByCategory3(true);
            case 5:
                return AppDatabase.getInstance(getContext()).noteDao()
                        .getNotesByCategory4(true);
            case 6:
                return AppDatabase.getInstance(getContext()).noteDao()
                        .getNotesByCategory5(true);
            case 7:
                return AppDatabase.getInstance(getContext()).noteDao()
                        .getNotesByCategory6(true);
            case 8:
                return AppDatabase.getInstance(getContext()).noteDao()
                        .getNotesByCategory7(true);
            case 9:
                return AppDatabase.getInstance(getContext()).noteDao()
                        .getNotesByCategory8(true);
            case 10:
                return AppDatabase.getInstance(getContext()).noteDao()
                        .getNotesByCategory9(true);
            default:
                return AppDatabase.getInstance(getContext()).noteDao()
                        .getNotesByCategory0(true);
        }
    }

}
