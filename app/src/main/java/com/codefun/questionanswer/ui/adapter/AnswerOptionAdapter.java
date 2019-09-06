package com.codefun.questionanswer.ui.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.codefun.R;
import com.codefun.questionanswer.model.OptionList;

import java.util.List;

public class AnswerOptionAdapter extends RecyclerView
        .Adapter<AnswerOptionAdapter.ViewHolder> {

    private Context mContext;
    private List<OptionList> mOptionList;
    private AdapterItemClickListener mAdapterItemClickListener;

    public AnswerOptionAdapter(Context context, List<OptionList> optionList,
                               AdapterItemClickListener adapterItemClickListener) {
        this.mContext = context;
        this.mOptionList = optionList;
        this.mAdapterItemClickListener = adapterItemClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.input_output_ans_adapter_item_layout, viewGroup, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        viewHolder.ansSerialNo.setText(mOptionList.get(position).getSerialNo());
        viewHolder.ansContent.setText(mOptionList.get(position).getOptionContent());

        if (mOptionList.get(position).isSelected() && mOptionList.get(position).isCorrectAns()) {
            viewHolder.ansRootLayout.setBackgroundColor(mContext.getResources()
                    .getColor(R.color.colorAppTheme_80_percent_transparent));
        } else if (mOptionList.get(position).isSelected() && !mOptionList.get(position).isCorrectAns()) {
            viewHolder.ansRootLayout.setBackgroundColor(mContext.getResources()
                    .getColor(R.color.error_red));
        } else {
            viewHolder.ansRootLayout.setBackgroundColor(Color.TRANSPARENT);
        }
    }

    @Override
    public int getItemCount() {
        return mOptionList.size();
    }

    public interface AdapterItemClickListener {
        void onItemClick();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView ansSerialNo;
        private TextView ansContent;
        private View ansRootLayout;

        ViewHolder(@NonNull View itemView) {
            super(itemView);

            ansRootLayout = itemView.findViewById(R.id.ans_root_layout);
            ansSerialNo = itemView.findViewById(R.id.ans_serial_no);
            ansContent = itemView.findViewById(R.id.ans_content);
            ansRootLayout.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int clickedPosition = getAdapterPosition();
            OptionList optionList = mOptionList.get(clickedPosition);
            optionList.setSelected(true);
            clearAnswerSelectionsExceptPosition(clickedPosition);
        }

        /**
         * clear all the selection apart from clicked position .
         * @param clickedPosition is a current click position
         */
        private void clearAnswerSelectionsExceptPosition(int clickedPosition) {
            for (OptionList optionList : mOptionList) {
                if (mOptionList.indexOf(optionList) != clickedPosition) {
                    optionList.setSelected(false);
                }
            }
            notifyDataSetChanged();
        }
    }
}
