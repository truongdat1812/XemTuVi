package com.giangdm.tuvi.adapters;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.giangdm.tuvi.R;
import com.giangdm.tuvi.models.TuVi;

import java.util.List;

public class NamSinhAdapter extends RecyclerView.Adapter<NamSinhAdapter.NamSinhViewHolder> {

    private Context context;
    private List<TuVi> list;
    private View.OnClickListener mOnClickListener;

    public NamSinhAdapter(Context context, List<TuVi> list, View.OnClickListener mOnClickListener) {
        Log.d("DatTruong", "NamSinhAdapter: " + list.size());
        this.context = context;
        this.list = list;
        this.mOnClickListener = mOnClickListener;
        Log.d("DatTruong", "NamSinhAdapter: end");
    }

    @NonNull
    @Override
    public NamSinhViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_nam_sinh, parent, false);
        return new NamSinhViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NamSinhViewHolder holder, int position) {
        holder.namSinhTxt.setText(list.get(position).getTuoiName());
        holder.namSinhLayout.setTag(position);
        holder.namSinhLayout.setOnClickListener(mOnClickListener);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class NamSinhViewHolder extends RecyclerView.ViewHolder{

        public TextView namSinhTxt;
        public RelativeLayout namSinhLayout;

        public NamSinhViewHolder(@NonNull View itemView) {
            super(itemView);
            namSinhTxt = itemView.findViewById(R.id.nam_sinh_txt);
            namSinhLayout = itemView.findViewById(R.id.nam_sinh_layout);
        }
    }
}
