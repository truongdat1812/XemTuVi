package com.giangdm.tuvi.activities;

import android.content.Intent;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.giangdm.tuvi.R;
import com.giangdm.tuvi.database.TuViManager2;

public class PhuongTayDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phuong_tay_detail);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle(getString(R.string.boi_phuong_tay));

        Intent intent = getIntent();
        String id = intent.getStringExtra(PhuongTayActivity.KEY_PHUONG_TAY);
        TextView textView = findViewById(R.id.pt_detail_txt);
        textView.setText(new TuViManager2(this).getBoiPhuongTay(id).getContent());

        ImageView img = findViewById(R.id.pt_detail_img);
        switch (id) {
            case "1":
                img.setImageDrawable(getResources().getDrawable(R.drawable.aries));
                break;
            case "2":
                img.setImageDrawable(getResources().getDrawable(R.drawable.taurus));
                break;
            case "3":
                img.setImageDrawable(getResources().getDrawable(R.drawable.gemini));
                break;
            case "4":
                img.setImageDrawable(getResources().getDrawable(R.drawable.cancer));
                break;
            case "5":
                img.setImageDrawable(getResources().getDrawable(R.drawable.leo));
                break;
            case "6":
                img.setImageDrawable(getResources().getDrawable(R.drawable.virgo));
                break;
            case "7":
                img.setImageDrawable(getResources().getDrawable(R.drawable.libra));
                break;
            case "8":
                img.setImageDrawable(getResources().getDrawable(R.drawable.scorpio));
                break;
            case "9":
                img.setImageDrawable(getResources().getDrawable(R.drawable.sagittarius));
                break;
            case "10":
                img.setImageDrawable(getResources().getDrawable(R.drawable.capricorn));
                break;
            case "11":
                img.setImageDrawable(getResources().getDrawable(R.drawable.aquarius));
                break;
            case "12":
                img.setImageDrawable(getResources().getDrawable(R.drawable.pisces));
                break;
            default:
                break;
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
