package com.giangdm.tuvi.activities;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import com.giangdm.tuvi.R;
import com.giangdm.tuvi.database.TuViManager2;

public class LeHoiDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_le_hoi_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(getString(R.string.le_hoi_vn));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();
        String id = intent.getStringExtra(LeHoiActivity.KEY_LE_HOI);

        TextView title = findViewById(R.id.le_hoi_detail_title_txt);
        TextView content = findViewById(R.id.le_hoi_detail_content_txt);
        TuViManager2 manager2 = new TuViManager2(this);
        title.setText(manager2.getLeHoiFollowId(id).getTitle());
        content.setText(manager2.getLeHoiFollowId(id).getContent());

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
