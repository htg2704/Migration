package com.example.migration.Questions.ui.main;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.migration.Database.AwarenessDB;
import com.example.migration.Database.MigrationDB;
import com.example.migration.R;

import static android.content.ContentValues.TAG;

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

        final AwarenessDB awarenessDB = new AwarenessDB(getActivity().getApplicationContext());

        View root = inflater.inflate(R.layout.fragment_awareness, container, false);
        final Spinner govt_benefit = (Spinner) root.findViewById(R.id.govt_ben_spinner);
        final ArrayAdapter<CharSequence> govt_benefit_adapter = ArrayAdapter.createFromResource(getContext(), R.array.gvbenefits_array, android.R.layout.simple_spinner_item);
        govt_benefit_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        govt_benefit.setAdapter(govt_benefit_adapter);
        final Spinner info_spinner = (Spinner) root.findViewById(R.id.covid_know_spinner);
        ArrayAdapter<CharSequence> info_adapter = ArrayAdapter.createFromResource(getContext(), R.array.source_info_array, android.R.layout.simple_spinner_item);
        info_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        info_spinner.setAdapter(info_adapter);
        final Spinner lcdn_spinner = (Spinner) root.findViewById(R.id.lockdown_know_spinner);
        ArrayAdapter<CharSequence> lcdn_adapter = ArrayAdapter.createFromResource(getContext(), R.array.when_lcdn_array, android.R.layout.simple_spinner_item);
        lcdn_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        lcdn_spinner.setAdapter(lcdn_adapter);
        final Spinner resp_spinner = (Spinner) root.findViewById(R.id.employer_response_spinner);
        ArrayAdapter<CharSequence> resp_adapter = ArrayAdapter.createFromResource(getContext(), R.array.resp_array, android.R.layout.simple_spinner_item);
        resp_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        resp_spinner.setAdapter(resp_adapter);
        final Spinner loc_spinner = (Spinner) root.findViewById(R.id.where_spinner);
        ArrayAdapter<CharSequence> loc_adapter = ArrayAdapter.createFromResource(getContext(), R.array.loc_array, android.R.layout.simple_spinner_item);
        loc_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        loc_spinner.setAdapter(loc_adapter);
        final Spinner sprt_spinner = (Spinner) root.findViewById(R.id.support_received_spinner);
        ArrayAdapter<CharSequence> sprt_adapter = ArrayAdapter.createFromResource(getContext(), R.array.sprt_array, android.R.layout.simple_spinner_item);
        sprt_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sprt_spinner.setAdapter(sprt_adapter);
        final Spinner need_spinner = (Spinner) root.findViewById(R.id.support_needed_spinner);
        ArrayAdapter<CharSequence> need_adapter = ArrayAdapter.createFromResource(getContext(), R.array.need_array, android.R.layout.simple_spinner_item);
        need_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        need_spinner.setAdapter(need_adapter);
        final Spinner assm_spinner = (Spinner) root.findViewById(R.id.self_assessment_spinner);
        ArrayAdapter<CharSequence> assm_adapter = ArrayAdapter.createFromResource(getContext(), R.array.assmnt_array, android.R.layout.simple_spinner_item);
        assm_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        assm_spinner.setAdapter(assm_adapter);
        final Spinner where_spinner = (Spinner) root.findViewById(R.id.support_spinner);
        ArrayAdapter<CharSequence> where_adapter = ArrayAdapter.createFromResource(getContext(), R.array.wheretogo_array, android.R.layout.simple_spinner_item);
        where_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        where_spinner.setAdapter(where_adapter);

        Button save = root.findViewById(R.id.save_awareness);


        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String govt_ben,covid_know,lock_know,support_rec,support_needed,response,current_loc,reach,covid_self;

                govt_ben = govt_benefit.getSelectedItem().toString();
                covid_know = info_spinner.getSelectedItem().toString();
                lock_know = lcdn_spinner.getSelectedItem().toString();
                response = resp_spinner.getSelectedItem().toString();
                current_loc = loc_spinner.getSelectedItem().toString();
                support_rec = sprt_spinner.getSelectedItem().toString();
                support_needed = need_spinner.getSelectedItem().toString();
                covid_self = assm_spinner.getSelectedItem().toString();
                reach = where_spinner.getSelectedItem().toString();
                Log.d(TAG, "city " + govt_ben);
                awarenessDB.addData(govt_ben,covid_know,lock_know,response,current_loc,support_rec,support_needed,covid_self,reach);

            }
        });
        return root;
    }
}
