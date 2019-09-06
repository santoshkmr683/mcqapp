package com.codefun.questionanswer.ui.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.codefun.R;
import com.codefun.questionanswer.model.OptionList;

import java.util.List;

public class InputOutputAnswerAdapter extends RecyclerView
        .Adapter<InputOutputAnswerAdapter.ViewHolder> {

    private Context mContext;
    private List<OptionList> mOptionList;
    private AdapterItemClickListener mAdapterItemClickListener;

    public InputOutputAnswerAdapter(Context context, List<OptionList> optionList,
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
    }

    @Override
    public int getItemCount() {
        return mOptionList.size();
    }

    public interface AdapterItemClickListener {
        void onItemClick();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private TextView ansSerialNo;
        private TextView ansContent;
        private View ansRootLayout;

        ViewHolder(@NonNull View itemView) {
            super(itemView);

            ansRootLayout = itemView.findViewById(R.id.ans_root_layout);
            ansSerialNo = itemView.findViewById(R.id.ans_serial_no);
            ansContent = itemView.findViewById(R.id.ans_content);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mOptionList.get(getAdapterPosition()).isCorrectAns()) {
                        ansRootLayout.setBackgroundColor(mContext.getResources().getColor(R.color.colorAppTheme_80_percent_transparent));
                    } else {
                        ansRootLayout.setBackgroundColor(mContext.getResources().getColor(R.color.error_red));
                    }
                    mAdapterItemClickListener.onItemClick();
                }
            });
        }
    }
}
