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
        Spinner nat_of_work_spinner = (Spinner) root.findViewById(R.id.govt_ben_spinner);
        ArrayAdapter<CharSequence> nat_of_work_adapter = ArrayAdapter.createFromResource(getContext(), R.array.gvbenefits_array, android.R.layout.simple_spinner_item);
        nat_of_work_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        nat_of_work_spinner.setAdapter(nat_of_work_adapter);
        Spinner info_spinner = (Spinner) root.findViewById(R.id.covid_know_spinner);
        ArrayAdapter<CharSequence> info_adapter = ArrayAdapter.createFromResource(getContext(), R.array.source_info_array, android.R.layout.simple_spinner_item);
        info_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        info_spinner.setAdapter(info_adapter);
        Spinner lcdn_spinner = (Spinner) root.findViewById(R.id.lockdown_know_spinner);
        ArrayAdapter<CharSequence> lcdn_adapter = ArrayAdapter.createFromResource(getContext(), R.array.when_lcdn_array, android.R.layout.simple_spinner_item);
        lcdn_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        lcdn_spinner.setAdapter(lcdn_adapter);
        Spinner resp_spinner = (Spinner) root.findViewById(R.id.employer_response_spinner);
        ArrayAdapter<CharSequence> resp_adapter = ArrayAdapter.createFromResource(getContext(), R.array.resp_array, android.R.layout.simple_spinner_item);
        resp_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        resp_spinner.setAdapter(resp_adapter);
        Spinner loc_spinner = (Spinner) root.findViewById(R.id.where_spinner);
        ArrayAdapter<CharSequence> loc_adapter = ArrayAdapter.createFromResource(getContext(), R.array.loc_array, android.R.layout.simple_spinner_item);
        loc_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        loc_spinner.setAdapter(loc_adapter);
        Spinner sprt_spinner = (Spinner) root.findViewById(R.id.support_received_spinner);
        ArrayAdapter<CharSequence> sprt_adapter = ArrayAdapter.createFromResource(getContext(), R.array.sprt_array, android.R.layout.simple_spinner_item);
        sprt_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sprt_spinner.setAdapter(sprt_adapter);
        Spinner need_spinner = (Spinner) root.findViewById(R.id.support_needed_spinner);
        ArrayAdapter<CharSequence> need_adapter = ArrayAdapter.createFromResource(getContext(), R.array.need_array, android.R.layout.simple_spinner_item);
        need_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        need_spinner.setAdapter(need_adapter);
        Spinner assm_spinner = (Spinner) root.findViewById(R.id.self_assessment_spinner);
        ArrayAdapter<CharSequence> assm_adapter = ArrayAdapter.createFromResource(getContext(), R.array.assmnt_array, android.R.layout.simple_spinner_item);
        assm_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        assm_spinner.setAdapter(assm_adapter);
        Spinner where_spinner = (Spinner) root.findViewById(R.id.support_spinner);
        ArrayAdapter<CharSequence> where_adapter = ArrayAdapter.createFromResource(getContext(), R.array.wheretogo_array, android.R.layout.simple_spinner_item);
        where_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        where_spinner.setAdapter(where_adapter);


        return root;
    }
}
