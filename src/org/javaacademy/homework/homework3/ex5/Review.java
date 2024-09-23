package org.javaacademy.homework.homework3.ex5;

import java.time.LocalDateTime;

public class Review {
    private int id;
    private String text;
    private int numberLikes;
    private LocalDateTime localDateTime;

    public Review(int id, String text, int numberLikes, LocalDateTime localDateTime) {
        this.id = id;
        this.text = text;
        this.numberLikes = numberLikes;
        this.localDateTime = localDateTime;
    }

    public int getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public int getNumberLikes() {
        return numberLikes;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", numberLikes=" + numberLikes +
                ", localDateTime=" + localDateTime +
                '}';
    }
}
