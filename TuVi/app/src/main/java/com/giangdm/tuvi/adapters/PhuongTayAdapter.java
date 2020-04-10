package com.giangdm.tuvi.adapters;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.giangdm.tuvi.R;
import com.giangdm.tuvi.models.PhuongTay;
import com.squareup.picasso.Picasso;

import java.util.List;

public class PhuongTayAdapter extends RecyclerView.Adapter<PhuongTayAdapter.PhuongTayViewHolder> {

    private Context context;
    private List<PhuongTay> list;
    private View.OnClickListener mOnClickListener;

    public PhuongTayAdapter(Context context, List<PhuongTay> list, View.OnClickListener mOnClickListener) {
        this.context = context;
        this.list = list;
        this.mOnClickListener = mOnClickListener;
    }

    @NonNull
    @Override
    public PhuongTayViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item__boi_phuong_tay, parent, false);
        return new PhuongTayViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PhuongTayViewHolder holder, int position) {
        PhuongTay pt = list.get(position);
        holder.title.setText(pt.getContent());
        Picasso.with(context).load(pt.getImage()).fit().into(holder.image);
//        holder.image.setImageDrawable(context.getResources().getDrawable(pt.getImage()));
        holder.layout.setTag(position);
        holder.layout.setOnClickListener(mOnClickListener);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class PhuongTayViewHolder extends RecyclerView.ViewHolder {

        TextView title;
        ImageView image;
        RelativeLayout layout;

        public PhuongTayViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.pt_txt);
            image = itemView.findViewById(R.id.pt_img);
            layout = itemView.findViewById(R.id.pt_layout);
        }
    }
}
