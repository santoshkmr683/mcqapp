package com.codefun.common.util;

import android.content.Context;
import android.content.res.AssetManager;

import com.codefun.questionanswer.model.InputOutputQuesAns;
import com.codefun.questionanswer.model.MCQ;
import com.codefun.questionanswer.model.QuestionAnswer;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.List;

public class CodeFunUtil {

    private static String AssetJSONFile(String filename, Context context) throws IOException {
        AssetManager manager = context.getAssets();
        InputStream file = manager.open(filename);
        byte[] formArray = new byte[file.available()];
        file.read(formArray);
        file.close();
        return new String(formArray);
    }

    public static List<QuestionAnswer> getQuestionAnswerList(Context context) {

        List<QuestionAnswer> questionAnswerList = null;
        String questionAnswer;
        try {
            questionAnswer = AssetJSONFile(Constant.JsonFile.QUESTION_ANSWER_LIST, context);

            if (!questionAnswer.isEmpty()) {
                Gson gson = new Gson();
                Type listType = new TypeToken<List<QuestionAnswer>>() {
                }.getType();
                questionAnswerList = gson.fromJson(questionAnswer, listType);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return questionAnswerList;
    }

    public static List<InputOutputQuesAns> getInputOutputQuesAnsList(Context context) {

        List<InputOutputQuesAns> inputOutputQuesAnsList = null;
        String questionAnswer;
        try {
            questionAnswer = AssetJSONFile(Constant.JsonFile.INPUT_OUTPUT_QUES_ANS_LIST, context);

            if (!questionAnswer.isEmpty()) {
                Gson gson = new Gson();
                Type listType = new TypeToken<List<InputOutputQuesAns>>() {
                }.getType();
                inputOutputQuesAnsList = gson.fromJson(questionAnswer, listType);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return inputOutputQuesAnsList;
    }

    public static List<MCQ> getMcqQuesAnsList(Context context) {

        List<MCQ> mcqList = null;
        String questionAnswer;
        try {
            questionAnswer = AssetJSONFile(Constant.JsonFile.MCQ_LIST, context);

            if (!questionAnswer.isEmpty()) {
                Gson gson = new Gson();
                Type listType = new TypeToken<List<MCQ>>() {
                }.getType();
                mcqList = gson.fromJson(questionAnswer, listType);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return mcqList;
    }
}
