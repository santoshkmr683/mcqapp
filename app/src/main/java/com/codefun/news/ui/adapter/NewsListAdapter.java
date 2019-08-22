package com.codefun.news.ui.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.codefun.R;
import com.codefun.news.model.Article;

import java.util.List;

public class NewsListAdapter extends RecyclerView.Adapter<NewsListAdapter.ViewHolder> {

    private Context mContext;
    private List<Article> mArticleList;
    private RecyclerItemClickListener mRecyclerItemClickListener;

    public NewsListAdapter(Context context, List<Article> articleList,
                           RecyclerItemClickListener recyclerItemClickListener) {
        this.mContext = context;
        this.mArticleList = articleList;
        this.mRecyclerItemClickListener = recyclerItemClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.adapter_news_item_layout, viewGroup, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {

        viewHolder.mAuthorName.setText(mArticleList.get(position).getAuthor());
        viewHolder.mTitle.setText(mArticleList.get(position).getTitle());
        viewHolder.mDescription.setText(mArticleList.get(position).getDescription());
        viewHolder.mPublishedDate.setText(mArticleList.get(position).getPublishedAt());
        viewHolder.mContent.setText(mArticleList.get(position).getContent());

        RequestOptions requestOptionsHospitalBanner = new RequestOptions();
        requestOptionsHospitalBanner.placeholder(R.drawable.splash_screen_logo);

        if (mArticleList.get(position).getUrlToImage() != null &&
                !mArticleList.get(position).getUrlToImage().isEmpty()) {
            Glide.with(mContext)
                    .load(mArticleList.get(position).getUrlToImage())
                    .apply(requestOptionsHospitalBanner)
                    .into(viewHolder.mImageView);
        }
    }

    @Override
    public int getItemCount() {
        return mArticleList.size();
    }

    public interface RecyclerItemClickListener {
        void onItemClick(String url);
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private TextView mAuthorName;
        private TextView mTitle;
        private TextView mDescription;
        private TextView mPublishedDate;
        private TextView mContent;
        private ImageView mImageView;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            mAuthorName = itemView.findViewById(R.id.author_name);
            mTitle = itemView.findViewById(R.id.title);
            mDescription = itemView.findViewById(R.id.description);
            mPublishedDate = itemView.findViewById(R.id.published_date);
            mContent = itemView.findViewById(R.id.content);
            mImageView = itemView.findViewById(R.id.image_view);
            itemView.setOnClickListener(v -> mRecyclerItemClickListener
                    .onItemClick(mArticleList.get(getAdapterPosition()).getUrl()));
        }
    }
}
