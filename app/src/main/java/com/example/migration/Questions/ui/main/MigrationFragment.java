package com.example.migration.Questions.ui.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;

import com.example.migration.R;


public class MigrationFragment extends Fragment {
    private static final String ARG_SECTION_NUMBER = "section_number";


    public static MigrationFragment newInstance(int index) {
        MigrationFragment fragment = new MigrationFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(ARG_SECTION_NUMBER, index);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_migration, container, false);
        Spinner work_spinner = (Spinner) root.findViewById(R.id.nature_of_work_spinner);
        ArrayAdapter<CharSequence> work_adapter = ArrayAdapter.createFromResource(getContext(), R.array.work_array, android.R.layout.simple_spinner_item);
        work_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        work_spinner.setAdapter(work_adapter);
        Spinner l_spinner = (Spinner) root.findViewById(R.id.location_spinner);
        ArrayAdapter<CharSequence> l_adapter = ArrayAdapter.createFromResource(getContext(), R.array.india_cities, android.R.layout.simple_spinner_item);
        l_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        l_spinner.setAdapter(l_adapter);
        Spinner period_spinner = (Spinner) root.findViewById(R.id.period_spinner);
        ArrayAdapter<CharSequence> period_adapter = ArrayAdapter.createFromResource(getContext(), R.array.work_duration_array, android.R.layout.simple_spinner_item);
        period_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        period_spinner.setAdapter(period_adapter);
        Spinner wage_spinner = (Spinner) root.findViewById(R.id.wage_spinner);
        ArrayAdapter<CharSequence> wage_adapter = ArrayAdapter.createFromResource(getContext(), R.array.day_wage_array, android.R.layout.simple_spinner_item);
        wage_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        wage_spinner.setAdapter(wage_adapter);
        Spinner benefit_spinner = (Spinner) root.findViewById(R.id.other_benefit_spinner);
        ArrayAdapter<CharSequence> benefit_adapter = ArrayAdapter.createFromResource(getContext(), R.array.benefits_array, android.R.layout.simple_spinner_item);
        benefit_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        benefit_spinner.setAdapter(benefit_adapter);
        Spinner challenge_spinner = (Spinner) root.findViewById(R.id.challenge_spinner);
        ArrayAdapter<CharSequence> challenge_adapter = ArrayAdapter.createFromResource(getContext(), R.array.challenges_array, android.R.layout.simple_spinner_item);
        challenge_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        challenge_spinner.setAdapter(challenge_adapter);
        EditText employer,employer_contact;
        employer = (EditText) root.findViewById(R.id.employer_name);
        employer_contact = (EditText) root.findViewById(R.id.employer_CON_NO);
        return root;
    }
}
