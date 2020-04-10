package com.giangdm.tuvi.adapters;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.giangdm.tuvi.R;
import com.giangdm.tuvi.models.NgayLe;

import java.util.List;

public class NgayLeAdapter extends RecyclerView.Adapter<NgayLeAdapter.NgayLeViewHolder> {

    private Context context;
    private List<NgayLe> list;

    public NgayLeAdapter(Context context, List<NgayLe> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public NgayLeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_ngay_le, parent, false);
        return new NgayLeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NgayLeViewHolder holder, int position) {
        NgayLe ngayLe = list.get(position);
        holder.ngayThang.setText(ngayLe.getmDate());
        holder.content.setText(ngayLe.getContent());
        if (ngayLe.getType().equalsIgnoreCase("1")) {
            holder.content.setTextColor(context.getResources().getColor(android.R.color.holo_red_dark));
        } else {
            holder.content.setTextColor(context.getResources().getColor(android.R.color.black));
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class NgayLeViewHolder extends RecyclerView.ViewHolder{

        TextView ngayThang, content;

        public NgayLeViewHolder(@NonNull View itemView) {
            super(itemView);
            ngayThang = itemView.findViewById(R.id.ngay_le_date_txt);
            content = itemView.findViewById(R.id.ngay_le_content_txt);
        }
    }
}
