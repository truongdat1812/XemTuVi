package com.giangdm.tuvi.activities;

import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.Toolbar;
import android.view.MenuItem;

import com.giangdm.tuvi.R;
import com.giangdm.tuvi.adapters.DanhNgonAdapter;
import com.giangdm.tuvi.database.TuViManager2;
import com.giangdm.tuvi.interfaces.OnLoadMoreListener;
import com.giangdm.tuvi.models.DanhNgon;

import java.util.ArrayList;
import java.util.List;

public class DanhNgonActivity extends AppCompatActivity {

    List<DanhNgon> danhNgonList = new ArrayList<>();
    private Handler mHandler = new Handler();
    List<DanhNgon> ngonList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danh_ngon);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(getString(R.string.danh_ngon));


        danhNgonList = new TuViManager2(this).getDanhNgon();
        RecyclerView rclView = findViewById(R.id.danh_ngon_rcl_view);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        rclView.setLayoutManager(manager);
        rclView.setHasFixedSize(true);
        loadData(0, 100);
        final DanhNgonAdapter adapter = new DanhNgonAdapter(this, ngonList, rclView);
        rclView.setAdapter(adapter);

        adapter.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore() {
                if (ngonList.size() <= danhNgonList.size()) {
                    ngonList.add(null);
                    adapter.notifyItemInserted(ngonList.size() - 1);
                    mHandler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            ngonList.remove(ngonList.size() - 1);
                            adapter.notifyItemRemoved(ngonList.size());
                            int start = ngonList.size();
                            int end = start + 100;
                            loadData(start, end);

                            adapter.setLoaded();
                        }
                    }, 1000);
                } else {
                    adapter.setLoaded();
                }
            }
        });
    }

    private void loadData(int start, int end) {
        for (int i = start; i < end; i++) {
            ngonList.add(new DanhNgon(danhNgonList.get(i).getId(),
                    danhNgonList.get(i).getContent(), danhNgonList.get(i).getAuthor()));
        }

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();

        }
        return super.onOptionsItemSelected(item);
    }
}
