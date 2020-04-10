package com.giangdm.tuvi.adapters;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.giangdm.tuvi.R;
import com.giangdm.tuvi.models.LeHoi;

import java.util.List;

public class LeHoiAdapter extends RecyclerView.Adapter<LeHoiAdapter.LeHoiViewHolder> {

    private Context context;
    private List<LeHoi> list;
    private View.OnClickListener onClickListener;

    public LeHoiAdapter(Context context, List<LeHoi> list, View.OnClickListener onClickListener) {
        this.context = context;
        this.list = list;
        this.onClickListener = onClickListener;
    }

    @NonNull
    @Override
    public LeHoiViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_nam_sinh, parent, false);
        return new LeHoiViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LeHoiViewHolder holder, int position) {

        holder.title.setText(position + 1 + " - " +list.get(position).getTitle());
        holder.leHoiRow.setTag(position);
        holder.leHoiRow.setOnClickListener(onClickListener);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class LeHoiViewHolder extends RecyclerView.ViewHolder{

        TextView title;
        RelativeLayout leHoiRow;

        public LeHoiViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.nam_sinh_txt);
            leHoiRow = itemView.findViewById(R.id.nam_sinh_layout);
        }
    }
}
