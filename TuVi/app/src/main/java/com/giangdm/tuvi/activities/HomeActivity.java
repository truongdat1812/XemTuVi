package com.giangdm.tuvi.activities;

import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import com.giangdm.tuvi.R;
import com.giangdm.tuvi.constants.Constant;
import com.giangdm.tuvi.database.TuViManager2;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.RequestConfiguration;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import android.os.Handler;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.util.Arrays;
import java.util.List;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {

    private LinearLayout mTuvi, mBangCungMang, mBoiPhuongDong,
            mBoiPhuongTay, mNgayNghiLe, mLeHoiLon, mDanhNgon;

    private AdView mAdView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        StartAppSDK.init(this, "Your App ID", true);

        setContentView(R.layout.activity_home);

//        LinearLayout linearLayout = findViewById(R.id.layout_home);
//        Bitmap bg = BitmapFactory.decodeResource(getResources(), R.drawable.bg_home);
//        BitmapDrawable bitmapDrawable = new BitmapDrawable(getResources(), bg);
//        bitmapDrawable.setTileModeXY(Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
//        linearLayout.setBackground(bitmapDrawable);

        TuViManager2 tuViManager2 = new TuViManager2(this);

        mTuvi = findViewById(R.id.home_tu_vi_tron_doi_layout);
        mBangCungMang = findViewById(R.id.home_bang_cung_mang_layout);
        mBoiPhuongDong = findViewById(R.id.home_boi_phuong_dong_layout);
        mBoiPhuongTay = findViewById(R.id.home_boi_phuong_tay_layout);
        mNgayNghiLe = findViewById(R.id.home_ngay__nghi_le_layout);
        mLeHoiLon = findViewById(R.id.home_le_hoi_layout);
        mDanhNgon = findViewById(R.id.home_danh_ngon_layout);

        mTuvi.setOnClickListener(this);
        mBangCungMang.setOnClickListener(this);
        mBoiPhuongDong.setOnClickListener(this);
        mBoiPhuongTay.setOnClickListener(this);
        mNgayNghiLe.setOnClickListener(this);
        mLeHoiLon.setOnClickListener(this);
        mDanhNgon.setOnClickListener(this);

        mAdView = findViewById(R.id.adView);
        mAdView.setBackgroundColor(Color.WHITE);

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                //do something
                MobileAds.initialize(HomeActivity.this, new OnInitializationCompleteListener() {
                    @Override
                    public void onInitializationComplete(InitializationStatus initializationStatus) {
                        Log.d("DATTRUONG" , "onInitializationComplete");


                        AdRequest adRequest = new AdRequest.Builder().build();
                        mAdView.loadAd(adRequest);

                        mAdView.setAdListener(new AdListener() {
                            @Override
                            public void onAdLoaded() {
                                // Code to be executed when an ad finishes loading.
                                Log.d("DATTRUONG" , "onAdLoaded");
                            }

                            @Override
                            public void onAdFailedToLoad(int errorCode) {
                                // Code to be executed when an ad request fails.
                                Log.d("DATTRUONG" , "onAdFailedToLoad " + errorCode);
                            }

                            @Override
                            public void onAdOpened() {
                                // Code to be executed when an ad opens an overlay that
                                // covers the screen.
                                Log.d("DATTRUONG" , "onAdOpened");
                            }

                            @Override
                            public void onAdClicked() {
                                // Code to be executed when the user clicks on an ad.
                                Log.d("DATTRUONG" , "onAdClicked");
                            }

                            @Override
                            public void onAdLeftApplication() {
                                // Code to be executed when the user has left the app.
                                Log.d("DATTRUONG" , "onAdLeftApplication");
                            }

                            @Override
                            public void onAdClosed() {
                                Log.d("DATTRUONG" , "onAdClosed");
                                // Code to be executed when the user is about to return
                                // to the app after tapping on an ad.
                            }
                        });

                    }
                });
            }
        }, 2000 );//time in milisecond

    }

    @Override
    public void onClick(View v) {
        Intent intent;
        long now = System.currentTimeMillis();
        if (new Constant().isOverThreashold(now)) {
            switch (v.getId()) {
                case R.id.home_tu_vi_tron_doi_layout:
                    intent = new Intent(this, MainActivity.class);
                    startActivity(intent);
                    break;
                case R.id.home_bang_cung_mang_layout:
                    intent = new Intent(this, CungMangActivity.class);
                    startActivity(intent);
                    break;
                case R.id.home_boi_phuong_dong_layout:
                    intent = new Intent(this, PhuongDongActivity.class);
                    startActivity(intent);
                    break;
                case R.id.home_boi_phuong_tay_layout:
                    intent = new Intent(this, PhuongTayActivity.class);
                    startActivity(intent);
                    break;
                case R.id.home_ngay__nghi_le_layout:
                    intent = new Intent(this, NgayLeActivity.class);
                    startActivity(intent);
                    break;
                case R.id.home_le_hoi_layout:
                    intent = new Intent(this, LeHoiActivity.class);
                    startActivity(intent);
                    break;
                case R.id.home_danh_ngon_layout:
                    intent = new Intent(this, DanhNgonActivity.class);
                    startActivity(intent);
                    break;
                default:
                    break;
            }
        }
        new Constant().timestamp = now;
    }
}
