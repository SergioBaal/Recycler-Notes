package ru.geekbrains.recyclernotes.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import ru.geekbrains.recyclernotes.R;

public class MainActivity extends AppCompatActivity {

    //TODO: Добавить "редактирование заметки в попап меню. Добавить тайтлБар меню.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, NotesFragment.newInstance())
                    .commit();
        }
    }
}