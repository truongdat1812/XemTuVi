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
import com.giangdm.tuvi.adapters.PhuongTayAdapter;
import com.giangdm.tuvi.models.PhuongTay;

import java.util.ArrayList;
import java.util.List;

public class PhuongTayActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String KEY_PHUONG_TAY = "key_phuong_tay";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phuong_tay);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(getString(R.string.boi_phuong_tay));
        actionBar.setDisplayHomeAsUpEnabled(true);

        RecyclerView rclView = findViewById(R.id.pt_rcl_view);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        rclView.setLayoutManager(manager);
        PhuongTayAdapter adapter = new PhuongTayAdapter(this, getData(), this);
        rclView.setAdapter(adapter);

    }

    private List<PhuongTay> getData() {
        List<PhuongTay> list = new ArrayList<>();
        list.add(new PhuongTay(1, R.drawable.aries, getString(R.string.aries)));
        list.add(new PhuongTay(2, R.drawable.taurus, getString(R.string.taurus)));
        list.add(new PhuongTay(3, R.drawable.gemini, getString(R.string.gemini)));
        list.add(new PhuongTay(4, R.drawable.cancer, getString(R.string.cancer)));
        list.add(new PhuongTay(5, R.drawable.leo, getString(R.string.leo)));
        list.add(new PhuongTay(6, R.drawable.virgo, getString(R.string.virgo)));
        list.add(new PhuongTay(7, R.drawable.libra, getString(R.string.libra)));
        list.add(new PhuongTay(8, R.drawable.scorpio, getString(R.string.scorpius)));
        list.add(new PhuongTay(9, R.drawable.sagittarius, getString(R.string.sagittarius)));
        list.add(new PhuongTay(10, R.drawable.capricorn, getString(R.string.capricorn)));
        list.add(new PhuongTay(11, R.drawable.aquarius, getString(R.string.aquarius)));
        list.add(new PhuongTay(12, R.drawable.pisces, getString(R.string.pisces)));
        return list;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        int pos = (int) v.getTag();
        switch (v.getId()) {
            case R.id.pt_layout:
                Intent intent = new Intent(this, PhuongTayDetailActivity.class);
                intent.putExtra(KEY_PHUONG_TAY, getData().get(pos).getId()+"");
                startActivity(intent);
                break;
            default:
                break;
        }
    }
}
