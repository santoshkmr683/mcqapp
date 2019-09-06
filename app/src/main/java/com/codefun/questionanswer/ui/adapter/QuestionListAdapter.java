package com.codefun.questionanswer.ui.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.codefun.R;
import com.codefun.questionanswer.model.MCQ;

import java.util.List;

public class QuestionListAdapter extends RecyclerView
        .Adapter<QuestionListAdapter.ViewHolder> implements InputOutputAnswerAdapter.AdapterItemClickListener {

    private Context mContext;
    private List<MCQ> mMcqList;

    public QuestionListAdapter(Context context, List<MCQ> mcqList) {
        this.mContext = context;
        this.mMcqList = mcqList;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.mcq_question_item_layout, viewGroup, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        viewHolder.questionTv.setText(mMcqList.get(position).getQuestion());
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(mContext);
        viewHolder.recyclerView.setLayoutManager(mLayoutManager);
        viewHolder.recyclerView.setItemAnimator(new DefaultItemAnimator());
        viewHolder.recyclerView.setAdapter(new InputOutputAnswerAdapter(mContext, mMcqList
                .get(position).getOptionList(), this));

    }

    @Override
    public int getItemCount() {
        return mMcqList.size();
    }

    @Override
    public void onItemClick() {

    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private TextView questionTv;
        private RecyclerView recyclerView;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            questionTv = itemView.findViewById(R.id.question);
            recyclerView = itemView.findViewById(R.id.recycler_view);
        }
    }
}
