package com.codefun.questionanswer.model;

import com.google.gson.annotations.SerializedName;

public class OptionList {

    @SerializedName("SerialNo")
    private String serialNo;

    @SerializedName("CorrectAns")
    private boolean correctAns;

    @SerializedName("OptionContent")
    private String optionContent;

    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }

    public boolean isCorrectAns() {
        return correctAns;
    }

    public void setCorrectAns(boolean correctAns) {
        this.correctAns = correctAns;
    }

    public String getOptionContent() {
        return optionContent;
    }

    public void setOptionContent(String optionContent) {
        this.optionContent = optionContent;
    }
}
