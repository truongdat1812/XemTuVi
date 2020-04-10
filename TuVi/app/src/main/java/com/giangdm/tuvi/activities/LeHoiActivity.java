package com.giangdm.tuvi.activities;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.giangdm.tuvi.R;
import com.giangdm.tuvi.adapters.LeHoiAdapter;
import com.giangdm.tuvi.database.TuViManager2;

public class LeHoiActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String KEY_LE_HOI = "key_le_hoi";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_le_hoi);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(getString(R.string.le_hoi_vn));
        TextView textView = findViewById(R.id.le_hoi_txt);
        textView.setText(new TuViManager2(this).getLeHoiFollowId("1").getContent());

        RecyclerView recyclerView = findViewById(R.id.le_hoi_rcl_view);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        LeHoiAdapter adapter = new LeHoiAdapter(this, new TuViManager2(this).getLeHoi(), this);
        recyclerView.setAdapter(adapter);

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
            case R.id.nam_sinh_layout:
                Intent intent = new Intent(this, LeHoiDetailActivity.class);
                intent.putExtra(KEY_LE_HOI, new TuViManager2(this).getLeHoi().get(pos).getId()+"");
                startActivity(intent);
                Log.d("aaaa", "onClick: "+ new TuViManager2(this).getLeHoi().get(pos).getId());
                break;
            default:
                break;
        }
    }
}
