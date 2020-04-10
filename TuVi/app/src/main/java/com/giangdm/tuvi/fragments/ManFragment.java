package com.giangdm.tuvi.fragments;


import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.appcompat.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.giangdm.tuvi.R;
import com.giangdm.tuvi.activities.NamSinhActivity;
import com.giangdm.tuvi.database.TuViManager;

/**
 * A simple {@link Fragment} subclass.
 */
public class ManFragment extends Fragment {

    private TextView contentTxt;
    private TuViManager tuViManager;


    public ManFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        tuViManager = new TuViManager(getContext());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_man, container, false);
        contentTxt = view.findViewById(R.id.man_content_txt);

        Intent intent = getActivity().getIntent();
        String tuoiId = intent.getStringExtra(NamSinhActivity.KEY_TUOI_ID);

        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle(tuViManager.getTuVi(tuoiId,"1").getTdName());

        contentTxt.setText(tuViManager.getTuVi(tuoiId, "1").getIntro());

        return view;
    }

}
