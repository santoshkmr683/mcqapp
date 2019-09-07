package com.mcqtest.questionanswer.ui.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mcqtest.R;
import com.mcqtest.questionanswer.model.MCQ;

import java.util.List;

public class QuestionListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context mContext;
    private List<MCQ> mMcqList;
    private static final int TYPE_ITEM = 0;
    private static final int TYPE_FOOTER = 1;
    private AdapterSubmitClickListener mAdapterSubmitClickListener;

    public QuestionListAdapter(Context context, List<MCQ> mcqList,
                               AdapterSubmitClickListener adapterSubmitClickListener) {
        this.mContext = context;
        this.mMcqList = mcqList;
        this.mAdapterSubmitClickListener = adapterSubmitClickListener;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        if (viewType == TYPE_FOOTER) {
            View itemView = LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.submit_button_layout, viewGroup, false);
            return new FooterViewHolder(itemView);
        } else {
            View itemView = LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.mcq_question_item_layout, viewGroup, false);
            return new ItemViewHolder(itemView);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        if (viewHolder instanceof ItemViewHolder) {
            ItemViewHolder itemViewHolder = (ItemViewHolder) viewHolder;
            itemViewHolder.questionTv.setText(mMcqList.get(position).getQuestion());
            RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(mContext);
            itemViewHolder.recyclerView.setLayoutManager(mLayoutManager);
            itemViewHolder.recyclerView.setItemAnimator(new DefaultItemAnimator());
            itemViewHolder.recyclerView.setAdapter(new AnswerOptionAdapter(mContext, mMcqList
                    .get(position).getOptionList()));
        }
    }

    @Override
    public int getItemCount() {
        return mMcqList.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (position == (mMcqList.size() - 1)) {
            return TYPE_FOOTER;
        } else {
            return TYPE_ITEM;
        }
    }


    public interface AdapterSubmitClickListener {
        void onSubmitButtonClick(List<MCQ> mcqList);
    }

    class ItemViewHolder extends RecyclerView.ViewHolder {

        private TextView questionTv;
        private RecyclerView recyclerView;

        ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            questionTv = itemView.findViewById(R.id.question);
            recyclerView = itemView.findViewById(R.id.recycler_view);
        }
    }

    class FooterViewHolder extends RecyclerView.ViewHolder {

        FooterViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.findViewById(R.id.submit_btn).setOnClickListener(v ->
                    mAdapterSubmitClickListener.onSubmitButtonClick(mMcqList));
        }
    }

}
