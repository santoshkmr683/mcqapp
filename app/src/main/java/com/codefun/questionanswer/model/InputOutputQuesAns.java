package com.codefun.questionanswer.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class InputOutputQuesAns {

    @SerializedName("QuesHeading")
    private String quesHeading;

    @SerializedName("QuesCodeBody")
    private String quesCodeBody;

    @SerializedName("OptionList")
    private List<OptionList> optionList = null;

    public String getQuesHeading() {
        return quesHeading;
    }

    public void setQuesHeading(String quesHeading) {
        this.quesHeading = quesHeading;
    }

    public String getQuesCodeBody() {
        return quesCodeBody;
    }

    public void setQuesCodeBody(String quesCodeBody) {
        this.quesCodeBody = quesCodeBody;
    }

    public List<OptionList> getOptionList() {
        return optionList;
    }

    public void setOptionList(List<OptionList> optionList) {
        this.optionList = optionList;
    }
}
