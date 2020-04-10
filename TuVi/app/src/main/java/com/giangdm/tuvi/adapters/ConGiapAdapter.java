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
import com.giangdm.tuvi.models.TuVi;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ConGiapAdapter extends RecyclerView.Adapter<ConGiapAdapter.ConGiapViewHolder> {

    private Context context;
    private List<TuVi> list;
    private View.OnClickListener mOnClickListener;

    public ConGiapAdapter(Context context, List<TuVi> list, View.OnClickListener onClickListener) {
        this.context = context;
        this.list = list;
        this.mOnClickListener = onClickListener;
    }

    @NonNull
    @Override
    public ConGiapViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_tuvi_congiap, parent, false);
        return new ConGiapViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ConGiapViewHolder holder, int position) {
        TuVi tv = list.get(position);
        holder.conGiapTxt.setText(tv.getNameConGiap());
        Picasso.with(context).load(tv.getImageConGiap()).fit().into(holder.conGiapImg);
        holder.itemConGiap.setTag(position);
        holder.itemConGiap.setOnClickListener(mOnClickListener);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ConGiapViewHolder extends RecyclerView.ViewHolder{

        public ImageView conGiapImg;
        public TextView conGiapTxt;
        public RelativeLayout itemConGiap;

        public ConGiapViewHolder(@NonNull View itemView) {
            super(itemView);
            conGiapImg = itemView.findViewById(R.id.item_congiap_img);
            conGiapTxt = itemView.findViewById(R.id.item_congiap_txt);
            itemConGiap = itemView.findViewById(R.id.item_congiap_layout);
        }
    }
}
