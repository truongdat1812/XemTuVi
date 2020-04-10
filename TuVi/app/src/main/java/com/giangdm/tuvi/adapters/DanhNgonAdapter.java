package com.giangdm.tuvi.adapters;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.giangdm.tuvi.R;
import com.giangdm.tuvi.interfaces.OnLoadMoreListener;
import com.giangdm.tuvi.models.DanhNgon;

import java.util.List;

public class DanhNgonAdapter extends RecyclerView.Adapter {

    private Context context;
    private List<DanhNgon> list;

    private final int VIEW_ITEM = 0;
    private final int VIEW_PROG = 1;
    // before loading more.
    private int visibleThreshold = 1;
    private int lastVisibleItem, totalItemCount;
    private boolean loading;
    private OnLoadMoreListener onLoadMoreListener;

    public DanhNgonAdapter(Context context, List<DanhNgon> list, RecyclerView recyclerView) {
        this.context = context;
        this.list = list;

        if (recyclerView.getLayoutManager() instanceof LinearLayoutManager) {
            final LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
            recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
                @Override
                public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                    super.onScrolled(recyclerView, dx, dy);

                    totalItemCount = linearLayoutManager.getItemCount();
                    lastVisibleItem = linearLayoutManager.findLastVisibleItemPosition();
                    if (!loading && totalItemCount == lastVisibleItem + visibleThreshold) {
                        if (onLoadMoreListener != null) {
                            onLoadMoreListener.onLoadMore();
                            loading = true;
                        }
                    }
                }
            });
        }
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == VIEW_ITEM) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_danh_ngon, parent, false);
            return new DanhNgonViewHolder(view);
        } else if (viewType == VIEW_PROG){
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.progressbar, parent, false);
            return new ProgressViewHolder(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof DanhNgonViewHolder) {
            ((DanhNgonViewHolder)holder).stt.setText(position + 1 + "");
            ((DanhNgonViewHolder)holder).content.setText(list.get(position).getContent());
            if (list.get(position).getAuthor().equalsIgnoreCase("null")) {
                ((DanhNgonViewHolder)holder).author.setText("------");
            } else
                ((DanhNgonViewHolder)holder).author.setText(list.get(position).getAuthor());
        } else if (holder instanceof ProgressViewHolder){
            ((ProgressViewHolder) holder).progressBar.setIndeterminate(true);
        }
    }

    public void addItem(List<DanhNgon> danhNgonList){
        list.addAll(danhNgonList);
        notifyDataSetChanged();

    }
    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public int getItemViewType(int position) {

        return list.get(position) == null ? VIEW_PROG : VIEW_ITEM;
    }

    public void setLoaded() {
        loading = false;
    }

    public void setOnLoadMoreListener(OnLoadMoreListener onLoadMoreListener) {
        this.onLoadMoreListener = onLoadMoreListener;
    }

    class DanhNgonViewHolder extends RecyclerView.ViewHolder {

        public TextView stt, content, author;

        public DanhNgonViewHolder(@NonNull View itemView) {
            super(itemView);
            stt = itemView.findViewById(R.id.item_danh_ngon_no_txt);
            content = itemView.findViewById(R.id.item_danh_ngon_content_txt);
            author = itemView.findViewById(R.id.item_danh_ngon_author_txt);
        }
    }

    class ProgressViewHolder extends RecyclerView.ViewHolder {

        public ProgressBar progressBar;

        public ProgressViewHolder(@NonNull View itemView) {
            super(itemView);
            progressBar = itemView.findViewById(R.id.progressBar);
        }
    }
}
