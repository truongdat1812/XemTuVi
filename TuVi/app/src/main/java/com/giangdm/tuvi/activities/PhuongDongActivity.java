package com.giangdm.tuvi.activities;

import android.content.Intent;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;

import com.giangdm.tuvi.R;
import com.giangdm.tuvi.adapters.NamSinhAdapter;
import com.giangdm.tuvi.models.TuVi;

import java.util.ArrayList;
import java.util.List;

public class PhuongDongActivity extends AppCompatActivity implements View.OnClickListener {


    public static final String KEY_CONGIAP = "key_con_giap_pd";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phuong_dong);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(getString(R.string.boi_phuong_dong));
        actionBar.setDisplayHomeAsUpEnabled(true);

        RecyclerView rclView = findViewById(R.id.phuong_dong_rcl_view);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        rclView.setLayoutManager(manager);
        NamSinhAdapter adapter = new NamSinhAdapter(this, getData(), this);
        rclView.setAdapter(adapter);
    }

    private List<TuVi> getData() {
        List<TuVi> list = new ArrayList<>();
        list.add(new TuVi("13", getString(R.string.tuoi_ty)));
        list.add(new TuVi("14", getString(R.string.tuoi_suu)));
        list.add(new TuVi("15", getString(R.string.tuoi_dan)));
        list.add(new TuVi("16", getString(R.string.tuoi_mao)));
        list.add(new TuVi("17", getString(R.string.tuoi_thin)));
        list.add(new TuVi("18", getString(R.string.tuoi_ran)));
        list.add(new TuVi("19", getString(R.string.tuoi_ngo)));
        list.add(new TuVi("20", getString(R.string.tuoi_mui)));
        list.add(new TuVi("21", getString(R.string.tuoi_than)));
        list.add(new TuVi("22", getString(R.string.tuoi_dau)));
        list.add(new TuVi("23", getString(R.string.tuoi_tuat)));
        list.add(new TuVi("24", getString(R.string.tuoi_hoi)));
        return list;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        int pos = (int) v.getTag();
        switch (v.getId()) {
            case R.id.nam_sinh_layout:
                Intent intent = new Intent(this, PhuongDongDetailActivity.class);
                intent.putExtra(KEY_CONGIAP, getData().get(pos).getIdTuoi());
                startActivity(intent);
                break;
            default:
                break;
        }
    }
}
