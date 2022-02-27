package ru.geekbrains.recyclernotes.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.ToggleButton;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import ru.geekbrains.recyclernotes.R;
import ru.geekbrains.recyclernotes.repository.CardData;
import ru.geekbrains.recyclernotes.repository.CardSource;

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.MyViewHolder> {

    private CardSource cardSource;
    OnItemClickListener onItemClickListener;


    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public void setData(CardSource cardSource) {
        this.cardSource = cardSource;
        notifyDataSetChanged(); // отрисовать все(!) данные. бывает ресурсно затратно.
    }

    NotesAdapter(CardSource cardSource) {
        this.cardSource = cardSource;
    }
    NotesAdapter() {

    }

    @Override
    public int getItemCount() {
        return cardSource.size();
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        return new MyViewHolder(layoutInflater.inflate(R.layout.fragment_notes_cardview_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.bindContentWithLayout(cardSource.getCardData(position));

    }





    class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView textViewTitle;
        private TextView textViewNote;
        private View colorView;
        private ToggleButton toggleButton;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewTitle = (TextView) itemView.findViewById(R.id.title);
            textViewNote = (TextView) itemView.findViewById(R.id.note);
            colorView =  itemView.findViewById(R.id.colorView);
            toggleButton = (ToggleButton) itemView.findViewById(R.id.like);
           /* textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (onItemClickListener != null) {
                        onItemClickListener.onItemClick(getLayoutPosition());
                    }
                }
            }); */
        }

        //в этом методе связываем контент с макетом
        public void bindContentWithLayout(CardData content) {
            textViewTitle.setText(content.getTitle());
            textViewNote.setText(content.getDescription());
            colorView.setBackgroundResource(content.getColor());
            toggleButton.setChecked(content.isLike());
        }

    }
}
