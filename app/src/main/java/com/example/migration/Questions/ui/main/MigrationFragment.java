package com.example.migration.Questions.ui.main;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;

import com.example.migration.Database.MigrationDB;
import com.example.migration.Database.MyDB;
import com.example.migration.R;

import static android.content.ContentValues.TAG;


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

        final MigrationDB migrationDB = new MigrationDB(getActivity().getApplicationContext());

        final View root = inflater.inflate(R.layout.fragment_migration, container, false);
        final Spinner work_spinner = (Spinner) root.findViewById(R.id.nature_of_work_spinner);
        ArrayAdapter<CharSequence> work_adapter = ArrayAdapter.createFromResource(getContext(), R.array.work_array, android.R.layout.simple_spinner_item);
        work_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        work_spinner.setAdapter(work_adapter);
        final Spinner l_spinner = (Spinner) root.findViewById(R.id.location_spinner);
        ArrayAdapter<CharSequence> l_adapter = ArrayAdapter.createFromResource(getContext(), R.array.india_cities, android.R.layout.simple_spinner_item);
        l_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        l_spinner.setAdapter(l_adapter);
        final Spinner period_spinner = (Spinner) root.findViewById(R.id.period_spinner);
        ArrayAdapter<CharSequence> period_adapter = ArrayAdapter.createFromResource(getContext(), R.array.work_duration_array, android.R.layout.simple_spinner_item);
        period_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        period_spinner.setAdapter(period_adapter);
        final Spinner wage_spinner = (Spinner) root.findViewById(R.id.wage_spinner);
        ArrayAdapter<CharSequence> wage_adapter = ArrayAdapter.createFromResource(getContext(), R.array.day_wage_array, android.R.layout.simple_spinner_item);
        wage_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        wage_spinner.setAdapter(wage_adapter);
        final Spinner benefit_spinner = (Spinner) root.findViewById(R.id.other_benefit_spinner);
        ArrayAdapter<CharSequence> benefit_adapter = ArrayAdapter.createFromResource(getContext(), R.array.benefits_array, android.R.layout.simple_spinner_item);
        benefit_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        benefit_spinner.setAdapter(benefit_adapter);
        final Spinner challenge_spinner = (Spinner) root.findViewById(R.id.challenge_spinner);
        ArrayAdapter<CharSequence> challenge_adapter = ArrayAdapter.createFromResource(getContext(), R.array.challenges_array, android.R.layout.simple_spinner_item);
        challenge_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        challenge_spinner.setAdapter(challenge_adapter);

        final Button save = root.findViewById(R.id.save_migration);


        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText employer,employer_contact;
                employer = (EditText) root.findViewById(R.id.employer_name);
                employer_contact = (EditText) root.findViewById(R.id.employer_CON_NO);
                String nature_str,loc,period,wage,employer_str,other,challenges;
                Double mobile_no_employer;

                employer_str = "";
                mobile_no_employer = 0.0;

                nature_str = work_spinner.getSelectedItem().toString();
                if(TextUtils.isEmpty(employer.getText().toString())){
                    employer.setError("This can't be empty");
                    employer_str = "null";
                }
                else{
                    employer_str = employer.getText().toString();

                }
                if(TextUtils.isEmpty(employer_contact.getText().toString())){
                    employer_contact.setError("This can't be empty");
                    mobile_no_employer = 0.0;
                }
                else{
                    mobile_no_employer = Double.parseDouble(employer_contact.getText().toString());
                }
                loc = l_spinner.getSelectedItem().toString();
                period = period_spinner.getSelectedItem().toString();
                wage = wage_spinner.getSelectedItem().toString();
                other = benefit_spinner.getSelectedItem().toString();
                challenges = challenge_spinner.getSelectedItem().toString();
                Log.d(TAG, "city " + challenges);
                if(employer_str=="null"||mobile_no_employer ==0.0){
                    Toast.makeText(getActivity().getApplicationContext(),"Data not saved",Toast.LENGTH_SHORT);
                }else {
                    migrationDB.addData(nature_str,loc,period,wage,employer_str,mobile_no_employer,other,challenges);
                }

                employer.setText("");
                employer_contact.setText("");
                Toast.makeText(getActivity().getApplicationContext(),"Data added successfully",Toast.LENGTH_SHORT);
                save.setEnabled(false);

            }
        });
        return root;
    }
}
