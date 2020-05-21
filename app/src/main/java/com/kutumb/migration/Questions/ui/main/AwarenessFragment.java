package com.kutumb.migration.Questions.ui.main;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.kutumb.migration.Database.AwarenessDB;
import com.kutumb.migration.Questions.questions;
import com.kutumb.migration.R;

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
        final CheckBox c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12,c13,c14,c15,c16,c17,c18,c19,c20,c21;
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
        c12 = root.findViewById(R.id.c12);
        c13 = root.findViewById(R.id.c13);
        c14 = root.findViewById(R.id.c14);
        c15 = root.findViewById(R.id.c15);
        c16 = root.findViewById(R.id.c16);
        c17 = root.findViewById(R.id.c17);
        c18 = root.findViewById(R.id.c18);
        c19 = root.findViewById(R.id.c19);
        c20 = root.findViewById(R.id.c20);
        c21 = root.findViewById(R.id.c21);


        if(c21.isChecked()){
            c1.setChecked(false);
            c2.setChecked(false);
            c3.setChecked(false);
            c4.setChecked(false);
            c5.setChecked(false);
            c6.setChecked(false);
            c20.setChecked(false);
        }
        if(c19.isChecked()){
            c7.setChecked(false);
            c8.setChecked(false);
            c9.setChecked(false);
            c10.setChecked(false);
            c11.setChecked(false);
            c12.setChecked(false);
            c13.setChecked(false);
            c14.setChecked(false);
            c15.setChecked(false);
            c16.setChecked(false);
            c17.setChecked(false);
            c18.setChecked(false);

        }



        final Spinner info_spinner = (Spinner) root.findViewById(R.id.covid_know_spinner);
        ArrayAdapter<CharSequence> info_adapter = ArrayAdapter.createFromResource(getContext(), R.array.source_info_array, android.R.layout.simple_spinner_item);
        info_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        info_spinner.setAdapter(info_adapter);
        final Spinner lcdn_spinner = (Spinner) root.findViewById(R.id.lockdown_know_spinner);
        ArrayAdapter<CharSequence> lcdn_adapter = ArrayAdapter.createFromResource(getContext(), R.array.when_lcdn_array, android.R.layout.simple_spinner_item);
        lcdn_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        lcdn_spinner.setAdapter(lcdn_adapter);
        final Spinner assm_spinner = (Spinner) root.findViewById(R.id.self_assessment_spinner);
        ArrayAdapter<CharSequence> assm_adapter = ArrayAdapter.createFromResource(getContext(), R.array.assmnt_array, android.R.layout.simple_spinner_item);
        assm_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        assm_spinner.setAdapter(assm_adapter);

        final Button save = root.findViewById(R.id.save_awareness);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String s1,s2,s3,s4,s5,s6,s20,s21;
                String s7,s8,s9,s10,s11,s12,s13,s14,s15,s16,s17,s18,s19;
                EditText schema,otherproblem,suggestion,othersupportreceive,othersupportneed;

                schema = root.findViewById(R.id.schema);
                String schema_str=schema.getText().toString();

                otherproblem = root.findViewById(R.id.otherproblem);
                String otherproblem_str =otherproblem.getText().toString();

                suggestion = root.findViewById(R.id.suggestion);
                String suggestion_str =suggestion.getText().toString();

                othersupportreceive = root.findViewById(R.id.othersupportreceive);
                String othersupportreceive_str =othersupportreceive.getText().toString();


                if(schema_str.isEmpty())
                {
                    schema.setError("This can't be empty");
                    schema.requestFocus();
                }
                if(suggestion_str.isEmpty())
                {
                    suggestion.setError("This can't be empty");
                    suggestion.requestFocus();
                }
                if(otherproblem_str.isEmpty())
                {
                    otherproblem.setError("This can't be empty");
                    otherproblem.requestFocus();
                }
                if(othersupportreceive_str.isEmpty())
                {
                    othersupportreceive.setError("This can't be empty");
                    othersupportreceive.requestFocus();
                }

                String govt_ben,covid_know,lock_know,support_needed,covid_self;

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
                }if(c20.isChecked()){
                    s20 = c20.getText().toString() + ", ";
                }
                else{
                    s20 = "";
                }if(c21.isChecked()){
                    s21 = c21.getText().toString() + ", ";
                }
                else{
                    s21 = "";
                }
                govt_ben = s1 + s2 + s3 + s4 +s5 +s6 +s20 +s21;
                covid_know = info_spinner.getSelectedItem().toString();
                lock_know = lcdn_spinner.getSelectedItem().toString();

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
                if(c12.isChecked()){
                    s12 = c12.getText().toString() + ", ";
                }
                else{
                    s12 = "";
                }
                if(c13.isChecked()){
                    s13 = c13.getText().toString() + ", ";
                }
                else{
                    s13 = "";
                }
                if(c14.isChecked()){
                    s14 = c14.getText().toString() + ", ";
                }
                else{
                    s14 = "";
                }
                if(c15.isChecked()){
                    s15 = c15.getText().toString() + ", ";
                }
                else{
                    s15 = "";
                }
                if(c16.isChecked()){
                    s16 = c16.getText().toString() + ", ";
                }
                else{
                    s16 = "";
                }
                if(c17.isChecked()){
                    s17 = c17.getText().toString() + ", ";
                }
                else{
                    s17 = "";
                }
                if(c18.isChecked()){
                    s18 = c18.getText().toString() + ", ";
                }
                else{
                    s18 = "";
                }
                if(c19.isChecked()){
                    s19 = c19.getText().toString() + ", ";
                }
                else{
                    s19 = "";
                }
                support_needed = s7 + s8 + s9 + s10 + s11 + s12 + s13 + s14 + s15 + s16 + s17 + s18 + s19;
                covid_self = assm_spinner.getSelectedItem().toString();
                Log.d(TAG, "city " + govt_ben);
                if(schema_str=="null"||otherproblem_str=="null"||suggestion_str=="null"||othersupportreceive_str=="null"){
                    Toast.makeText(getActivity().getApplicationContext(),"Data not saved",Toast.LENGTH_SHORT);
                }else {
                    awarenessDB.addData(govt_ben,covid_know,lock_know,support_needed,covid_self,schema_str,otherproblem_str,suggestion_str,othersupportreceive_str);
                    save.setClickable(false);
                    ((questions)getActivity()).selectTab(3);
                    Toast.makeText(getActivity(),"Awareness Data added successfully",Toast.LENGTH_SHORT).show();
                    ((questions)getActivity()).selectTab(3);

                }

            }
        });
        return root;
    }
}
