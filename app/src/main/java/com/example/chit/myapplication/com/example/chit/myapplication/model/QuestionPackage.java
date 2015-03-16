package com.example.chit.myapplication.com.example.chit.myapplication.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Chit on 3/14/2015.
 */
public class QuestionPackage {

    private String questionText;
    private String questionAnswer;
    private Map<String, String> questionChoices;
    private String questionExplanation;

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public String getQuestionAnswer() {
        return questionAnswer;
    }

    public void setQuestionAnswer(String questionAnswer) {
        this.questionAnswer = questionAnswer;
    }

    public Map<String, String> getQuestionChoices() {
        return questionChoices;
    }

    public void setQuestionChoices(Map<String, String> questionChoices) {
        this.questionChoices = questionChoices;
    }

    public String getQuestionExplanation() {
        return questionExplanation;
    }

    public void setQuestionExplanation(String questionExplanation) {
        this.questionExplanation = questionExplanation;
    }

    @Override
    public String toString() {
        return "QuestionPackage{" +
                "questionText='" + questionText + '\'' +
                ", questionAnswer='" + questionAnswer + '\'' +
                ", questionChoices=" + questionChoices +
                ", questionExplanation='" + questionExplanation + '\'' +
                '}';
    }
}
