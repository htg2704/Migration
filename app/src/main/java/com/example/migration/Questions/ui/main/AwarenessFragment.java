package com.example.migration.Questions.ui.main;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.migration.Database.AwarenessDB;
import com.example.migration.Questions.questions;
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

        final View root = inflater.inflate(R.layout.fragment_awareness, container, false);
        final CheckBox c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11;
        c1 = root.findViewById(R.id.c1);
        c2 = root.findViewById(R.id.c2);
        c3 = root.findViewById(R.id.c3);
        c4 = root.findViewById(R.id.c4);
        c5 = root.findViewById(R.id.c5);
        c6 = root.findViewById(R.id.c6);
        c7 = root.findViewById(R.id.c7);
        c8 = root.findViewById(R.id.c8);
        c9 = root.findViewById(R.id.c9);
        c10 = root.findViewById(R.id.c10);
        c11 = root.findViewById(R.id.c11);
        if(c6.isChecked()){
            c1.setChecked(false);
            c2.setChecked(false);
            c3.setChecked(false);
            c4.setChecked(false);
            c5.setChecked(false);
        }
        if(c11.isChecked()){
            c7.setChecked(false);
            c8.setChecked(false);
            c9.setChecked(false);
            c10.setChecked(false);
        }



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
        final Spinner assm_spinner = (Spinner) root.findViewById(R.id.self_assessment_spinner);
        ArrayAdapter<CharSequence> assm_adapter = ArrayAdapter.createFromResource(getContext(), R.array.assmnt_array, android.R.layout.simple_spinner_item);
        assm_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        assm_spinner.setAdapter(assm_adapter);
        final Spinner where_spinner = (Spinner) root.findViewById(R.id.support_spinner);
        ArrayAdapter<CharSequence> where_adapter = ArrayAdapter.createFromResource(getContext(), R.array.wheretogo_array, android.R.layout.simple_spinner_item);
        where_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        where_spinner.setAdapter(where_adapter);

        final Button save = root.findViewById(R.id.save_awareness);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String s1,s2,s3,s4,s5,s6;
                String s7,s8,s9,s10,s11;

                String govt_ben,covid_know,lock_know,support_rec,support_needed,response,current_loc,reach,covid_self;
                if(c1.isChecked()){
                    s1 = c1.getText().toString() + ", ";
                }
                else{
                    s1 = "";
                }
                if(c2.isChecked()){
                    s2 = c2.getText().toString() + ", ";
                }
                else{
                    s2 = "";
                }
                if(c3.isChecked()){
                    s3 = c3.getText().toString() + ", ";
                }
                else{
                    s3 = "";
                }
                if(c4.isChecked()){
                    s4 = c4.getText().toString() + ", ";
                }
                else{
                    s4 = "";
                }
                if(c5.isChecked()){
                    s5 = c5.getText().toString() + ", ";
                }
                else{
                    s5 = "";
                }
                if(c6.isChecked()){
                    s6 = c6.getText().toString() + ", ";
                }
                else{
                    s6 = "";
                }
                govt_ben = s1 + s2 + s3 + s4 +s5 +s6;
                covid_know = info_spinner.getSelectedItem().toString();
                lock_know = lcdn_spinner.getSelectedItem().toString();
                response = resp_spinner.getSelectedItem().toString();
                current_loc = loc_spinner.getSelectedItem().toString();
                support_rec = sprt_spinner.getSelectedItem().toString();
                if(c7.isChecked()){
                    s7 = c7.getText().toString() + ", ";
                }
                else{
                    s7 = "";
                }
                if(c8.isChecked()){
                    s8 = c8.getText().toString() + ", ";
                }
                else{
                    s8 = "";
                }
                if(c9.isChecked()){
                    s9 = c9.getText().toString() + ", ";
                }
                else{
                    s9 = "";
                }
                if(c10.isChecked()){
                    s10 = c10.getText().toString() + ", ";
                }
                else{
                    s10 = "";
                }
                if(c11.isChecked()){
                    s11 = c11.getText().toString() + ", ";
                }
                else{
                    s11 = "";
                }
                support_needed = s7 + s8 + s9 + s10 + s11;
                covid_self = assm_spinner.getSelectedItem().toString();
                reach = where_spinner.getSelectedItem().toString();
                Log.d(TAG, "city " + govt_ben);
                awarenessDB.addData(govt_ben,covid_know,lock_know,response,current_loc,support_rec,support_needed,covid_self,reach);

                Toast.makeText(getActivity(),"Awareness Data added successfully",Toast.LENGTH_SHORT).show();
                save.setClickable(false);
                ((questions)getActivity()).selectTab(3);

            }
        });
        return root;
    }
}
