package com.mycompany.smartquizapp.model;

import java.util.List;

public class QuizQuestion {

    private final int id;
    private final String text;
    private final List<String> options;
    private final String correctAnswer;

    public QuizQuestion(int id, String text, List<String> options, String correctAnswer) {
        this.id = id;
        this.text = text;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }

    public int getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public List<String> getOptions() {
        return options;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }
}
