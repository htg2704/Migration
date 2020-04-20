package com.example.migration.Questions.ui.main;

import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.migration.Database.AwarenessDB;
import com.example.migration.Database.MigrationDB;
import com.example.migration.Database.MyDB;
import com.example.migration.Database.PlanDB;
import com.example.migration.R;

import static android.content.ContentValues.TAG;

public class PlanFragment extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";


    public static PlanFragment newInstance(int index) {
        PlanFragment fragment = new PlanFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(ARG_SECTION_NUMBER, index);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {

        final PlanDB planDB = new PlanDB(getActivity().getApplicationContext());
        final MigrationDB migrationDB = new MigrationDB(getActivity().getApplicationContext());
        final MyDB myDB = new MyDB(getActivity().getApplicationContext());
        final AwarenessDB awarenessDB = new AwarenessDB(getActivity().getApplicationContext());

        final View root = inflater.inflate(R.layout.fragment_plan, container, false);

        final Spinner support_after = (Spinner) root.findViewById(R.id.lockdown_support_spinner);
        ArrayAdapter<CharSequence> support_after_adapter = ArrayAdapter.createFromResource(getContext(), R.array.work_array, android.R.layout.simple_spinner_item);
        support_after_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        support_after.setAdapter(support_after_adapter);
        final Spinner skill_spinner = (Spinner) root.findViewById(R.id.skill_upgrade_spinner);
        ArrayAdapter<CharSequence> skill_adapter = ArrayAdapter.createFromResource(getContext(), R.array.india_cities, android.R.layout.simple_spinner_item);
        skill_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        skill_spinner.setAdapter(skill_adapter);
        final Spinner live_spinner = (Spinner) root.findViewById(R.id.livelihhod_spinner);
        ArrayAdapter<CharSequence> live_adapter = ArrayAdapter.createFromResource(getContext(), R.array.work_duration_array, android.R.layout.simple_spinner_item);
        live_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        live_spinner.setAdapter(live_adapter);
        final Spinner training_spinner = (Spinner) root.findViewById(R.id.training_spinner);
        ArrayAdapter<CharSequence> training_adapter = ArrayAdapter.createFromResource(getContext(), R.array.day_wage_array, android.R.layout.simple_spinner_item);
        training_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        training_spinner.setAdapter(training_adapter);

        Button save = root.findViewById(R.id.save_plan);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Cursor personal,migration,plan,awareness;

                Switch where,skill,safety,onestop,housing,health,school,distant;

                String where_for_job,skill_need,support_lockdown,safety_net, one_stop, distant_work,affordable_housing,healthcare,schooling, skill_upgrade,
               availability_for_training, present_livelihood;

                where = root.findViewById(R.id.where_to_go_switch);
                skill = root.findViewById(R.id.skill_switch);
                safety = root.findViewById(R.id.safety_switch);
                onestop = root.findViewById(R.id.one_stop_switch);
                housing = root.findViewById(R.id.housing_switch);
                health = root.findViewById(R.id.healthcare_switch);
                school = root.findViewById(R.id.school_switch);
                distant = root.findViewById(R.id.distant_switch);


                support_lockdown = support_after.getSelectedItem().toString();
                skill_upgrade = skill_spinner.getSelectedItem().toString();
                availability_for_training = training_spinner.getSelectedItem().toString();
                present_livelihood = live_spinner.getSelectedItem().toString();
                if(where.isChecked()){
                    where_for_job = "Yes";
                }
                else{
                    where_for_job = "No";
                }
                if(skill.isChecked()){
                    skill_need = "Yes";
                }
                else{
                    skill_need = "No";
                }
                if(safety.isChecked()){
                    safety_net = "Yes";
                }
                else{
                    safety_net = "No";
                }
                if(onestop.isChecked()){
                    one_stop = "Yes";
                }
                else{
                    one_stop = "No";
                }
                if(housing.isChecked()){
                    affordable_housing = "Yes";
                }
                else{
                    affordable_housing = "No";
                }
                if(health.isChecked()){
                    healthcare = "Yes";
                }
                else{
                    healthcare = "No";
                }
                if(school.isChecked()){
                    schooling = "Yes";
                }
                else{
                    schooling = "No";
                }
                if(distant.isChecked()){
                    distant_work = "Yes";
                }
                else{
                    distant_work = "No";
                }
                Log.d(TAG, "city " + where);
                planDB.addData( where_for_job,skill_need,support_lockdown,safety_net, one_stop, distant_work,affordable_housing,
                        healthcare,schooling, skill_upgrade,availability_for_training, present_livelihood);

                where.setChecked(false);
                onestop.setChecked(false);
                housing.setChecked(false);
                health.setChecked(false);
                school.setChecked(false);
                distant.setChecked(false);
                safety.setChecked(false);
                skill.setChecked(false);

                personal = myDB.getLastData();
                migration = migrationDB.getLastData();
                awareness = awarenessDB.getLastData();
                plan = planDB.getLastData();





            }
        });
        return root;
    }

}
