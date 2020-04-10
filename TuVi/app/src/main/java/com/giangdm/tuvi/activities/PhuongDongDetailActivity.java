package com.giangdm.tuvi.activities;

import android.content.Intent;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.giangdm.tuvi.R;
import com.giangdm.tuvi.database.TuViManager2;

public class PhuongDongDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phuong_dong_detail);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle(getString(R.string.boi_phuong_dong));

        Intent intent = getIntent();
        String id = intent.getStringExtra(PhuongDongActivity.KEY_CONGIAP);
        TextView textView = findViewById(R.id.pd_detail_txt);
        textView.setText(new TuViManager2(this).getBoiPhuongDong(id).getContent());


        ImageView img = findViewById(R.id.pd_detail_img);
        switch (id) {
            case "13":
                img.setImageDrawable(getResources().getDrawable(R.drawable.ti));
                break;
            case "14":
                img.setImageDrawable(getResources().getDrawable(R.drawable.suu));
                break;
            case "15":
                img.setImageDrawable(getResources().getDrawable(R.drawable.dan));
                break;
            case "16":
                img.setImageDrawable(getResources().getDrawable(R.drawable.mao));
                break;
            case "17":
                img.setImageDrawable(getResources().getDrawable(R.drawable.thin));
                break;
            case "18":
                img.setImageDrawable(getResources().getDrawable(R.drawable.ran));
                break;
            case "19":
                img.setImageDrawable(getResources().getDrawable(R.drawable.ngo));
                break;
            case "20":
                img.setImageDrawable(getResources().getDrawable(R.drawable.mui));
                break;
            case "21":
                img.setImageDrawable(getResources().getDrawable(R.drawable.than));
                break;
            case "22":
                img.setImageDrawable(getResources().getDrawable(R.drawable.dau));
                break;
            case "23":
                img.setImageDrawable(getResources().getDrawable(R.drawable.tuat));
                break;
            case "24":
                img.setImageDrawable(getResources().getDrawable(R.drawable.hoi));
                break;
            default:
                img.setVisibility(View.GONE);
                break;
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (android.R.id.home == item.getItemId()) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }
}
