package ru.geekbrains.recyclernotes.repository;

public class CardData {
    private String title;
    private String description;
    private int color;
    private boolean like;


    public CardData(String title, String description, int color, boolean like) {
        this.title = title;
        this.description = description;
        this.color = color;
        this.like = like;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getColor() {
        return color;
    }

    public boolean isLike() {
        return like;
    }

    public void setLike(boolean like) {
        this.like = like;
    }
}
