package com.mcqtest.questionanswer.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MCQ {

    @SerializedName("Question")

    private String question;

    @SerializedName("OptionList")
    private List<OptionList> optionList = null;

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<OptionList> getOptionList() {
        return optionList;
    }

    public void setOptionList(List<OptionList> optionList) {
        this.optionList = optionList;
    }
}
