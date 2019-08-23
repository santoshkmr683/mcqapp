package com.codefun.questionanswer.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class QuestionAnswer {

    @SerializedName("SerialNo")
    @Expose
    private int serialNo;

    @SerializedName("Question")
    @Expose
    private String question;

    @SerializedName("Answer")
    @Expose
    private String answer;

    public int getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(int serialNo) {
        this.serialNo = serialNo;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
