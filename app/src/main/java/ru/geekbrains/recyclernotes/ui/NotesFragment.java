package ru.geekbrains.recyclernotes.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import ru.geekbrains.recyclernotes.R;
import ru.geekbrains.recyclernotes.repository.LocalRepositoryImpl;


public class NotesFragment extends Fragment implements OnItemClickListener {

    NotesAdapter notesAdapter;

    public static NotesFragment newInstance() {
        NotesFragment fragment = new NotesFragment();
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_notes, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initAdapter();
        initRecycler(view);

    }


    void initAdapter () {
        notesAdapter = new NotesAdapter();
        LocalRepositoryImpl localRepository = new LocalRepositoryImpl(requireContext().getResources());
        notesAdapter.setData(localRepository.init());
        notesAdapter.setOnItemClickListener(this);
    }


    void initRecycler (View view) {
        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(notesAdapter);
    }

    String [] getData() {
        String[] data = getResources().getStringArray(R.array.titles);
        return data;
    }

    @Override
    public void onItemClick(int element) {
        String [] data = getData();
        Toast.makeText(requireContext(), "Нажали на " + data[element], Toast.LENGTH_SHORT).show();
    }
}
