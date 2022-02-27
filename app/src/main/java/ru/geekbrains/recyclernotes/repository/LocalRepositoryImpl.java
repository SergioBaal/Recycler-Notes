package ru.geekbrains.recyclernotes.repository;

import android.content.res.Resources;
import android.content.res.TypedArray;

import java.util.ArrayList;
import java.util.List;

import ru.geekbrains.recyclernotes.R;

public class LocalRepositoryImpl implements CardSource {

    private List<CardData> dataSource;
    private Resources resources;



    public LocalRepositoryImpl(Resources resources) {
        dataSource = new ArrayList<CardData>();
        this.resources = resources;
    }

    public LocalRepositoryImpl init() {
        String[] titles = resources.getStringArray(R.array.titles);
        String[] notes = resources.getStringArray(R.array.notes);
        TypedArray colors = resources.obtainTypedArray(R.array.colors);

        for (int i = 0; i < titles.length; i++) {
            dataSource.add(new CardData(titles[i], notes[i], colors.getResourceId(i, 0), false));
        }
        return this;
    }


    @Override
    public int size() {
        return dataSource.size();
    }

    @Override
    public List<CardData> getAllCardData() {
        return dataSource;
    }

    @Override
    public CardData getCardData(int position) {
        return dataSource.get(position);
    }
}
