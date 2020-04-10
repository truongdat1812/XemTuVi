package com.giangdm.tuvi.adapters;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableRow;
import android.widget.TextView;

import com.giangdm.tuvi.R;
import com.giangdm.tuvi.models.CungMang;

import java.util.List;

public class CungMangAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context mContext;
    private List<CungMang> list;

    private static final int TYPE_HEADER = 1;
    private static final int TYPE_ITEM = 2;

    public CungMangAdapter(Context mContext, List<CungMang> list) {
        this.mContext = mContext;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == TYPE_HEADER) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.header_cung_mang, parent, false);
            return new HeaderViewHolder(view);
        } else if (viewType == TYPE_ITEM) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cung_mang, parent, false);
            return new ItemViewHolder(view);
        }
        throw new RuntimeException("No match for " + viewType + ".");
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (position == 0) {
            position = 1;
        }
        CungMang cungMang = list.get(position -1 );
        if (holder instanceof ItemViewHolder) {
            ((ItemViewHolder) holder).namSinh.setText(cungMang.getNamSinh() + "");
            ((ItemViewHolder) holder).amLich.setText(cungMang.getAmLich());
            ((ItemViewHolder) holder).mang.setText(cungMang.getMang());
            ((ItemViewHolder) holder).cung.setText(cungMang.getCung());
            ((ItemViewHolder) holder).hanh.setText(cungMang.getHanh());

            if (position % 2 == 0) {
                ((ItemViewHolder) holder).row.setBackgroundColor(mContext.getResources().getColor(R.color.colorDivider));
            } else {
                ((ItemViewHolder) holder).row.setBackgroundColor(mContext.getResources().getColor(android.R.color.white));
            }
        }
    }

    @Override
    public int getItemCount() {
        return list.size() + 1;
    }

    @Override
    public int getItemViewType(int position) {
        if (isPosHeader(position)) {
            return TYPE_HEADER;
        }
        return TYPE_ITEM;
    }

    private boolean isPosHeader(int pos) {
        return pos == 0;
    }

    private CungMang getItem(int pos) {
        return list.get(pos);
    }

    class HeaderViewHolder extends RecyclerView.ViewHolder {

        public HeaderViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

    class ItemViewHolder extends RecyclerView.ViewHolder {

        TextView namSinh, amLich, gioiTinh, mang, cung, hanh;
        TableRow row;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            namSinh = itemView.findViewById(R.id.item_cungmang_namsinh_txt);
            amLich = itemView.findViewById(R.id.item_cungmang_amlich_txt);
            mang = itemView.findViewById(R.id.item_cungmang_mang_txt);
            cung = itemView.findViewById(R.id.item_cungmang_cung_txt);
            hanh = itemView.findViewById(R.id.item_cungmang_hanh_txt);
            row = itemView.findViewById(R.id.item_cungmang_row);
        }
    }
}
