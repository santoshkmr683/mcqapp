package com.codefun.questionanswer.ui.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.codefun.R;
import com.codefun.questionanswer.model.QuestionAnswer;

import java.util.List;

public class QuestionAnswerListAdapter extends RecyclerView
        .Adapter<QuestionAnswerListAdapter.ViewHolder> {

    private List<QuestionAnswer> mQuestionAnswerList;

    public QuestionAnswerListAdapter(List<QuestionAnswer> questionAnswerList) {
        this.mQuestionAnswerList = questionAnswerList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.question_answer_item_layout, viewGroup, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {

        viewHolder.serialNo.setText(String.valueOf(mQuestionAnswerList.get(position).getSerialNo()));
        viewHolder.question.setText(mQuestionAnswerList.get(position).getQuestion());
        viewHolder.answerContent.setText(mQuestionAnswerList.get(position).getAnswer());
    }

    @Override
    public int getItemCount() {
        return mQuestionAnswerList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private TextView serialNo;
        private TextView question;
        private TextView answerContent;

        ViewHolder(@NonNull View itemView) {
            super(itemView);

            serialNo = itemView.findViewById(R.id.serial_no);
            question = itemView.findViewById(R.id.question);
            answerContent = itemView.findViewById(R.id.answer_content);
        }
    }
}
