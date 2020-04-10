package com.giangdm.tuvi.activities;

import android.content.Intent;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.giangdm.tuvi.R;
import com.giangdm.tuvi.adapters.NamSinhAdapter;
import com.giangdm.tuvi.database.TuViManager;

public class NamSinhActivity extends AppCompatActivity implements View.OnClickListener {

    private TuViManager tuViManager;
    private String id;

    public static final String KEY_TUOI_ID = "key_tuoi_id";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("DatTruong", "Namsinh -> Oncreate 1");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nam_sinh);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        Log.d("DatTruong", "Namsinh -> Oncreate 2");
        tuViManager = new TuViManager(this);
        Intent intent = getIntent();
        id = intent.getStringExtra(MainActivity.KEY_CONGIAP);
        String title = intent.getStringExtra(MainActivity.KEY_CONGIAP_NAME);
        actionBar.setTitle("Tử Vi " + title);

        Log.d("DatTruong", "Namsinh -> Oncreate 3");
        RecyclerView rclView = findViewById(R.id.rcl_view);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(this);
        rclView.setLayoutManager(manager);
        Log.d("DatTruong", "Namsinh -> Oncreate 4");
        NamSinhAdapter adapter = new NamSinhAdapter(this, tuViManager.getNamSinh(id), this);
        rclView.setAdapter(adapter);

        Log.d("DatTruong", "Namsinh -> Oncreate 5");
    }

    @Override
    public void onClick(View v) {

        int pos = (int) v.getTag();
        switch (v.getId()) {
            case R.id.nam_sinh_layout:
                Intent intent = new Intent(this, DetailActivity.class);
                intent.putExtra(KEY_TUOI_ID, tuViManager.getNamSinh(id).get(pos).getIdTuoi());
                startActivity(intent);
                break;
            default:
                break;
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        return super.onCreateOptionsMenu(menu);
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
}
