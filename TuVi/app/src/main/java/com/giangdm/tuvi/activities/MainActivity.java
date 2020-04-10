package com.giangdm.tuvi.activities;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import android.view.MenuItem;

import com.giangdm.tuvi.R;
import com.giangdm.tuvi.adapters.ConGiapAdapter;
import com.giangdm.tuvi.database.TuViManager;
import com.giangdm.tuvi.models.TuVi;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private RecyclerView rclView;
    private List<TuVi> list;
    public static final String KEY_CONGIAP = "key_congiap";
    public static final String KEY_CONGIAP_NAME = "key_congiap_name";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        TuViManager tuViManager  = new TuViManager(this);

        rclView = findViewById(R.id.main_rcl_view);
        RecyclerView.LayoutManager manager = new GridLayoutManager(this, 2);
        rclView.setLayoutManager(manager);
        ConGiapAdapter adapter = new ConGiapAdapter(this, getData(), this);
        rclView.setAdapter(adapter);


    }

    private List<TuVi> getData() {
        list = new ArrayList<>();
        list.add(new TuVi("1",getString(R.string.tuoi_ty), R.drawable.ti));
        list.add(new TuVi("2",getString(R.string.tuoi_suu), R.drawable.suu));
        list.add(new TuVi("3",getString(R.string.tuoi_dan), R.drawable.dan));
        list.add(new TuVi("4",getString(R.string.tuoi_mao), R.drawable.mao));
        list.add(new TuVi("5",getString(R.string.tuoi_thin), R.drawable.thin));
        list.add(new TuVi("6",getString(R.string.tuoi_ran), R.drawable.ran));
        list.add(new TuVi("7",getString(R.string.tuoi_ngo), R.drawable.ngo));
        list.add(new TuVi("8",getString(R.string.tuoi_mui), R.drawable.mui));
        list.add(new TuVi("9",getString(R.string.tuoi_than), R.drawable.than));
        list.add(new TuVi("10",getString(R.string.tuoi_dau), R.drawable.dau));
        list.add(new TuVi("11",getString(R.string.tuoi_tuat), R.drawable.tuat));
        list.add(new TuVi("12",getString(R.string.tuoi_hoi), R.drawable.hoi));
        return list;
    }

    @Override
    public void onClick(View v) {
        int position = (int)v.getTag();
        switch (v.getId()) {
            case R.id.item_congiap_layout:
                Intent intent = new Intent(this, NamSinhActivity.class);
                intent.putExtra(KEY_CONGIAP, list.get(position).getIdConGiap());
                intent.putExtra(KEY_CONGIAP_NAME, list.get(position).getNameConGiap());
                startActivity(intent);
                break;
            default:
                break;
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
