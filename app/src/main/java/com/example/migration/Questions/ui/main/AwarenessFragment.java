package com.example.migration.Questions.ui.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.migration.R;

public class AwarenessFragment extends Fragment {
    private static final String ARG_SECTION_NUMBER = "section_number";


    public static AwarenessFragment newInstance(int index) {
        AwarenessFragment fragment = new AwarenessFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(ARG_SECTION_NUMBER, index);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_awareness, container, false);

        return root;
    }
}
